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

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="timetable",schema = "myschool")
//@Data
public class TimeTableEntity extends AuditingEntity{

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated ID")
	private Long timeTableId;

	@Temporal(TemporalType.DATE)
	@Column(name = "TIMETABLEDATE")
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date timeTableDate;

	@Column(name = "ISACTIVE")
	private Boolean isActive;

	@Column(name = "SCHOOLID")
	private Long schoolIdno;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SCHOOLID", insertable = false, updatable = false)
	private SchoolEntity schoolName;


	@Column(name = "CLASSID")
	private Long classId;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSID", insertable = false, updatable = false) 
	private CMValueEntity className;

	@Column(name = "SUBJECTID")
	private Long subjectId;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SUBJECTID", insertable = false, updatable = false) 
	private CMValueEntity subjectName;

	@Column(name = "SECTIONID")
	private Long sectionId;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "SECTIONID", insertable = false, updatable = false) 
	private CMValueEntity sectionName;

	@Column(name = "CLASSPERIODID")
	private Long classPeriodId;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSPERIODID", insertable = false, updatable = false) 
	private ClassPeriodEntity classPeriodname;

	@Column(name = "CLASSTTEACHERSUBJECTID")
	private Long classTeacherSubjctId;

	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLASSTTEACHERSUBJECTID", insertable = false, updatable = false) 
	private ClassTeacherSubjectEntity classTeacherSubjctname;

	public Long getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(Long timeTableId) {
		this.timeTableId = timeTableId;
	}

	
	public Date getTimeTableDate() {
		return timeTableDate;
	}

	public void setTimeTableDate(Date timeTableDate) {
		this.timeTableDate = timeTableDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public CMValueEntity getClassName() {
		return className;
	}

	public void setClassName(CMValueEntity className) {
		this.className = className;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public CMValueEntity getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(CMValueEntity subjectName) {
		this.subjectName = subjectName;
	}

	public Long getSectionId() {
		return sectionId;
	}

	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public CMValueEntity getSectionName() {
		return sectionName;
	}

	public void setSectionName(CMValueEntity sectionName) {
		this.sectionName = sectionName;
	}

	public Long getClassPeriodId() {
		return classPeriodId;
	}

	public void setClassPeriodId(Long classPeriodId) {
		this.classPeriodId = classPeriodId;
	}

	public ClassPeriodEntity getClassPeriodname() {
		return classPeriodname;
	}

	public void setClassPeriodname(ClassPeriodEntity classPeriodname) {
		this.classPeriodname = classPeriodname;
	}

	public Long getClassTeacherSubjctId() {
		return classTeacherSubjctId;
	}

	public void setClassTeacherSubjctId(Long classTeacherSubjctId) {
		this.classTeacherSubjctId = classTeacherSubjctId;
	}

	public ClassTeacherSubjectEntity getClassTeacherSubjctname() {
		return classTeacherSubjctname;
	}

	public void setClassTeacherSubjctname(ClassTeacherSubjectEntity classTeacherSubjctname) {
		this.classTeacherSubjctname = classTeacherSubjctname;
	}

}
