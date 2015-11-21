package com.earl.shopping.serverImpl;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.domain.orders.OrdersService;
import com.earl.fishshop.helper.JsonHelper;
import com.earl.fishshop.pojo.OrdersDetailPo;
import com.earl.fishshop.pojo.OrdersPo;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class OrdersServiceImplTest {
	
	@Resource
	OrdersService ordersService ;

	@Test
	public void testGoodsServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() throws Exception {
		// request.addHeader("Content-type", " text/html; charset=utf-8");
		
//		request.addParameter("ordersDetail.order1.shopId", "5");
//		request.addParameter("ordersDetail.order1.goodsId", "5");
//		request.addParameter("ordersDetail.order1.categoryId", "5");
//		request.addParameter("ordersDetail.order1.goodsName", "sdfs");
//		request.addParameter("ordersDetail.order1.goodsType", "dsfs");
//		request.addParameter("ordersDetail.order1.price", "40.0");
//		request.addParameter("ordersDetail.order1.sku", "sdf");
//		request.addParameter("ordersDetail.order1.unit", "sdf");
//		request.addParameter("ordersDetail.order1.number", "5");
//		request.addParameter("ordersDetail.order1.isDelete", "false");
//		request.addParameter("ordersDetail.order1.version", "1");
//		
//		request.addParameter("ordersDetail.order2.shopId", "6");
//		request.addParameter("ordersDetail.order2.goodsId", "5");
//		request.addParameter("ordersDetail.order2.categoryId", "5");
//		request.addParameter("ordersDetail.order2.goodsName", "sdfs");
//		request.addParameter("ordersDetail.order2.goodsType", "dsfs");
//		request.addParameter("ordersDetail.order2.price", "40.0");
//		request.addParameter("ordersDetail.order2.sku", "sdfs");
//		request.addParameter("ordersDetail.order2.unit", "sdf");
//		request.addParameter("ordersDetail.order2.number", "5");
//		request.addParameter("ordersDetail.order2.isDelete", "false");
//		request.addParameter("ordersDetail.order2.version", "1");
		
//		request.addParameter("totalprice", "30.5");
//		request.addParameter("state", "1");
//		request.addParameter("buyerName", "yilinfeng");
//		request.addParameter("seaRecordId", "5");
//		request.addParameter("isDelete", "false");
//		request.addParameter("version", "1");
		// 使用下面方式，不能直接用struts的modeldriven

		OrdersPo ordersPo = new OrdersPo();
		ordersPo.setBuyerName("dsdf");
		ordersPo.setOrderNumber("134345");
		ArrayList<OrdersDetailPo> arrayList = new ArrayList<OrdersDetailPo>();
		OrdersDetailPo ordersDetailPo = new OrdersDetailPo();
		ordersDetailPo.setCategoryId(1L);
		ordersDetailPo.setGoodsType("2343");
		arrayList.add(ordersDetailPo);
		OrdersDetailPo ordersDetailPo2 = new OrdersDetailPo();
		ordersDetailPo2.setCategoryId(1L);
		ordersDetailPo2.setGoodsType("2343");
		arrayList.add(ordersDetailPo2);
		
		ordersPo.setOrdersDetail(arrayList);
		
		ordersService.save(ordersPo);
		
		String json = JsonHelper.toJson(ordersPo);
		System.out.println(json);
	}

	
}
