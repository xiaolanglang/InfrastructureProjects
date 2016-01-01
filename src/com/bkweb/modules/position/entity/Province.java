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
 * Province entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "base_province")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Province extends PositionEntity<Province> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Nation nation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "state_id")
	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

}