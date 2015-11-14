package com.earl.fishshop.pojo;

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
	private Integer unit ;
	
	/**
	 * 商品规格.
	 */
	private Integer sku;
	
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
	
	public Integer getSku() {
		return sku;
	}
	public void setSku(Integer sku) {
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
	public void setUnit(Integer unit){
		this.unit = unit;
	}
	public Integer getUnit() {
		return this.unit;
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
}
