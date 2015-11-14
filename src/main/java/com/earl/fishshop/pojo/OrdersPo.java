package com.earl.fishshop.pojo;

import java.util.Date;
import java.util.List;

public class OrdersPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：ordersId  
	 */
	private Long ordersId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：totalprice  
	 */
	private Long totalprice ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：state  
	 */
	private Integer state ;
	
	private String buyerName;
	
	private List<OrdersDetailPo> ordersDetail;
	
	/**
	 * 哪一批次的航海记录
	 */
	private Long seaRecordId;
	
	/**
	 * 订单号.
	 */
	private String orderNumber;
	
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
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Long getSeaRecordId() {
		return seaRecordId;
	}
	public void setSeaRecordId(Long seaRecordId) {
		this.seaRecordId = seaRecordId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public List<OrdersDetailPo> getOrdersDetail() {
		return ordersDetail;
	}
	public void setOrdersDetail(List<OrdersDetailPo> ordersDetail) {
		this.ordersDetail = ordersDetail;
	}
	public void setOrdersId(Long ordersId){
		this.ordersId = ordersId;
	}
	public Long getOrdersId() {
		return this.ordersId;
	}
	public void setShopId(Long shopId){
		this.shopId = shopId;
	}
	public Long getShopId() {
		return this.shopId;
	}
	public void setTotalprice(Long totalprice){
		this.totalprice = totalprice;
	}
	public Long getTotalprice() {
		return this.totalprice;
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
