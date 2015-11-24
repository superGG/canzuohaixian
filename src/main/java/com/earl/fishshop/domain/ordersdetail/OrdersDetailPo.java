package com.earl.fishshop.domain.ordersdetail;

import java.util.Date;

public class OrdersDetailPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：sordersId  
	 */
	private Long ordersDetailId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：orderId
	 */
	private Long orderId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：goodsId  
	 */
	private Long goodsId ;
	
	/**
	 * 商品的所属类别.
	 */
	private Long categoryId;
	/**
	 * 字段描述：String 
	 * 字段类型：goodsName  
	 */
	private String goodsName ;
	
	/**
	 * 鱼图片.
	 */
	private String fishPhoto;
	
	/**
	 * 字段描述：String 
	 * 字段类型：goodsType  
	 */
	private String goodsType ;
	
	/**
	 * 字段描述：Double 
	 * 字段类型：price  
	 */
	private Double price ;
	
	/**
	 * 字段描述：Double 
	 * 字段类型：totalprice  
	 */
	private Double totalprice ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：sku  
	 */
	private String sku ;
	
	private Long skuId;
	
	/**
	 * 字段描述：String 
	 * 字段类型：unit  
	 */
	private String unit ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：number  
	 */
	private Long number ;
	
	/**
	 * 邮费
	 */
	private Long postage;
	
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
	
	public Long getSkuId() {
		return skuId;
	}
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	public Long getPostage() {
		return postage;
	}
	public void setPostage(Long postage) {
		this.postage = postage;
	}
	public String getFishPhoto() {
		return fishPhoto;
	}
	public void setFishPhoto(String fishPhoto) {
		this.fishPhoto = fishPhoto;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Long getOrdersDetailId() {
		return ordersDetailId;
	}
	public void setOrdersDetailId(Long ordersDetailId) {
		this.ordersDetailId = ordersDetailId;
	}
	public void setOrderId(Long orderId){
		this.orderId = orderId;
	}
	public Long getOrderId() {
		return this.orderId;
	}
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	public Long getShopId() {
		return this.shopId;
	}
	public void setGoodsId(Long goodsId){
		this.goodsId = goodsId;
	}
	public Long getGoodsId() {
		return this.goodsId;
	}
	public void setGoodsName(String goodsName){
		this.goodsName = goodsName;
	}
	public String getGoodsName() {
		return this.goodsName;
	}
	public void setGoodsType(String goodsType){
		this.goodsType = goodsType;
	}
	public String getGoodsType() {
		return this.goodsType;
	}
	public void setPrice(Double price){
		this.price = price;
	}
	public Double getPrice() {
		return this.price;
	}
	public void setTotalprice(Double totalprice){
		this.totalprice = totalprice;
	}
	public Double getTotalprice() {
		return this.totalprice;
	}
	public void setSku(String sku){
		this.sku = sku;
	}
	public String getSku() {
		return this.sku;
	}
	public void setUnit(String unit){
		this.unit = unit;
	}
	public String getUnit() {
		return this.unit;
	}
	public void setNumber(Long number){
		this.number = number;
	}
	public Long getNumber() {
		return this.number;
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
		return "OrdersDetailPo [ordersDetailId=" + ordersDetailId
				+ ", orderId=" + orderId + ", shopId=" + shopId + ", goodsId="
				+ goodsId + ", categoryId=" + categoryId + ", goodsName="
				+ goodsName + ", goodsType=" + goodsType + ", price=" + price
				+ ", totalprice=" + totalprice + ", sku=" + sku + ", unit="
				+ unit + ", number=" + number + ", createTime=" + createTime
				+ ", creatorId=" + creatorId + ", isDelete=" + isDelete
				+ ", version=" + version + "]";
	}
}
