/**
 * 
 */
package com.huyld.xpense.service.account;

import java.util.Collection;
import java.util.Map;

import com.huyld.xpense.model.Account;

/**
 * @author ldhuy
 *
 */
public interface AccountService {

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
}
