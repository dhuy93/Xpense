/**
 * 
 */
package com.huyld.xpense.model;

import java.sql.Timestamp;

/**
 * @author ldhuy
 * Created on 16/10/2016
 *
 */
public class Currency {

	private String currencyId;
	private String currencyName;
	private boolean delFlg;
	private String encryptedId;
	private Timestamp lastModified;

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
	 * @return the currencyName
	 */
	public String getCurrencyName() {
		return currencyName;
	}

	/**
	 * @param currencyName
	 *            the name to set
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
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
