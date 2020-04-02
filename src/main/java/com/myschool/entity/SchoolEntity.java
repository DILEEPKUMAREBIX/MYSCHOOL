package com.myschool.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "school", schema = "myschool")
@Getter
@Setter
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

	@Column(name = "ISACTIVE")
	private Boolean isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "ADDRESSID")
	private AddressEntity address;

//	public Long getSchoolId() {
//		return schoolId;
//	}
//
//	public void setSchoolId(Long schoolId) {
//		this.schoolId = schoolId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Long getTypeId() {
//		return typeId;
//	}
//
//	public void setTypeId(Long typeId) {
//		this.typeId = typeId;
//	}
//
//	public Boolean getIsActive() {
//		return isActive;
//	}
//
//	public void setIsActive(Boolean isActive) {
//		this.isActive = isActive;
//	}
//
//	public AddressEntity getAddress() {
//		return address;
//	}
//
//	public void setAddress(AddressEntity address) {
//		this.address = address;
//	}

}
