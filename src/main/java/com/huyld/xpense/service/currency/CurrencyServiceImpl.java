/**
 * 
 */
package com.huyld.xpense.service.currency;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyld.xpense.model.Currency;
import com.huyld.xpense.repository.CurrencyRepository;

/**
 * @author ldhuy
 *
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyRepository currencyRepository;

	/* (non-Javadoc)
	 * @see com.huyld.xpense.service.currency.CurrencyService#findAllCurrency()
	 */
	@Override
	public Collection<Currency> findAllCurrency() {
		return currencyRepository.findAllCurrency();
	}

}
