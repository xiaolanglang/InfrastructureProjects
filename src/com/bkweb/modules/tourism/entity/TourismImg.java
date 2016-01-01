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

/**
 * TourismImg entity. @author MyEclipse Persistence Tools
 */

@Entity
@Table(name = "travel_route_img")
@DynamicInsert(true)
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TourismImg extends DataEntity<TourismImg> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tourism tourism;
	private String url;
	private String localUrl;
	private String name;
	private Double size;
	private String cover;
	private String type;

	// Constructors

	/** default constructor */
	public TourismImg() {
	}

	/** full constructor */
	public TourismImg(Tourism tourism, String url) {
		this.tourism = tourism;
		this.url = url;
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

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "name", length = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "size", precision = 8)
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	@Column(name = "cover", length = 1)
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Column(name = "type", length = 1)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "localUrl")
	public String getLocalUrl() {
		return localUrl;
	}

	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

}