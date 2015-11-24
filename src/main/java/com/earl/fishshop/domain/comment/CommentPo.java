package com.earl.fishshop.domain.comment;

import java.util.Date;

public class CommentPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：commentId  
	 */
	private Long commentId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：goodsId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：用户ID
	 * 字段类型：Long 
	 */
	private Long userId;
	
	/**
	 * 字段描述：用户手机
	 * 字段类型：String 
	 */
	private String phoneNumber;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：goodsId  
	 */
	private Long ordersId ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：commentType  
	 */
	private Integer commentType ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：content  
	 */
	private String content ;
	
	/**
	 * 字段描述：是否匿名. 
	 * 字段类型：Integer  
	 */
	private Integer anonymity;
	
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
	
	
	public Long getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(Long ordersId) {
		this.ordersId = ordersId;
	}
	public void setCommentId(Long commentId){
		this.commentId = commentId;
	}
	public Long getCommentId() {
		return this.commentId;
	}
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	public Long getShopId() {
		return this.shopId;
	}
	public void setCommentType(Integer commentType){
		this.commentType = commentType;
	}
	public Integer getCommentType() {
		return this.commentType;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent() {
		return this.content;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getAnonymity() {
		return anonymity;
	}
	public void setAnonymity(Integer anonymity) {
		this.anonymity = anonymity;
	}
	@Override
	public String toString() {
		return "CommentPo [commentId=" + commentId + ", shopId=" + shopId
				+ ", userId=" + userId + ", phoneNumber=" + phoneNumber
				+ ", ordersId=" + ordersId + ", commentType=" + commentType
				+ ", content=" + content + ", anonymity=" + anonymity
				+ ", weightQuality=" + weightQuality + ", freshQuality="
				+ freshQuality + ", speedQuality=" + speedQuality
				+ ", createTime=" + createTime + ", creatorId=" + creatorId
				+ ", isDelete=" + isDelete + ", version=" + version + "]";
	}
	
	
	
	
}
