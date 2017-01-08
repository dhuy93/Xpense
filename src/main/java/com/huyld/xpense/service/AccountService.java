/**
 * 
 */
package com.huyld.xpense.service;

import java.util.Collection;

import com.huyld.xpense.model.Account;

/**
 * @author ldhuy
 *
 */
public interface AccountService {

	public Account findAccountById(int accountId);
	
	/**
	 * Find all accounts belong to a specific user
	 * @param userId
	 * @return
	 */
	public Collection<Account> findAllAccountByUserId(int userId);
}
