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

import com.earl.fishshop.dao.UserDao;
import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.util.MyConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class UserDaoImplTest {

	@Resource
	UserDao userDao;
	
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

	//TODO lala
	@Test
	public void testSave() {
		UserPo user = new UserPo();
		user.setUserType(MyConstant.user_normal);
		user.setIdentityId(1L);
		user.setState(MyConstant.user_nopass);
		user.setUserName("易临风");
		user.setPassword("yilinfeng");
		user.setPhoneNumber("18719425973");
		user.setHeadImage("./head.jpg");
		
		userDao.save(user);
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
		List<UserPo> findAll = userDao.findAll();
		System.out.println(findAll);
	}
}
