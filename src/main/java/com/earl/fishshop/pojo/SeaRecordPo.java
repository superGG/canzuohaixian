package com.earl.fishshop.pojo;

import java.util.Date;

public class SeaRecordPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：seaRecordId  
	 */
	private Long seaRecordId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：Date 
	 * 字段类型：startSeeTime  
	 */
	private Date startSeeTime ;
	
	/**
	 * 字段描述：Date 
	 * 字段类型：endSeeTime  
	 */
	private Date endSeeTime ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：spendDay  
	 */
	private Integer spendDay ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：state  
	 */
	private Integer state ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：anchorPoint  
	 */
	private Integer anchorPoint ;
	
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
	
	
	public void setSeaRecordId(Long seaRecordId){
		this.seaRecordId = seaRecordId;
	}
	public Long getSeaRecordId() {
		return this.seaRecordId;
	}
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	public Long getShopId() {
		return this.shopId;
	}
	public void setStartSeeTime(Date startSeeTime){
		this.startSeeTime = startSeeTime;
	}
	public Date getStartSeeTime() {
		return this.startSeeTime;
	}
	public void setEndSeeTime(Date endSeeTime){
		this.endSeeTime = endSeeTime;
	}
	public Date getEndSeeTime() {
		return this.endSeeTime;
	}
	public void setSpendDay(Integer spendDay){
		this.spendDay = spendDay;
	}
	public Integer getSpendDay() {
		return this.spendDay;
	}
	public void setState(Integer state){
		this.state = state;
	}
	public Integer getState() {
		return this.state;
	}
	public void setAnchorPoint(Integer anchorPoint){
		this.anchorPoint = anchorPoint;
	}
	public Integer getAnchorPoint() {
		return this.anchorPoint;
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
