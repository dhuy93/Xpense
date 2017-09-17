/**
 * 
 */
package com.huyld.xpense.service.currency;

import java.util.Collection;

import com.huyld.xpense.model.Currency;

/**
 * @author ldhuy
 *
 */
public interface CurrencyService {

	public Collection<Currency> findAllCurrency();
}
