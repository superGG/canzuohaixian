package com.earl.fishshop.pojo;

import java.util.Date;

public class ShopPo{

	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId;
	
	/**
	 * 字段描述：String 
	 * 字段类型：shopName 商店名称.
	 */
	private String shopName ;
	
	/**
	 * 用户id  创建商店的用户.
	 */
	private Long userId;
	
	/**
	 * 字段描述：String 
	 * 字段类型：getType  
	 */
	private String getType ;
	
	/**
	 * 字段描述：Float 
	 * 字段类型：weightQuality  
	 */
	private Float weightQuality ;
	
	/**
	 * 字段描述：Float 
	 * 字段类型：freshQuality  
	 */
	private Float freshQuality ;
	
	/**
	 * 字段描述：Float 
	 * 字段类型：speedQuality  
	 */
	private Float speedQuality ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：shopType  
	 */
	private Integer shopType ;//渔户，养殖户
	
	/**
	 * 字段描述：Double 
	 * 字段类型：sendPrice  
	 */
	private Double sendPrice ;
	

	/**
	 * 字段描述：Boolean 
	 * 字段类型：onSell  
	 */
	private Boolean onSell ;
	
	private String shipPort;//靠岸口
	
	private String portTime;//靠岸时间.
	
	private String address;//养殖户养殖地点.
	
	private Long seaRecordId;//航海记录id
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
	 * 字段类型：creatorId  
	 */
	private Long creatorId ;
	
	/**
	 * 字段描述：Boolean 
	 * 字段类型：isDelete  
	 */
	private Boolean isDelete ;
	
	/**
	 * 字段描述：Date 
	 * 字段类型：createTime  
	 */
	private Date createTime ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：version  
	 */
	private Long version ;
	
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Long getSeaRecordId() {
		return seaRecordId;
	}
	public void setSeaRecordId(Long seaRecordId) {
		this.seaRecordId = seaRecordId;
	}
	public String getShipPort() {
		return shipPort;
	}
	public void setShipPort(String shipPort) {
		this.shipPort = shipPort;
	}
	public String getPortTime() {
		return portTime;
	}
	public void setPortTime(String portTime) {
		this.portTime = portTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	public Long getShopId() {
		return this.shopId;
	}
	public void setShopName(String shopName){
		this.shopName = shopName;
	}
	public String getShopName() {
		return this.shopName;
	}
	public void setGetType(String getType){
		this.getType = getType;
	}
	public String getGetType() {
		return this.getType;
	}
	public void setWeightQuality(Float weightQuality){
		this.weightQuality = weightQuality;
	}
	public Float getWeightQuality() {
		return this.weightQuality;
	}
	public void setFreshQuality(Float freshQuality){
		this.freshQuality = freshQuality;
	}
	public Float getFreshQuality() {
		return this.freshQuality;
	}
	public void setSpeedQuality(Float speedQuality){
		this.speedQuality = speedQuality;
	}
	public Float getSpeedQuality() {
		return this.speedQuality;
	}
	public void setShopType(Integer shopType){
		this.shopType = shopType;
	}
	public Integer getShopType() {
		return this.shopType;
	}
	public void setSendPrice(Double sendPrice){
		this.sendPrice = sendPrice;
	}
	public Double getSendPrice() {
		return this.sendPrice;
	}
	public void setOnSell(Boolean onSell){
		this.onSell = onSell;
	}
	public Boolean getOnSell() {
		return this.onSell;
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
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	public Date getCreateTime() {
		return this.createTime;
	}
	public void setVersion(Long version){
		this.version = version;
	}
	public Long getVersion() {
		return this.version;
	}
	@Override
	public String toString() {
		return "ShopPo [shopId=" + shopId + ", shopName=" + shopName
				+ ", userId=" + userId + ", getType=" + getType
				+ ", weightQuality=" + weightQuality + ", freshQuality="
				+ freshQuality + ", speedQuality=" + speedQuality
				+ ", shopType=" + shopType + ", sendPrice=" + sendPrice
				+ ", onSell=" + onSell + ", shipPort=" + shipPort
				+ ", portTime=" + portTime + ", address=" + address
				+ ", seaRecordId=" + seaRecordId + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", creatorId=" + creatorId
				+ ", isDelete=" + isDelete + ", createTime=" + createTime
				+ ", version=" + version + "]";
	}
}
