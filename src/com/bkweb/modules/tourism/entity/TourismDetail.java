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
import com.bkweb.modules.attraction.entity.Attraction;

/**
 * TourismDetail entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "travel_route_detail")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TourismDetail extends DataEntity<TourismDetail> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tourism tourism;
	private Attraction attractions;
	private Integer day;
	private Integer serialNumber;

	// Constructors

	/** default constructor */
	public TourismDetail() {
	}

	/** full constructor */
	public TourismDetail(Tourism tourism, Attraction attractions, Integer day, Integer serialNumber) {
		this.tourism = tourism;
		this.attractions = attractions;
		this.day = day;
		this.serialNumber = serialNumber;
	}

	// Property accessors

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "travel_route_id")
	public Tourism getTourism() {
		return this.tourism;
	}

	public void setTourism(Tourism tourism) {
		this.tourism = tourism;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "scenic_spot_id")
	public Attraction getAttractions() {
		return this.attractions;
	}

	public void setAttractions(Attraction attractions) {
		this.attractions = attractions;
	}

	@Column(name = "day")
	public Integer getDay() {
		return this.day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Column(name = "serial_number")
	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

}