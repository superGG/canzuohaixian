package com.earl.fishshop.domain.farmers;

import java.util.Date;

import com.earl.fishshop.annotation.IdAnnotatioin;

public class FarmersPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：farmersId  
	 */
	@IdAnnotatioin
	private Long farmersId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：address  
	 */
	private String address ;
	
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
	 * 字段描述：String 
	 * 字段类型：forntIdentityPhoto  
	 */
	private String forntIdentityPhoto ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：backIdentityPhoto  
	 */
	private String backIdentityPhoto ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：addressPhoto  
	 */
	private String addressPhoto ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：aquacultureLicense  
	 */
	private String aquacultureLicense ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：multiGetType  
	 */
	private String multiGetType ;
	
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
	
	
	public void setFarmersId(Long farmersId){
		this.farmersId = farmersId;
	}
	public Long getFarmersId() {
		return this.farmersId;
	}
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	public Long getShopId() {
		return this.shopId;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress() {
		return this.address;
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
	public void setForntIdentityPhoto(String forntIdentityPhoto){
		this.forntIdentityPhoto = forntIdentityPhoto;
	}
	public String getForntIdentityPhoto() {
		return this.forntIdentityPhoto;
	}
	public void setBackIdentityPhoto(String backIdentityPhoto){
		this.backIdentityPhoto = backIdentityPhoto;
	}
	public String getBackIdentityPhoto() {
		return this.backIdentityPhoto;
	}
	public void setAddressPhoto(String addressPhoto){
		this.addressPhoto = addressPhoto;
	}
	public String getAddressPhoto() {
		return this.addressPhoto;
	}
	public void setAquacultureLicense(String aquacultureLicense){
		this.aquacultureLicense = aquacultureLicense;
	}
	public String getAquacultureLicense() {
		return this.aquacultureLicense;
	}
	public void setMultiGetType(String multiGetType){
		this.multiGetType = multiGetType;
	}
	public String getMultiGetType() {
		return this.multiGetType;
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
