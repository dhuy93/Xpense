/**
 * 
 */
package com.huyld.xpense.model;

import java.sql.Timestamp;

/**
 * @author ldhuy 
 * Created on 15/10/2016
 *
 */
public class Account {

	private int accountId;
	private String accountName;
	private boolean delFlg;
	private User user;
	private Balance balance;
	private Currency currency;
	private String encryptedId;
	private Timestamp createdDate;
	private Timestamp lastModified;
	private String lastModifiedStr;

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
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName
	 *            the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the balance
	 */
	public Balance getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Balance balance) {
		this.balance = balance;
	}

	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	/**
	 * @return the encryptedId
	 */
	public String getEncryptedId() {
		return encryptedId;
	}

	/**
	 * @param encryptedId the encryptedId to set
	 */
	public void setEncryptedId(String encryptedId) {
		this.encryptedId = encryptedId;
	}

	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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

	/**
	 * @return the lastModifiedStr
	 */
	public String getLastModifiedStr() {
		return lastModifiedStr;
	}

	/**
	 * @param lastModifiedStr the lastModifiedStr to set
	 */
	public void setLastModifiedStr(String lastModifiedStr) {
		this.lastModifiedStr = lastModifiedStr;
	}
}