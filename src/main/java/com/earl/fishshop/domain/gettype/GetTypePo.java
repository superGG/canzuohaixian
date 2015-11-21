package com.earl.fishshop.domain.gettype;

import java.util.Date;
import java.util.Set;

/**
 * 捕鱼方式，养殖类型.
 * @author 黄祥谦.
 *
 */
public class GetTypePo{

	/**
	 * 字段描述：Long 
	 * 字段类型：getTypeId  
	 */
	private Long getTypeId ;
	
	/**
	 * 字段描述：String 
	 * 字段类型：getName  
	 */
	private String getName ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：parentId  
	 */
	private Long parentId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：parentId  
	 */
	private Set<GetTypePo> childGetType;
	
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
	
	
	public Set<GetTypePo> getChildGetType() {
		return childGetType;
	}
	public void setChildGetType(Set<GetTypePo> childGetType) {
		this.childGetType = childGetType;
	}
	public void setGetTypeId(Long getTypeId){
		this.getTypeId = getTypeId;
	}
	public Long getGetTypeId() {
		return this.getTypeId;
	}
	public void setGetName(String getName){
		this.getName = getName;
	}
	public String getGetName() {
		return this.getName;
	}
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}
	public Long getParentId() {
		return this.parentId;
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
