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
public class Income {

	private int incomeId;
	private String payee;
	private Date date;
	private int categoryId;
	private int accountId;
	private String description;
	private BigDecimal amount;
	private String amountStr;
	private String currencyId;
	private boolean isDebt;
	private Date deadline;
	private boolean cleared;
	private int payFor;
	private boolean delFlg;
	private Timestamp lastModified;

	/**
	 * @return the incomeId
	 */
	public int getIncomeId() {
		return incomeId;
	}

	/**
	 * @param incomeId
	 *            the incomeId to set
	 */
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
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
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

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
	 * @return the isDebt
	 */
	public boolean isDebt() {
		return isDebt;
	}

	/**
	 * @param isDebt
	 *            the isDebt to set
	 */
	public void setDebt(boolean isDebt) {
		this.isDebt = isDebt;
	}

	/**
	 * @return the deadline
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * @param deadline
	 *            the deadline to set
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * @return the cleared
	 */
	public boolean isCleared() {
		return cleared;
	}

	/**
	 * @param cleared
	 *            the cleared to set
	 */
	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	/**
	 * @return the payFor
	 */
	public int getPayFor() {
		return payFor;
	}

	/**
	 * @param payFor
	 *            the payFor to set
	 */
	public void setPayFor(int payFor) {
		this.payFor = payFor;
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
