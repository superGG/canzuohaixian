package com.earl.fishshop.pojo;

import java.util.Date;

public class FishmanPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：fishmanId  
	 */
	private Long fishmanId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：getType  
	 */
	private Integer getType ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：identityPhoto  
	 */
	private String identityPhoto ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：seaPassPhoto  
	 */
	private String seaPassPhoto ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：shipPhoto  
	 */
	private String shipPhoto ;
	
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
	 * 字段描述：Long 
	 * 字段类型：enginePower  
	 */
	private Long enginePower ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：tonnage  
	 */
	private Long tonnage ;
	
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
	
	
	public void setFishmanId(Long fishmanId){
		this.fishmanId = fishmanId;
	}
	public Long getFishmanId() {
		return this.fishmanId;
	}
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	public Long getShopId() {
		return this.shopId;
	}
	public void setGetType(Integer getType){
		this.getType = getType;
	}
	public Integer getGetType() {
		return this.getType;
	}
	public void setIdentityPhoto(String identityPhoto){
		this.identityPhoto = identityPhoto;
	}
	public String getIdentityPhoto() {
		return this.identityPhoto;
	}
	public void setSeaPassPhoto(String seaPassPhoto){
		this.seaPassPhoto = seaPassPhoto;
	}
	public String getSeaPassPhoto() {
		return this.seaPassPhoto;
	}
	public void setShipPhoto(String shipPhoto){
		this.shipPhoto = shipPhoto;
	}
	public String getShipPhoto() {
		return this.shipPhoto;
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
	public void setEnginePower(Long enginePower){
		this.enginePower = enginePower;
	}
	public Long getEnginePower() {
		return this.enginePower;
	}
	public void setTonnage(Long tonnage){
		this.tonnage = tonnage;
	}
	public Long getTonnage() {
		return this.tonnage;
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
