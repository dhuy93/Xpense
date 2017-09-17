/**
 * 
 */
package com.huyld.xpense.repository;

import java.util.Collection;
import org.springframework.stereotype.Component;

import com.huyld.xpense.model.Currency;

/**
 * @author ldhuy
 *
 */
@Component
public interface CurrencyRepository {
	
	public Collection<Currency> findAllCurrency();

}
