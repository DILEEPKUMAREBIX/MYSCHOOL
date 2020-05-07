package com.myschool.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "school", schema = "myschool")
public class SchoolEntity extends AuditingEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated product ID")
	private Long schoolId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "TYPE")
	private Long typeId;

	// @Column(name = "TYPE")
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "TYPE", insertable = false, updatable = false)
	private CMValueEntity type;

	@Column(name = "ISACTIVE")
	private Boolean isActive;
	
	@Column(name = "ANNIVERSARY")
	private Date anniversary;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "ADDRESSID")
	private AddressEntity address;

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public CMValueEntity getType() {
		return type;
	}

	public void setType(CMValueEntity type) {
		this.type = type;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

}
