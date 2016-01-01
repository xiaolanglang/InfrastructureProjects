package com.bkweb.modules.position.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.bkweb.common.entity.DataEntity;

@MappedSuperclass
public class PositionEntity<E> extends DataEntity<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String name;
	protected String nameEn;

	@Column(name = "name_zh", length = 15)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "name_en", length = 20)
	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

}
