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
public class Tag {

	private int tagId;
	private String name;
	private boolean delFlg;
	private Timestamp lastModified;

	/**
	 * @return the tagId
	 */
	public int getTagId() {
		return tagId;
	}

	/**
	 * @param tagId
	 *            the tagId to set
	 */
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
