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

import com.earl.fishshop.domain.sku.SkuDao;
import com.earl.fishshop.domain.sku.SkuPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class SkuDaoImplTest {

	@Resource
	SkuDao skuDao;

	@Resource(name = "sessionFactory")
	SessionFactoryImpl sessionFactory;

	@Resource(name = "transactionManager")
	HibernateTransactionManager transactionManager;

	@Test
	public void testGetCurrentSession() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		SkuPo unit = new SkuPo();
		unit.setSkuName("中等规格（10-15斤)");
		unit.setUnitId(1L);
		// user.setGoodsCategory(1);
		skuDao.save(unit);
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
		SkuPo unitPo = skuDao.get(1L);
		System.out.println(unitPo);
	}

	@Test
	public void testFindAll() {
		List<SkuPo> findAll = skuDao.findAll();
		System.out.println(findAll);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetSkuFromUnit(){
		List<SkuPo> skuFromUnit = skuDao.getSkuFromUnit(1L);
		System.out.println(skuFromUnit);
	}
	
}
