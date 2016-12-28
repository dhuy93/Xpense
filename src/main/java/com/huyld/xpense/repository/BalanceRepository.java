/**
 * 
 */
package com.huyld.xpense.repository;

import org.springframework.stereotype.Component;

import com.huyld.xpense.model.Balance;

/**
 * @author ldhuy
 * Created on 23/10/2016
 *
 */
@Component
public interface BalanceRepository {

	public Balance findBalanceByAccountAndCurrency(int accountId, String currencyId);
}
