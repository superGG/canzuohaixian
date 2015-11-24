package com.earl.fishshop.domain.goods;

import java.util.Date;

public class GoodsPo{

	/**
	 * 字段描述：Long 
	 * 字段类型：goodsId  
	 */
	private Long goodsId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：goodsCategory  
	 */
	private Long categoryId;
	
	private String goodsName;
	
	private String skuString;
	
	private String goodsPhoto;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：goodsQuality  
	 */
	private Integer goodsQuality ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：hotDegree  
	 */
	private Long hotDegree ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：getType  
	 */
	private Integer getType ;
	
	/**
	 * 字段描述：Double 
	 * 字段类型：price  
	 */
	private Double price ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：nowNumber  
	 */
	private Long nowNumber ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：unit  
	 */
	private String unit ;
	
	/**
	 * 商品规格.
	 */
	private Long sku;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：sellNumber  
	 */
	private Long sellNumber ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：creatorId  
	 */
	private Long creatorId ;
	
	/**
	 * 字段描述：Date 
	 * 字段类型：createTime  
	 */
	private Date createTime ;
	
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
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSkuString() {
		return skuString;
	}
	public void setSkuString(String skuString) {
		this.skuString = skuString;
	}
	public String getGoodsPhoto() {
		return goodsPhoto;
	}
	public void setGoodsPhoto(String goodsPhoto) {
		this.goodsPhoto = goodsPhoto;
	}
	public Long getSku() {
		return sku;
	}
	public void setSku(Long sku) {
		this.sku = sku;
	}
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	public Long getGoodsId() {
		return this.goodsId;
	}
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	public Long getShopId() {
		return this.shopId;
	}
	public void setGoodsQuality(Integer goodsQuality){
		this.goodsQuality = goodsQuality;
	}
	public Integer getGoodsQuality() {
		return this.goodsQuality;
	}
	public void setHotDegree(Long hotDegree){
		this.hotDegree = hotDegree;
	}
	public Long getHotDegree() {
		return this.hotDegree;
	}
	public void setGetType(Integer getType){
		this.getType = getType;
	}
	public Integer getGetType() {
		return this.getType;
	}
	public void setPrice(Double price){
		this.price = price;
	}
	public Double getPrice() {
		return this.price;
	}
	public void setNowNumber(Long nowNumber){
		this.nowNumber = nowNumber;
	}
	public Long getNowNumber() {
		return this.nowNumber;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setSellNumber(Long sellNumber){
		this.sellNumber = sellNumber;
	}
	public Long getSellNumber() {
		return this.sellNumber;
	}
	public void setCreatorId(Long creatorId){
		this.creatorId = creatorId;
	}
	public Long getCreatorId() {
		return this.creatorId;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	public Date getCreateTime() {
		return this.createTime;
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
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "GoodsPo [goodsId=" + goodsId + ", shopId=" + shopId
				+ ", categoryId=" + categoryId + ", goodsQuality="
				+ goodsQuality + ", hotDegree=" + hotDegree + ", getType="
				+ getType + ", price=" + price + ", nowNumber=" + nowNumber
				+ ", unit=" + unit + ", sku=" + sku + ", sellNumber="
				+ sellNumber + ", creatorId=" + creatorId + ", createTime="
				+ createTime + ", isDelete=" + isDelete + ", version="
				+ version + "]";
	}
}
