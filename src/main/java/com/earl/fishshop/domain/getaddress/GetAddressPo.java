package com.earl.fishshop.domain.getaddress;

import java.util.Date;

public class GetAddressPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：getAddressId  
	 */
	private Long getAddressId ;
	
	/**
	 * 用户id
	 */
	private Long userId;
	
	/**
	 * 字段描述：String 
	 * 字段类型：userName  
	 */
	private String userName ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：address  
	 */
	private String address ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：phone  
	 */
	private String phone ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：postcode  
	 */
	private String postcode ;
	
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
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setGetAddressId(Long getAddressId){
		this.getAddressId = getAddressId;
	}
	public Long getGetAddressId() {
		return this.getAddressId;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPostcode(String postcode){
		this.postcode = postcode;
	}
	public String getPostcode() {
		return this.postcode;
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
