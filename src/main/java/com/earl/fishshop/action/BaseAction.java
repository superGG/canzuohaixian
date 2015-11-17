package com.earl.fishshop.action;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.earl.fishshop.service.CategoryService;
import com.earl.fishshop.service.CheckoutService;
import com.earl.fishshop.service.CommentService;
import com.earl.fishshop.service.FarmersService;
import com.earl.fishshop.service.FishmanService;
import com.earl.fishshop.service.GetAddressService;
import com.earl.fishshop.service.GetTypeService;
import com.earl.fishshop.service.GoodsService;
import com.earl.fishshop.service.OrdersDetailService;
import com.earl.fishshop.service.OrdersService;
import com.earl.fishshop.service.SeaRecordService;
import com.earl.fishshop.service.ShipPortService;
import com.earl.fishshop.service.ShopService;
import com.earl.fishshop.service.SkuService;
import com.earl.fishshop.service.UnitService;
import com.earl.fishshop.service.UserService;
import com.earl.fishshop.serviceImpl.VerifyService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//默认是类简单名称，首字母小写
@Controller(value="baseAction")
@Scope(value="prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware, ModelDriven<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected T model;

	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;

	@Resource
	protected GoodsService goodsServer;
	@Resource
	protected CommentService commentServer;
	@Resource
	protected CategoryService categoryServer;
	@Resource
	protected OrdersService ordersServer;
	@Resource
	protected FarmersService farmersServer;
	@Resource
	protected FishmanService fishmanServer;
	@Resource
	protected SeaRecordService seaRecordServer;
	@Resource
	protected ShopService shopServer;
	@Resource
	protected SkuService skuServer;
	@Resource
	protected UnitService unitServer;
	@Resource
	protected UserService userServer;
	@Resource
	protected GetTypeService getTypeServer;
	@Resource
	protected CheckoutService checkoutServer;
	@Resource
	protected ShipPortService shipPortServer;
	@Resource
	protected GetAddressService getAddressServer;
	@Resource 
	protected OrdersDetailService ordersDetailServer;
	
	protected VerifyService verifyService;
	
//	protected PageInfo pageInfo = new PageInfo();
//
//	public PageInfo getPageInfo() {
//		return pageInfo;
//	}
//
//	public void setPageInfo(PageInfo pageInfo) {
//		this.pageInfo = pageInfo;
//	}

	@SuppressWarnings("unchecked")
	public BaseAction() {
		ParameterizedType type = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		@SuppressWarnings("rawtypes")
		Class clazz = (Class) type.getActualTypeArguments()[0];
		try {
			model = (T) clazz.newInstance();
			System.out.println(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public T getModel() {
		return model;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
