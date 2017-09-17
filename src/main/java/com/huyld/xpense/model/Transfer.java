/**
 * 
 */
package com.huyld.xpense.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ldhuy
 * Created on 23/10/2016
 *
 */
public class Transfer {

	private int transferId;
	private String payee;
	private int fromAccount;
	private int toAccount;
	private Date date;
	private String description;
	private BigDecimal amount;
	private String amountStr;
	private String currencyId;
	private boolean delFlg;
	private Timestamp lastModified;

	/**
	 * @return the transferId
	 */
	public int getTransferId() {
		return transferId;
	}

	/**
	 * @param transferId
	 *            the transferId to set
	 */
	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}

	/**
	 * @return the payee
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * @param payee
	 *            the payee to set
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}

	/**
	 * @return the fromAccount
	 */
	public int getFromAccount() {
		return fromAccount;
	}

	/**
	 * @param fromAccount
	 *            the fromAccount to set
	 */
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	/**
	 * @return the toAccount
	 */
	public int getToAccount() {
		return toAccount;
	}

	/**
	 * @param toAccount
	 *            the toAccount to set
	 */
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the amountStr
	 */
	public String getAmountStr() {
		return amountStr;
	}

	/**
	 * @param amountStr the amountStr to set
	 */
	public void setAmountStr(String amountStr) {
		this.amountStr = amountStr;
	}

	/**
	 * @return the currencyId
	 */
	public String getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param currencyId
	 *            the currencyId to set
	 */
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
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
	public Timestamp getLastModified() {
		return lastModified;
	}

	/**
	 * @param lastModified the lastModified to set
	 */
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
}
