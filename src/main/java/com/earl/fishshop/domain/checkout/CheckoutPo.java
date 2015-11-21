package com.earl.fishshop.domain.checkout;

import java.util.Date;

public class CheckoutPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：checkoutId  
	 */
	private Long checkoutId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：userId  
	 */
	private Long userId ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：userType  
	 */
	private Integer userType ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：identityId  
	 */
	private Long identityId ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：state  
	 */
	private Integer state ;
	
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
	
	
	public void setCheckoutId(Long checkoutId){
		this.checkoutId = checkoutId;
	}
	public Long getCheckoutId() {
		return this.checkoutId;
	}
	public void setUserId(Long userId){
		this.userId = userId;
	}
	public Long getUserId() {
		return this.userId;
	}
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	public Integer getUserType() {
		return this.userType;
	}
	public void setIdentityId(Long identityId){
		this.identityId = identityId;
	}
	public Long getIdentityId() {
		return this.identityId;
	}
	public void setState(Integer state){
		this.state = state;
	}
	public Integer getState() {
		return this.state;
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
