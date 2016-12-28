/**
 * 
 */
package com.huyld.xpense.service;

import com.huyld.xpense.model.Balance;

/**
 * @author ldhuy
 * Created on 23/10/2016
 *
 */
public interface BalanceService {

	public Balance findBalanceByAccountAndCurrency(int accountId, String currencyId);
}
