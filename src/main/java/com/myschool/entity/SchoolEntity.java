package com.myschool.entity;

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

	// @Column(name = "TYPE")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TYPE", insertable = false, updatable = false)
	private CMValueEntity type;

	@Column(name = "ISACTIVE")
	private Boolean isActive;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "ADDRESSID")
	private AddressEntity address;

}
