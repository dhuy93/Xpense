/**
 * 
 */
package com.huyld.xpense.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyld.xpense.model.Balance;
import com.huyld.xpense.repository.BalanceRepository;

/**
 * @author ldhuy
 * Craeted on 23/10/2016
 *
 */
@Service
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	private BalanceRepository balanceRepository;

	/* (non-Javadoc)
	 * @see com.huyld.xpense.service.BalanceService#findBalanceByAccountAndCurrency(int, java.lang.String)
	 */
	@Override
	public Balance findBalanceByAccountAndCurrency(int accountId, String currencyId) {
		return balanceRepository.findBalanceByAccountAndCurrency(accountId, currencyId);
	}

}
