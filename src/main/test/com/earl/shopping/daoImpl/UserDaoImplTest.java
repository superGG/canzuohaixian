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

	@Test
	public void testSave() {
		UserPo user = new UserPo();
<<<<<<< HEAD
		user.setUserType(MyConstant.user_normal);
		user.setIdentityId(1L);
		user.setState(MyConstant.user_nopass);
		user.setUserName("易临风");
		user.setPassword("yilinfeng");
		user.setPhoneNumber("18719425973");
		user.setHeadImage("./head.jpg");
=======
		user.setUserName("superGG");
		user.setUserType(1);
		user.setIdentityId(1l);
		user.setHeadImage("localhost:8080//aaa.jpg");
		user.setIsDelete(false);
		user.setPassword("123456");
		user.setPhoneNumber("18320489492");
		user.setState(1);
		user.setCreatorId(1l);
		user.setVersion(1l);
>>>>>>> db799ae80bd32d22f82a0ed49f74e95790fa3040
		
		userDao.save(user);
	}

	@Test
	public void testUpdate() {
		UserPo user = new UserPo();
		user.setUserId(2l);
		user.setUserName("superGG");
		user.setUserType(1);
		user.setIdentityId(1l);
		user.setHeadImage("localhost:8080//aaa.jpg");
		user.setIsDelete(false);
		user.setPassword("654321");
		user.setPhoneNumber("18320489492");
		user.setState(1);
		user.setCreatorId(1l);
		user.setVersion(1l);
		
		userDao.update(user);
	}
	
	@Test
	public void testGetUserByPhone() {
		String phone = "18320489492";
		List<UserPo> userList = userDao.getUserByPhone(phone);
		System.out.println("----------------完美分割线----------------");
		System.out.println(userList);
		System.out.println("----------------完美分割线----------------");
	}
	
	@Test
	public void testGetUserByName() {
		String userName = "superGG";
		List<UserPo> userList = userDao.getUserByName(userName);
		System.out.println("----------------完美分割线----------------");
		System.out.println(userList);
		System.out.println("----------------完美分割线----------------");
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
