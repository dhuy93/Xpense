/**
 * 
 */
package com.huyld.xpense.repository;

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
}
