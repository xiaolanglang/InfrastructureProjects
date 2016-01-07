package com.bkweb.modules.menu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import com.bkweb.common.entity.DataEntity;

/**
 * MenuSort entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu_sort")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MenuSort extends DataEntity<MenuSort> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private MenuSort parent;
	private String name;
	private String nameEn;
	private String imageUrl;
	private String imageLocal;

	// Constructors

	/** default constructor */
	public MenuSort() {
	}

	public MenuSort(MenuSort parent) {
		this.parent = parent;
	}

	/** full constructor */
	public MenuSort(MenuSort parent, String name, String nameEn, String imageUrl, String imageLocal) {
		this.parent = parent;
		this.name = name;
		this.nameEn = nameEn;
		this.imageUrl = imageUrl;
		this.imageLocal = imageLocal;
	}

	@Column(name = "name", length = 20)
	public String getName() {
		return this.name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public MenuSort getParent() {
		return parent;
	}

	public void setParent(MenuSort parent) {
		this.parent = parent;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "nameEn", length = 20)
	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@Column(name = "image_url")
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Column(name = "image_local")
	public String getImageLocal() {
		return this.imageLocal;
	}

	public void setImageLocal(String imageLocal) {
		this.imageLocal = imageLocal;
	}

}