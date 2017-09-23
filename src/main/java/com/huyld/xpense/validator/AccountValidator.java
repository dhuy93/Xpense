/**
 * 
 */
package com.huyld.xpense.validator;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.huyld.xpense.model.Account;
import com.huyld.xpense.model.Balance;
import com.huyld.xpense.util.SecurityUtil;

/**
 * @author ldhuy
 *
 */
@Component
public class AccountValidator implements Validator {

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Account.class.equals(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Account account = (Account) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountName", "validation.account.accountName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currency.encryptedId", "validation.currency.encryptedId.required");
		try {
			account.setLastModified(Timestamp.valueOf(SecurityUtil.decrypt(account.getLastModifiedStr())));
		} catch (IllegalArgumentException e) {
			errors.rejectValue("lastModifiedStr", "validation.common.lastModifiedStr.invalid");
			e.printStackTrace();
		}
		Balance balance = account.getBalance();
		balance.setStartAmount(new BigDecimal(balance.getStartAmountStr()));
		account.setBalance(balance);
	}

}
