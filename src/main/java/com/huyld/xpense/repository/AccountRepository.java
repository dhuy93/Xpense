/**
 * 
 */
package com.huyld.xpense.repository;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.huyld.xpense.model.Account;

/**
 * @author ldhuy
 * Created on 15/10/2016
 *
 */
@Component
public interface AccountRepository {

	public Account findAccountByIdAndCurrencyId(Map<String, Object> params);

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
	public int addNewAccountAndBalance(Account account);

	/**
	 * Update existing account and add new balance for it
	 * @param account
	 * @return
	 */
	public int addNewBalanceForExistingAccount(Account account);

	/**
	 * Update an account to database and return the number of affected row
	 * @param account
	 * @return
	 */
	public int updateAccount(Account account);
}
