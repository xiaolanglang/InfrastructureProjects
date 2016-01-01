package com.bkweb.modules.attraction.entity;

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
import com.bkweb.modules.position.entity.Country;

/**
 * Attractions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "base_scenic_spots")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Attraction extends DataEntity<Attraction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private City city;
	private Country country;
	private String name;
	private String hide;
	private String forPeople;
	private String type;
	private String place;
	private String imgUrl;
	private String title;

	// Constructors

	/** default constructor */
	public Attraction() {
	}

	/** full constructor */
	public Attraction(City city, Country country, String name, String hide, String forPeople, String type,
			String place, String imgUrl, String title) {
		this.city = city;
		this.country = country;
		this.name = name;
		this.hide = hide;
		this.forPeople = forPeople;
		this.type = type;
		this.place = place;
		this.imgUrl = imgUrl;
		this.title = title;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_id")
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "name_zh", length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "hide", length = 1)
	public String getHide() {
		return this.hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	@Column(name = "for_people", length = 100)
	public String getForPeople() {
		return this.forPeople;
	}

	public void setForPeople(String forPeople) {
		this.forPeople = forPeople;
	}

	@Column(name = "type", length = 100)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "place", length = 100)
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Column(name = "imgUrl", length = 255)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}