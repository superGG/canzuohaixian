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
	
	private String provinceName;
	
	/**
	 * 字段描述：Double 
	 * 字段类型：longitude  
	 */
	private Double lontitude ;
	
	private String addresscode;
	
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
	
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public String getAddresscode() {
		return addresscode;
	}
	public void setAddresscode(String addresscode) {
		this.addresscode = addresscode;
	}
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
	public Double getLontitude() {
		return lontitude;
	}
	public void setLontitude(Double lontitude) {
		this.lontitude = lontitude;
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
