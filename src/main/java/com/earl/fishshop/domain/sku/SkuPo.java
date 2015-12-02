package com.earl.fishshop.domain.sku;

import java.util.Date;

public class SkuPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：skuId  
	 */
	private Long skuId ;
	
	private Long goodsId;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：unitId  
	 */
	private Long unitId ;
	
	private Double price;
	
	/**
	 * 字段描述：String 
	 * 字段类型：skuName  
	 */
	private String skuName ;
	
	/**
	 * 低范围.
	 */
	private Double lowscale;

	/**
	 * 高范围.
	 */
	private Double highscale;
	
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
	
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getLowscale() {
		return lowscale;
	}
	public void setLowscale(Double lowscale) {
		this.lowscale = lowscale;
	}
	public Double getHighscale() {
		return highscale;
	}
	public void setHighscale(Double highscale) {
		this.highscale = highscale;
	}
	public void setSkuId(Long skuId){
		this.skuId = skuId;
	}
	public Long getSkuId() {
		return this.skuId;
	}
	public void setUnitId(Long unitId){
		this.unitId = unitId;
	}
	public Long getUnitId() {
		return this.unitId;
	}
	public void setSkuName(String skuName){
		this.skuName = skuName;
	}
	public String getSkuName() {
		return this.skuName;
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
		return "SkuPo [skuId=" + skuId + ", unitId=" + unitId + ", skuName="
				+ skuName + ", createTime=" + createTime + ", creatorId="
				+ creatorId + ", isDelete=" + isDelete + ", version=" + version
				+ "]";
	}
}
