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
 * Country entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "base_country")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Country extends PositionEntity<Country> implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private City city;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}