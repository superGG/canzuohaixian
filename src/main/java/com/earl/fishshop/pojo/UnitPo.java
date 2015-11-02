package com.earl.fishshop.pojo;

import java.util.Date;

public class UnitPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：unitId  
	 */
	private Long unitId ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：unitName  
	 */
	private String unitName ;
	
	/**
	 * 字段描述：Date 
	 * 字段类型：createTime  
	 */
	private Date createTime ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：creatorId  
	 */
	private Long creatorId ;
	
	/**
	 * 字段描述：Boolean 
	 * 字段类型：isDelete  
	 */
	private Boolean isDelete ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：version  
	 */
	private Long version ;
	
	
	public void setUnitId(Long unitId){
		this.unitId = unitId;
	}
	public Long getUnitId() {
		return this.unitId;
	}
	public void setUnitName(String unitName){
		this.unitName = unitName;
	}
	public String getUnitName() {
		return this.unitName;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setCreatorId(Long creatorId){
		this.creatorId = creatorId;
	}
	public Long getCreatorId() {
		return this.creatorId;
	}
	public void setIsDelete(Boolean isDelete){
		this.isDelete = isDelete;
	}
	public Boolean getIsDelete() {
		return this.isDelete;
	}
	public void setVersion(Long version){
		this.version = version;
	}
	public Long getVersion() {
		return this.version;
	}
}
