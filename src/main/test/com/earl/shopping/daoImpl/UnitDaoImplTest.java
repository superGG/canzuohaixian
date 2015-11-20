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

import com.earl.fishshop.dao.UnitDao;
import com.earl.fishshop.pojo.UnitPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class UnitDaoImplTest {

	@Resource
	UnitDao unitDao;

	@Resource(name = "sessionFactory")
	SessionFactoryImpl sessionFactory;

	@Resource(name = "transactionManager")
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
		UnitPo unit = new UnitPo();
		unit.setUnitName("包");
		// user.setGoodsCategory(1);
		unitDao.save(unit);
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
		UnitPo unitPo = unitDao.get(1L);
		System.out.println(unitPo);
	}

	@Test
	public void testFindAll() {
		List<UnitPo> findAll = unitDao.findAll();
		System.out.println(findAll);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}
}
