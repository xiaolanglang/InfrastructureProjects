package com.bkweb.modules.tourism.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;

import com.bkweb.common.entity.DataEntity;

/**
 * Tourism entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "travel_route")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Tourism extends DataEntity<Tourism> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String hide;
	private String type;// 类型
	private String[] theme;
	private String themes;
	private Double adultPrice;
	private Double childrenPrice;
	private Double discount;
	private Integer days;
	private String subtitle;
	private String[] startPlace;
	private String startPlaces;
	private String recommend;
	private String[] status;// 状态
	private String statuses;

	// Constructors

	/** default constructor */
	public Tourism() {
	}

	@Column(name = "theme", length = 100)
	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}

	@Column(name = "status", length = 100)
	public String getStatuses() {
		return statuses;
	}

	public void setStatuses(String statuses) {
		this.statuses = statuses;
	}

	@Transient
	public String[] getStatus() {
		return status;
	}

	public void setStatus(String[] status) {
		this.status = status;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "hide", length = 1)
	public String getHide() {
		return this.hide;
	}

	public void setHide(String hide) {
		this.hide = hide;
	}

	@Column(name = "travel_type", length = 32)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Transient
	public String[] getTheme() {
		return this.theme;
	}

	public void setTheme(String[] theme) {
		this.theme = theme;
	}

	@Column(name = "adult_price", precision = 8)
	public Double getAdultPrice() {
		return this.adultPrice;
	}

	public void setAdultPrice(Double adultPrice) {
		this.adultPrice = adultPrice;
	}

	@Column(name = "children_price", precision = 8)
	public Double getChildrenPrice() {
		return this.childrenPrice;
	}

	public void setChildrenPrice(Double childrenPrice) {
		this.childrenPrice = childrenPrice;
	}

	@Column(name = "discount", precision = 5, scale = 1)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "days")
	public Integer getDays() {
		return this.days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@Column(name = "subtitle", length = 100)
	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Transient
	public String[] getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String[] startPlace) {
		this.startPlace = startPlace;
	}

	@Column(name = "place_of_start", length = 320)
	public String getStartPlaces() {
		return startPlaces;
	}

	public void setStartPlaces(String startPlaces) {
		this.startPlaces = startPlaces;
	}

	@Column(name = "recommend", length = 500)
	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

}