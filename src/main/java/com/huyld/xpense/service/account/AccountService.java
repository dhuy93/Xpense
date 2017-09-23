/**
 * 
 */
package com.huyld.xpense.service.account;

import java.util.Collection;

import com.huyld.xpense.model.Account;

/**
 * @author ldhuy
 *
 */
public interface AccountService {

	public Account findAccountByIdAndCurrencyId(int accountId, String currencyId);

	/**
	 * Find all accounts belong to a specific user
	 * @param userId
	 * @return
	 */
	public Collection<Account> findAllAccountByUserId(int userId);

	/**
	 * Find all accounts belong to a specific user
	 * @param username
	 * @return
	 */
	public Collection<Account> findAllAccountByUserName(String username);

	/**
	 * Insert new account to database and return the number of affected row
	 * @param account
	 * @return
	 */
	public int addAccount(Account account);

	/**
	 * Update an account to database and return the number of affected row
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account);
}
