package com.bkweb.modules.menu.entity;

import com.bkweb.common.entity.DataEntity;

/**
 * MenuFind entity. @author MyEclipse Persistence Tools
 */

public class MenuFind extends DataEntity<MenuFind> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String subTitle;
	private String image;
	private String keyword;
	private String hide;

	// Constructors

	/** default constructor */
	public MenuFind() {
	}

	/** full constructor */
	public MenuFind(String title, String subTitle, String image, String keyword) {
		this.title = title;
		this.subTitle = subTitle;
		this.image = image;
		this.keyword = keyword;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getHide() {
		return hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

}