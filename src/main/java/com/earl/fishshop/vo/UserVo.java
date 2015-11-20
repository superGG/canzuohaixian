package com.earl.fishshop.vo;

import com.earl.fishshop.annotation.IdAnnotatioin;

public class UserVo{


	/**
	 * 字段描述：Long 
	 * 字段类型：userId  
	 */
	@IdAnnotatioin
	private Long userId ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：userType  
	 */
	private Integer userType ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：state  
	 */
	private Integer state ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：userName  
	 */
	private String userName ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：password  
	 */
	private String phoneNumber ;
	
	
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
	public void setState(Integer state){
		this.state = state;
	}
	public Integer getState() {
		return this.state;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}