package com.myschool.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address", schema = "myschool")
@Getter
@Setter
public class AddressEntity extends AuditingEntity {

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

}
