package com.myschool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address", schema = "myschool")
public class AddressEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId;

	@Column(name = "HOUSENO")
	private String houseNum;

	@Column(name = "STREET")
	private String street;

	@Column(name = "VILLAGE")
	private String village;

	@Column(name = "LANDMARK")
	private String landmark;

	@Column(name = "MANDAL")
	private String mandal;

	@Column(name = "DISTRICT")
	private String district;

	@Column(name = "STATE")
	private String state;

	@Column(name = "PINCODE")
	private String pincode;

	@Column(name = "ISACTIVE")
	private Boolean isActive;

//	@OneToOne(mappedBy = "address")
//	private SchoolEntity schoolEntity;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

//	public SchoolEntity getSchoolEntity() {
//		return schoolEntity;
//	}
//
//	public void setSchoolEntity(SchoolEntity schoolEntity) {
//		this.schoolEntity = schoolEntity;
//	}

}
