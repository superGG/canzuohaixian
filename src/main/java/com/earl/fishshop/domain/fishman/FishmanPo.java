package com.earl.fishshop.domain.fishman;

import java.util.Date;

import com.earl.fishshop.annotation.IdAnnotatioin;

public class FishmanPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：fishmanId  
	 */
	@IdAnnotatioin
	private Long fishmanId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：frontIdentityPhoto  
	 */
	private String frontIdentityPhoto ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：backIdentityPhoto  
	 */
	private String backIdentityPhoto ;
	
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
	 * 字段描述：Integer 
	 * 字段类型：getType  
	 */
	private Integer getType ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：enginePower  
	 */
	private Long enginePower ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：homePort  
	 */
	private Long homePort ;
	
	/**
	 * 字段描述：Date 
	 * 字段类型：shipCreateTime  
	 */
	private Date shipCreateTime ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：realName  
	 */
	private String realName ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：tonnage  
	 */
	private Long tonnage ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：fishingLicense  
	 */
	private String fishingLicense ;
	
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
	public void setFrontIdentityPhoto(String frontIdentityPhoto){
		this.frontIdentityPhoto = frontIdentityPhoto;
	}
	public String getFrontIdentityPhoto() {
		return this.frontIdentityPhoto;
	}
	public void setBackIdentityPhoto(String backIdentityPhoto){
		this.backIdentityPhoto = backIdentityPhoto;
	}
	public String getBackIdentityPhoto() {
		return this.backIdentityPhoto;
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
	public void setGetType(Integer getType){
		this.getType = getType;
	}
	public Integer getGetType() {
		return this.getType;
	}
	public void setEnginePower(Long enginePower){
		this.enginePower = enginePower;
	}
	public Long getEnginePower() {
		return this.enginePower;
	}
	public Long getHomePort() {
		return homePort;
	}
	public void setHomePort(Long homePort) {
		this.homePort = homePort;
	}
	public void setShipCreateTime(Date shipCreateTime){
		this.shipCreateTime = shipCreateTime;
	}
	public Date getShipCreateTime() {
		return this.shipCreateTime;
	}
	public void setRealName(String realName){
		this.realName = realName;
	}
	public String getRealName() {
		return this.realName;
	}
	public void setTonnage(Long tonnage){
		this.tonnage = tonnage;
	}
	public Long getTonnage() {
		return this.tonnage;
	}
	public void setFishingLicense(String fishingLicense){
		this.fishingLicense = fishingLicense;
	}
	public String getFishingLicense() {
		return this.fishingLicense;
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
	@Override
	public String toString() {
		return "FishmanPo [fishmanId=" + fishmanId + ", shopId=" + shopId
				+ ", frontIdentityPhoto=" + frontIdentityPhoto
				+ ", backIdentityPhoto=" + backIdentityPhoto
				+ ", seaPassPhoto=" + seaPassPhoto + ", shipPhoto=" + shipPhoto
				+ ", getType=" + getType + ", enginePower=" + enginePower
				+ ", homePort=" + homePort + ", shipCreateTime="
				+ shipCreateTime + ", realName=" + realName + ", tonnage="
				+ tonnage + ", fishingLicense=" + fishingLicense
				+ ", createTime=" + createTime + ", creatorId=" + creatorId
				+ ", isDelete=" + isDelete + ", version=" + version + "]";
	}
}
