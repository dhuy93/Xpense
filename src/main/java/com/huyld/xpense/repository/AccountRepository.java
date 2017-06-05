/**
 * 
 */
package com.huyld.xpense.repository;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.huyld.xpense.model.Account;

/**
 * @author ldhuy
 * Created on 15/10/2016
 *
 */
@Component
public interface AccountRepository {

	public Account findAccountById(int accountId);
	
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
