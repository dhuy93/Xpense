/**
 * 
 */
package com.huyld.xpense.service.account;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyld.xpense.model.Account;
import com.huyld.xpense.repository.AccountRepository;

/**
 * @author ldhuy
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	/* (non-Javadoc)
	 * @see com.huyld.xpense.service.AccountService#findAccountById(int)
	 */
	@Override
	public Account findAccountById(int accountId) {
		return accountRepository.findAccountById(accountId);
	}

	@Override
	public Collection<Account> findAllAccountByUserId(int userId) {
		return accountRepository.findAllAccountByUserId(userId);
	}

}
