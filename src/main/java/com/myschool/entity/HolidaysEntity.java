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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "holidays")
public class HolidaysEntity extends AuditingEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long holidayId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "HOLIDAY_DATE")
	private Date holidayDate;
	
	@Column(name = "DESCRIPTION")
	private  String Description;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	
	@Column(name = "SCHOOLID")
	private Long schoolIdno;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SCHOOLID", insertable = false, updatable = false)
	private SchoolEntity schoolName;

	public Long getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(Long holidayId) {
		this.holidayId = holidayId;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Long getSchoolIdno() {
		return schoolIdno;
	}

	public void setSchoolIdno(Long schoolIdno) {
		this.schoolIdno = schoolIdno;
	}

	public SchoolEntity getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(SchoolEntity schoolName) {
		this.schoolName = schoolName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
