package com.bkweb.modules.position.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "base_city")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class City extends PositionEntity<City> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Province province;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "province_id")
	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

}