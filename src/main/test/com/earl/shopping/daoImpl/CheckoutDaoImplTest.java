package com.earl.shopping.daoImpl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.dao.CheckoutDao;
import com.earl.fishshop.pojo.CheckoutPo;
import com.earl.fishshop.pojo.UnitPo;
import com.earl.fishshop.util.MyConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class CheckoutDaoImplTest {

	@Resource
	CheckoutDao checkoutDao;

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

	// TODO lala
	@Test
	public void testSave() {
		//TODO 为测试.
		CheckoutPo checkout = new CheckoutPo();
		checkout.setIdentityId(1L);
		checkout.setUserType(MyConstant.user_fishman);
		checkout.setUserId(1L);
		checkout.setState(MyConstant.checkout_waitpass);
		checkoutDao.save(checkout);
	}

	@Test
	public void testPassRecord(){
		//TODO 未测试.
		checkoutDao.passRecord(1L);
		System.out.println("dodo");
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
	public void testDelete() {
		fail("Not yet implemented");
	}
}
