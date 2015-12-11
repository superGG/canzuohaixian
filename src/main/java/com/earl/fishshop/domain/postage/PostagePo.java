package com.earl.fishshop.domain.postage;

import java.util.Date;

/**
 * 运费po.
 * @author Administrator
 *
 */
public class PostagePo{

	/**
	 * 字段描述：Long 
	 * 字段类型：unitId  
	 */
	private Long postageId ;
	
	/**
	 * 首重.
	 */
	private Double firstWeigh;
	
	/**
	 * 超重后，额外增加价格.
	 */
	private Double increasePrice;
	
	private String origin;
	
	private String destination;
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
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getIncreasePrice() {
		return increasePrice;
	}
	public void setIncreasePrice(Double increasePrice) {
		this.increasePrice = increasePrice;
	}
	public Double getFirstWeigh() {
		return firstWeigh;
	}
	public void setFirstWeigh(Double firstWeigh) {
		this.firstWeigh = firstWeigh;
	}
	public Long getPostageId() {
		return postageId;
	}
	public void setPostageId(Long postageId) {
		this.postageId = postageId;
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
