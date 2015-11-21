package com.earl.fishshop.domain.shipport;

import java.util.Date;

public class ShipPortPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：shipportId  
	 */
	private Long shipPortId ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：shipportName  
	 */
	private String shipportName ;
	
	/**
	 * 字段描述：Double 
	 * 字段类型：longitude  
	 */
	private Double longitude ;
	
	/**
	 * 字段描述：Double 
	 * 字段类型：latitude  
	 */
	private Double latitude ;
	
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
	
	public Long getShipPortId() {
		return shipPortId;
	}
	public void setShipPortId(Long shipPortId) {
		this.shipPortId = shipPortId;
	}
	public void setShipportName(String shipportName){
		this.shipportName = shipportName;
	}
	public String getShipportName() {
		return this.shipportName;
	}
	public void setLongitude(Double longitude){
		this.longitude = longitude;
	}
	public Double getLongitude() {
		return this.longitude;
	}
	public void setLatitude(Double latitude){
		this.latitude = latitude;
	}
	public Double getLatitude() {
		return this.latitude;
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
