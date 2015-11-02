package com.earl.fishshop.pojo;

import java.util.Date;

public class CategoryPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：categoryId  
	 */
	private Long categoryId ;
	
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
	private Long parentId ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：fishPhoto  
	 */
	private String fishPhoto ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：lowPrice  
	 */
	private String lowPrice ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：unit  
	 */
	private Integer unit ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：totalSellNumber  
	 */
	private Long totalSellNumber ;
	
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
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}
	public Long getParentId() {
		return this.parentId;
	}
	public void setFishPhoto(String fishPhoto){
		this.fishPhoto = fishPhoto;
	}
	public String getFishPhoto() {
		return this.fishPhoto;
	}
	public void setLowPrice(String lowPrice){
		this.lowPrice = lowPrice;
	}
	public String getLowPrice() {
		return this.lowPrice;
	}
	public void setUnit(Integer unit){
		this.unit = unit;
	}
	public Integer getUnit() {
		return this.unit;
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
}
