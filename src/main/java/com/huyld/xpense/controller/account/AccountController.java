/**
 * 
 */
package com.huyld.xpense.controller.account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huyld.xpense.model.Account;
import com.huyld.xpense.service.account.AccountService;

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

	@RequestMapping(value="/")
	private String accountList(Model model) {
		
		// Get list of accounts belongs to user
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Collection<Account> accounts = accountService.findAllAccountByUserName(loggedInUser.getUsername());
		List<Account> accountList = new ArrayList<Account>(accounts);
		
		// Add account list to model
		model.addAttribute("accountList", accountList);
		
		return "dashboard/account/account-list";
	}
}
