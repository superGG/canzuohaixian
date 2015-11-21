package com.earl.shopping.daoImpl;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.domain.shop.ShopDao;
import com.earl.fishshop.domain.shop.ShopPo;
import com.earl.fishshop.vo.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class ShopDaoImplTest {

	@Resource
	ShopDao shopDao;
	
	@Resource(name="sessionFactory")
	SessionFactoryImpl sessionFactory;
	
	@Resource(name="transactionManager")
	HibernateTransactionManager transactionManager;
	
	@Test
	public void testSave() {
		ShopPo goods = new ShopPo();
//		goods.setGoodsCategory(1);
		shopDao.save(goods);
	}

	@Test
	public void testFindAll() {
		List<ShopPo> findAll = shopDao.findAll();
		System.out.println(findAll);
	}

	@Test
	public void testGetMyShop() {
		ShopPo myShop = shopDao.getMyShop(1L);
		System.out.println(myShop);
	}
	
	@Test
	public void testUpdateSentPrice() {
		shopDao.updateSentPrice(1L, 234.45);
	}
	
	@Test
	public void testGetGoodsShop(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setIndexPageNum(1);
		pageInfo.setSize(1);
		List<ShopPo> goodsShops = shopDao.getGoodsShops(2L, pageInfo);
		System.out.println(goodsShops);
	}
}
