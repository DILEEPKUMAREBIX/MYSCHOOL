package com.myschool.Dto;

import java.io.Serializable;

public class CMGroupValuesDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Long CmGroupId;
	String CmGroupName;
	String CmGroupDescription;
	Long groupId;
	String name;
	String description;
	boolean isActive;
	
	
	
	
	public CMGroupValuesDto() {
	}




	public CMGroupValuesDto(Long cmGroupId, String cmGroupName, String cmGroupDescription, Long groupId, String name,
			String description, boolean isActive) {
		super();
		CmGroupId = cmGroupId;
		CmGroupName = cmGroupName;
		CmGroupDescription = cmGroupDescription;
		this.groupId = groupId;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
	}




	public Long getCmGroupId() {
		return CmGroupId;
	}




	public void setCmGroupId(Long cmGroupId) {
		CmGroupId = cmGroupId;
	}




	public String getCmGroupName() {
		return CmGroupName;
	}




	public void setCmGroupName(String cmGroupName) {
		CmGroupName = cmGroupName;
	}




	public String getCmGroupDescription() {
		return CmGroupDescription;
	}




	public void setCmGroupDescription(String cmGroupDescription) {
		CmGroupDescription = cmGroupDescription;
	}




	public Long getGroupId() {
		return groupId;
	}




	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public boolean isActive() {
		return isActive;
	}




	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
