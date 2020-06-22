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
@Table(name = "leaves")
public class LeavesEntity extends AuditingEntity{

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long leaveId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LEAVE_DATE")
	private Date leaveDate;
	
	@Column(name = "DESCRIPTION")
	private  String Description;
	
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	
	@Column(name = "SCHOOLID")
	private Long schoolIdno;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SCHOOLID", insertable = false, updatable = false)
	private SchoolEntity schoolName;
	
	
	@Column(name = "USERID")
	private Long userId;
	
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USERID", insertable = false, updatable = false)
	private UserEntity userName;

	public Long getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Long leaveId) {
		this.leaveId = leaveId;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserEntity getUserName() {
		return userName;
	}

	public void setUserName(UserEntity userName) {
		this.userName = userName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	
}
