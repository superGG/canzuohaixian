package com.earl.fishshop.domain.orders;

import java.util.Date;
import java.util.List;

import com.earl.fishshop.annotation.IdAnnotatioin;
import com.earl.fishshop.domain.ordersdetail.OrdersDetailPo;

//TODO 添加订单收货地址信息.
public class OrdersPo{


	/**
	 * 字段描述：Long 
	 * 字段类型：ordersId  
	 */
	@IdAnnotatioin
	private Long ordersId ;
	
	private Long userId;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：shopId  
	 */
	private Long shopId ;
	
	/**
	 * 字段描述：Long 
	 * 字段类型：totalprice  
	 */
	private Double totalprice ;
	
	/**
	 * 字段描述：Integer 
	 * 字段类型：state  
	 */
	private Integer state ;
	
	private String buyerName;
	
	private String shopKeeperName;//店家店面，海哥好
	
	private String sendAddress;//发货地址
	
	private String phone;//收货电话
	
	private List<OrdersDetailPo> ordersDetail;
	
	/**
	 * 哪一批次的航海记录
	 */
	private Long seaRecordId;
	
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
	public String getShopKeeperName() {
		return shopKeeperName;
	}
	public void setShopKeeperName(String shopKeeperName) {
		this.shopKeeperName = shopKeeperName;
	}
	public String getSendAddress() {
		return sendAddress;
	}
	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
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
	@Override
	public String toString() {
		return "OrdersPo [ordersId=" + ordersId + ", userId=" + userId
				+ ", shopId=" + shopId + ", totalprice=" + totalprice
				+ ", state=" + state + ", buyerName=" + buyerName
				+ ", shopKeeperName=" + shopKeeperName + ", sendAddress="
				+ sendAddress + ", phone=" + phone + ", ordersDetail="
				+ ordersDetail + ", seaRecordId=" + seaRecordId
				+ ", createTime=" + createTime + ", creatorId=" + creatorId
				+ ", isDelete=" + isDelete + ", version=" + version + "]";
	}
}
