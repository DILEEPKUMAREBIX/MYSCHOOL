package com.myschool.Dto;

import java.io.Serializable;

public class CMGroupValuesDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String CmGroupId;
	String CmGroupName;
	String CmGroupDescription;
	String groupId;
	String name;
	String description;
	String isActive;
	
	
	
	
	public CMGroupValuesDto() {
	}
	public CMGroupValuesDto(String cmGroupId, String cmGroupName, String cmGroupDescription, String groupId,
			String name, String description, String isActive) {
		CmGroupId = cmGroupId;
		CmGroupName = cmGroupName;
		CmGroupDescription = cmGroupDescription;
		this.groupId = groupId;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
	}
	public String getCmGroupId() {
		return CmGroupId;
	}
	public void setCmGroupId(String cmGroupId) {
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
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
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
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	
}
