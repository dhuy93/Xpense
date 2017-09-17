/**
 * 
 */
package com.huyld.xpense.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ldhuy
 * Created on 16/10/2016
 *
 */
public class Balance {

	private int accountId;
	private String currencyId;
	private BigDecimal startAmount;
	private BigDecimal amount;
	private boolean delFlg;
	private Date lastModified;

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the currencyId
	 */
	public String getCurrencyId() {
		return currencyId;
	}

	/**
	 * @return the startAmount
	 */
	public BigDecimal getStartAmount() {
		return startAmount;
	}

	/**
	 * @param startAmount the startAmount to set
	 */
	public void setStartAmount(BigDecimal startAmount) {
		this.startAmount = startAmount;
	}

	/**
	 * @param currencyId
	 *            the currencyId to set
	 */
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the delFlg
	 */
	public boolean isDelFlg() {
		return delFlg;
	}

	/**
	 * @param delFlg
	 *            the delFlg to set
	 */
	public void setDelFlg(boolean delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}
