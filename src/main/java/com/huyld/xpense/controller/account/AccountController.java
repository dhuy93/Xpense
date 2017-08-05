/**
 * 
 */
package com.huyld.xpense.controller.account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huyld.xpense.model.Account;
import com.huyld.xpense.model.Currency;
import com.huyld.xpense.service.account.AccountService;
import com.huyld.xpense.util.GlobalUtil;
import com.huyld.xpense.util.SecurityUtil;

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

	private int pageSize = 0;

	/**
	 * Display list of accounts and their balance
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/")
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

		// Add account list to model
//		model.addAttribute("accountList", accountList);
		
		return "dashboard/account/account-list";
	}

	@RequestMapping(value = "/edit/{encryptedId}/{currencyEncryptedId}")
	private String editAccount(@PathVariable("encryptedId") String accountEncryptedIdStr, @PathVariable("currencyEncryptedId") String currencyEncryptedIdStr, Model model) {
		String accountIdStr = SecurityUtil.decrypt(accountEncryptedIdStr);
		String currencyIdStr = SecurityUtil.decrypt(currencyEncryptedIdStr);
		int accountId;
		try {
			accountId = Integer.valueOf(accountIdStr);
		} catch (NumberFormatException e) {
			System.err.println("Couldn't parse account ID/currency ID.");
			e.printStackTrace();
			model.addAttribute("errorMsg", "Invalid ID");
			return "error/custom_error";
		}
		Map<String, Object> params = new HashMap<>();
		params.put("accountId", accountId);
		params.put("currencyId", currencyIdStr);
		Account account = accountService.findAccountByIdAndCurrencyId(params);
		account.setEncryptedId(accountEncryptedIdStr);
		account.getCurrency().setEncryptedId(currencyEncryptedIdStr);
		model.addAttribute("account", account);

		return "dashboard/account/account-edit";
	}

}
