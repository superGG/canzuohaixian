package com.earl.fishshop.domain.verifycode;

import java.util.Date;

public class VerifyCodePo{


	/**
	 * 字段描述：Long 
	 * 字段类型：verifycodeId  
	 */
	private Long verifycodeId ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：phoneNumber  
	 */
	private String phoneNumber ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：verifyCode  
	 */
	private String verifyCode;
	
	
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
	
	
	
	public Long getVerifycodeId() {
		return verifycodeId;
	}
	public void setVerifycodeId(Long verifycodeId) {
		this.verifycodeId = verifycodeId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
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
		return "VerifyCodePo [verifycodeId=" + verifycodeId + ", phoneNumber="
				+ phoneNumber + ", verifyCode=" + verifyCode + ", createTime="
				+ createTime + ", creatorId=" + creatorId + ", isDelete="
				+ isDelete + ", version=" + version + "]";
	}
	
	
}
