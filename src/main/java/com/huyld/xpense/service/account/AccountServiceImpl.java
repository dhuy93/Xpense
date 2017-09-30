/**
 * 
 */
package com.huyld.xpense.service.account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
	 * @see com.huyld.xpense.service.AccountService#findAccountByIdAndCurrencyId(java.util.Map)
	 */
	@Override
	public Account findAccountByIdAndCurrencyId(int accountId, String currencyId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("currencyId", currencyId);
		return accountRepository.findAccountByIdAndCurrencyId(params);
	}

	@Override
	public Collection<Account> findAllAccountByUserId(int userId) {
		return accountRepository.findAllAccountByUserId(userId);
	}

	@Override
	public Collection<Account> findAllAccountByUserName(String username) {
		return accountRepository.findAllAccountByUserName(username);
	}

	@Override
	public int addNewAccountAndBalance(Account account) {
		return accountRepository.addNewAccountAndBalance(account);
	}

	@Override
	public int addNewBalanceForExistingAccount(Account account) {
		return accountRepository.addNewBalanceForExistingAccount(account);
	}

	@Override
	public int updateAccount(Account account) {
		return accountRepository.updateAccount(account);
	}

}
