package com.earl.fishshop.domain.category;

import java.util.Date;
import java.util.List;

import com.earl.fishshop.annotation.IdAnnotatioin;
import com.earl.fishshop.domain.sku.SkuPo;

public class CategoryPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：categoryId  
	 */
	@IdAnnotatioin
	private Long categoryId ;
	
	private Long shopId;
	
	/**
	 * 字段描述：String 
	 * 字段类型：categorySimpleName  
	 */
	private String categorySimpleName ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：categoryAcademicName  
	 */
	private String categoryAcademicName ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：getType  
	 */
	private Integer getType ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：categoryEnglishName  
	 */
	private String categoryEnglishName ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：parentId  
	 */
	private Long parentId;
	
	/**
	 * 字段描述：String 
	 * 字段类型：fishPhoto  
	 */
	private String fishPhoto ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：lowPrice  
	 */
	private Double lowPrice ;//
	
	private Long hotDegree;
	
	private String unit ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：totalSellNumber  
	 */
	private Long totalSellNumber ;
	
	
	private Long totalNowNumber;
	
	private String skuList;
	
	private List<SkuPo> skuArrayList;
	
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
	
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public List<SkuPo> getSkuArrayList() {
		return skuArrayList;
	}
	public void setSkuArrayList(List<SkuPo> skuArrayList) {
		this.skuArrayList = skuArrayList;
	}
	public String getSkuList() {
		return skuList;
	}
	public void setSkuList(String skuList) {
		this.skuList = skuList;
	}
	public Long getTotalNowNumber() {
		return totalNowNumber;
	}
	public void setTotalNowNumber(Long totalNowNumber) {
		this.totalNowNumber = totalNowNumber;
	}
	public Long getHotDegree() {
		return hotDegree;
	}
	public void setHotDegree(Long hotDegree) {
		this.hotDegree = hotDegree;
	}
	public void setCategoryId(Long categoryId){
		this.categoryId = categoryId;
	}
	public Long getCategoryId() {
		return this.categoryId;
	}
	public void setCategorySimpleName(String categorySimpleName){
		this.categorySimpleName = categorySimpleName;
	}
	public String getCategorySimpleName() {
		return this.categorySimpleName;
	}
	public void setCategoryAcademicName(String categoryAcademicName){
		this.categoryAcademicName = categoryAcademicName;
	}
	public String getCategoryAcademicName() {
		return this.categoryAcademicName;
	}
	public void setGetType(Integer getType){
		this.getType = getType;
	}
	public Integer getGetType() {
		return this.getType;
	}
	public void setCategoryEnglishName(String categoryEnglishName){
		this.categoryEnglishName = categoryEnglishName;
	}
	public String getCategoryEnglishName() {
		return this.categoryEnglishName;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public void setFishPhoto(String fishPhoto){
		this.fishPhoto = fishPhoto;
	}
	public String getFishPhoto() {
		return this.fishPhoto;
	}
	public Double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setTotalSellNumber(Long totalSellNumber){
		this.totalSellNumber = totalSellNumber;
	}
	public Long getTotalSellNumber() {
		return this.totalSellNumber;
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
		return "CategoryPo [categoryId=" + categoryId + ", categorySimpleName="
				+ categorySimpleName + ", categoryAcademicName="
				+ categoryAcademicName + ", getType=" + getType
				+ ", categoryEnglishName=" + categoryEnglishName
				+ ", parentId=" + parentId + ", fishPhoto=" + fishPhoto
				+ ", lowPrice=" + lowPrice + ", hotDegree=" + hotDegree
				+ ", unit=" + unit + ", totalSellNumber=" + totalSellNumber
				+ ", createTime=" + createTime + ", creatorId=" + creatorId
				+ ", isDelete=" + isDelete + ", version=" + version + "]";
	}
}
