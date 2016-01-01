package com.bkweb.modules.position.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

/**
 * Continent entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "base_continent")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Continent extends PositionEntity<Continent> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}