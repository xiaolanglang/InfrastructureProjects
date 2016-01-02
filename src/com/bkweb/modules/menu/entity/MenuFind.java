package com.bkweb.modules.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import com.bkweb.common.entity.DataEntity;

/**
 * MenuFind entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "menu_find")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MenuFind extends DataEntity<MenuFind> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String subTitle;
	private String image;
	private String keyword;
	private String hide;
	private String localUrl;

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

	@Column(name = "title", length = 20)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "subtitle", length = 20)
	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	@Column(name = "image")
	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name = "keyword", length = 50)
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "hide", length = 1)
	public String getHide() {
		return hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	@Column(name = "localUrl", length = 255)
	public String getLocalUrl() {
		return localUrl;
	}

	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

}