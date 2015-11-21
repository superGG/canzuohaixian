package com.earl.shopping.daoImpl;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.domain.goods.GoodsDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.vo.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class GoodsDaoImplTest {

	@Resource
	GoodsDao goodsDao;
	
	@Resource(name="sessionFactory")
	SessionFactoryImpl sessionFactory;
	
	@Resource(name="transactionManager")
	HibernateTransactionManager transactionManager;
	
	@Test
	public void testBaseDaoImpl() {
	}

	@Test
	public void testGetCurrentSession() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		GoodsPo goods = new GoodsPo();
		goods.setCategoryId(1L);
		goodsDao.save(goods);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<GoodsPo> findAll = goodsDao.findAll();
		System.out.println(findAll);
	}

	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCategoryWithTotalNumber() {
		
		List<CategoryPo> categoryWithTotalNumber = goodsDao.getCategoryWithTotalNumber(1L);
		System.out.println(categoryWithTotalNumber);
	}
	
	@Test
	public void testGetShopAllGoods(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setIndexPageNum(1);
		pageInfo.setSize(4);
		List<GoodsPo> goodsList = goodsDao.getShopAllGoods(1L, pageInfo);
		System.out.println(goodsList);
	}
}
