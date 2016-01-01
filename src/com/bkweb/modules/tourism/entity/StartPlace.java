package com.bkweb.modules.tourism.entity;

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
import com.bkweb.modules.position.entity.City;

/**
 * StartPlace entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "base_place_of_start")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class StartPlace extends DataEntity<StartPlace> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private City city;
	private String name;
	private String nameEn;

	// Constructors

	/** default constructor */
	public StartPlace() {
	}

	/** full constructor */
	public StartPlace(City city) {
		this.city = city;
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

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