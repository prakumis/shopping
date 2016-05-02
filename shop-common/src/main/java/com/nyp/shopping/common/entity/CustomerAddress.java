package com.nyp.shopping.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Address
 *
 */
@Entity
@Table(name = "CUSTOMER_ADDRESS")
public class CustomerAddress implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	private static final long serialVersionUID = 1L;

	@Column(name = "ADDRESS_LINE_1", length = 50)
	private String addressLine1;

	@Column(name = "ADDRESS_LINE_2", length = 50)
	private String addressLine2;

	@Column(name = "ADDRESS_LINE_3", length = 50)
	private String addressLine3;

	@Column(name = "CITY_DISTRICT", length = 50)
	private String cityDistrict;

	@Column(name = "STATE", length = 50)
	private String state;

	@Column(name = "COUNTRY", length = 50)
	private String country;

	@Column(name = "ZIPCODE", length = 6)
	private Integer zipCode;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	public CustomerAddress() {
		super();
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return this.addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCityDistrict() {
		return this.cityDistrict;
	}

	public void setCityDistrict(String cityDistrict) {
		this.cityDistrict = cityDistrict;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
