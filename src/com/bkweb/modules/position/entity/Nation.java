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
 * Nation entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "base_nation")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Nation extends PositionEntity<Nation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Continent continent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delta_id")
	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

}