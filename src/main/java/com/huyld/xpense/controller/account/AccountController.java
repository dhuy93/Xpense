/**
 * 
 */
package com.huyld.xpense.controller.account;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.huyld.xpense.model.Account;
import com.huyld.xpense.model.Balance;
import com.huyld.xpense.model.Currency;
import com.huyld.xpense.service.account.AccountService;
import com.huyld.xpense.service.balance.BalanceService;
import com.huyld.xpense.service.currency.CurrencyService;
import com.huyld.xpense.util.GlobalUtil;
import com.huyld.xpense.util.SecurityUtil;
import com.huyld.xpense.validator.AccountValidator;

/**
 * @author ldhuy
 * Created on: 01/01/2017
 *
 */
@Controller
@RequestMapping(value="/dashboard/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@Autowired
	BalanceService balanceService;

	@Autowired
	CurrencyService currencyService;

	@Autowired
	AccountValidator accountValidator;

	@Autowired
	MessageSource messageSource;

	@Autowired
	private ApplicationContext appContext;
	

	@InitBinder("account")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(accountValidator);
	}

	private int pageSize = 0;

	/**
	 * Display list of accounts and their balance
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/")
	private String accountList(@RequestParam(required = false) Integer page, Model model) {
		// Get list of accounts belongs to user
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection<Account> accounts = accountService.findAllAccountByUserName(loggedInUser.getUsername());
		List<Account> accountList = new ArrayList<Account>(accounts);

		// Encrypt IDs
		for (Account account : accountList) {
			account.setEncryptedId(SecurityUtil.encrypt(String.valueOf(account.getAccountId())));
			Currency currency = account.getCurrency();
			currency.setEncryptedId(SecurityUtil.encrypt(currency.getCurrencyId()));
		}

		// TODO: sum up all incomes and expenses of account

		PagedListHolder<Account> pagedListHolder = new PagedListHolder<Account>(accountList);
		if (pageSize == 0) {
			try {
				String pageSizeStr = GlobalUtil.getProperty("page.size");
				pageSize = Integer.valueOf(pageSizeStr);
			} catch (IOException e) {
				pageSize = 5;
				System.err.println("Couldn't load pageSize from property file. Set page size to 5 by default.");
				e.printStackTrace();
			}
		}
		pagedListHolder.setPageSize(pageSize);

		model.addAttribute("maxPages", pagedListHolder.getPageCount());
		if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
			page = 1;
			pagedListHolder.setPage(0);
			model.addAttribute("accountList", pagedListHolder.getPageList());
		} else if (page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page - 1);
			model.addAttribute("accountList", pagedListHolder.getPageList());
		}
		model.addAttribute("page", page);

		return "dashboard/account/account-list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	private String displayAccountAddForm(Model model) {
		Account account = new Account();
		account.setLastModified(new Timestamp(System.currentTimeMillis()));
		account.setLastModifiedStr(SecurityUtil.encrypt(account.getLastModified().toString()));
		model.addAttribute("account", account);

		// Settings for JSP
		populateModelAdd(model);

		return "dashboard/account/account-edit";
	}

	@RequestMapping(value = "/add/submit")
	private String addAccount(@ModelAttribute("account") @Validated Account account, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("account", account);
			populateModelAdd(model);
			return "dashboard/account/account-edit";
		}

		account.setUser(GlobalUtil.getCurrentUser());
		String currencyId = SecurityUtil.decrypt(account.getCurrency().getEncryptedId());
		account.getCurrency().setCurrencyId(currencyId);
		int successCount = 0; 
		try {
			int accountId = Integer.valueOf(SecurityUtil.decrypt(account.getEncryptedId()), 10);
			// Add new balance for existing account
			account.setAccountId(accountId);
			successCount = accountService.addNewBalanceForExistingAccount(account);
		} catch (NumberFormatException e) {
			// Could not parse the ID of the account. Thus this account is considered as 
			// new account and inserted to DB
			successCount = accountService.addNewAccountAndBalance(account);
		} catch (DuplicateKeyException e) {
			// The pair account ID - currency ID already existed in DB
			// Get error message and display on account adding form
			String msg = messageSource.getMessage("account.add.error.duplicate.currency", null, GlobalUtil.getLocale());
			model.addAttribute("msg", msg);
			model.addAttribute("msgType", "danger");
			model.addAttribute("account", account);
			populateModelAdd(model);
			return "dashboard/account/account-edit";
		} catch (Exception e) {
			// Add new account and new balance
			successCount = accountService.addNewAccountAndBalance(account);
		}

		System.out.println(successCount + " account inserted");
		return "redirect:/dashboard/account/";
	}

	@RequestMapping(value = "/edit/{encryptedId}/{currencyEncryptedId}", method = RequestMethod.GET)
	private String displayAccountEditForm(@PathVariable("encryptedId") String accountEncryptedIdStr, @PathVariable("currencyEncryptedId") String currencyEncryptedIdStr, Model model) {
		String accountIdStr = SecurityUtil.decrypt(accountEncryptedIdStr);
		String currencyId = SecurityUtil.decrypt(currencyEncryptedIdStr);
		int accountId;
		try {
			accountId = Integer.valueOf(accountIdStr);
		} catch (NumberFormatException e) {
			System.err.println("Couldn't parse account ID/currency ID.");
			e.printStackTrace();
			model.addAttribute("errorMsg", "Invalid ID");
			return "error/custom_error";
		}

		Account account = accountService.findAccountByIdAndCurrencyId(accountId, currencyId);
		account.setEncryptedId(accountEncryptedIdStr);
		account.getCurrency().setEncryptedId(SecurityUtil.encrypt(account.getCurrency().getCurrencyId()));
		account.setLastModifiedStr(SecurityUtil.encrypt(account.getLastModified().toString()));
		account.getBalance().setStartAmountStr(account.getBalance().getStartAmount().toString());
		model.addAttribute("account", account);
		Map<String, String> accountNameMap = new HashMap<String, String>();
		accountNameMap.put(accountEncryptedIdStr, account.getAccountName());
		model.addAttribute("accountList", accountNameMap);

		// Settings for JSP
		populateModelEdit(model, account);

		return "dashboard/account/account-edit";
	}

	@RequestMapping(value = "/edit/{encryptedId}/{currencyEncryptedId}/submit", method = RequestMethod.POST)
	private String updateAccount(@ModelAttribute("account") @Validated Account account, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("account", account);
			populateModelEdit(model, account);
			return "dashboard/account/account-edit";
		}

		int accountId = Integer.parseInt(SecurityUtil.decrypt(account.getEncryptedId()), 10);
		account.setAccountId(accountId);
		String currencyId = SecurityUtil.decrypt(account.getCurrency().getEncryptedId());
		Balance balance = balanceService.findBalanceByAccountAndCurrency(accountId, currencyId);
		balance.setStartAmount(account.getBalance().getStartAmount());
		account.setBalance(balance);
		account.setUser(GlobalUtil.getCurrentUser());
		int successCount = accountService.updateAccount(account);
		if (successCount == 0) {
			String msg = appContext.getMessage("account.update.error", null, null, GlobalUtil.getLocale());
			redirectAttributes.addFlashAttribute("msg", msg);
			redirectAttributes.addFlashAttribute("msgType", "alert");
		} else {
			String msg = appContext.getMessage("account.update.success", null, null, GlobalUtil.getLocale());
			redirectAttributes.addFlashAttribute("msg", msg);
			redirectAttributes.addFlashAttribute("msgType", "success");
		}
		return "redirect:/dashboard/account/";
	}

	private void populateDefaultModel(Model model) {
		// Get currency list from DB
		List<Currency> currencyList = (List<Currency>) currencyService.findAllCurrency();
		Map<String, String> currencies = new LinkedHashMap<String, String>();
		for (Currency currency : currencyList) {
			String encryptedStr = SecurityUtil.encrypt(currency.getCurrencyId());
			currencies.put(encryptedStr, currency.getName());
		}
		model.addAttribute("currencyList", currencies);
	}

	/**
	 * Load text for labels, buttons, etc
	 * Get list of accounts belong to user
	 * Set customized submit path
	 * @param model
	 */
	private void populateModelAdd(Model model) {
		// Get account list from DB
		List<Account> accountList = (List<Account>) accountService.findAllAccountByUserName(GlobalUtil.getCurrentUser().getUsername());
		Map<String, String> accountNameMap = new HashMap<String, String>();
		for (Account account : accountList) {
			String encryptedStr = SecurityUtil.encrypt(String.valueOf(account.getAccountId()));
			accountNameMap.put(encryptedStr, account.getAccountName());
		}
		model.addAttribute("accountList", accountNameMap);
		Gson gson = new Gson();
		String accountListStr = gson.toJson(accountNameMap);
		model.addAttribute("accountListJson", accountListStr);

		model.addAttribute("isEdit", false);
		model.addAttribute("submitPath", "add");
		model.addAttribute("saveBtn", appContext.getMessage("account.add.button.add", null, null, GlobalUtil.getLocale()));
		model.addAttribute("cancelBtn", appContext.getMessage("account.add.button.cancel", null, null, GlobalUtil.getLocale()));
		populateDefaultModel(model);
		// TODO: get labels from properties files
	}

	/**
	 * Load text for labels, buttons, etc
	 * Set customized submit path
	 * @param model
	 * @param account
	 */
	private void populateModelEdit(Model model, Account account) {
		model.addAttribute("isEdit", true);
		model.addAttribute("submitPath",
				"edit/" + account.getEncryptedId() + "/" + account.getCurrency().getEncryptedId());
		model.addAttribute("saveBtn", appContext.getMessage("account.edit.button.save", null, null, GlobalUtil.getLocale()));
		model.addAttribute("cancelBtn", appContext.getMessage("account.edit.button.cancel", null, null, GlobalUtil.getLocale()));
		populateDefaultModel(model);
		// TODO: get labels from properties files
	}
}
