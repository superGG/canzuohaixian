package com.earl.shopping.serverImpl;

import static org.junit.Assert.fail;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.service.UserService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class UserServiceImplTest {
	
	@Resource
	UserService userService ;

	@Test
	public void testGoodsServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		UserPo user = new UserPo();
		user.setUserName("宋文光");
		user.setUserType(2);
		user.setIdentityId(2l);
		user.setHeadImage("localhost:8080//aaa.jpg");
		user.setIsDelete(false);
		user.setPassword("123456");
		user.setPhoneNumber("15816498894");
		user.setState(2);
		user.setCreatorId(2l);
		user.setVersion(2l);
		
		userService.save(user);
	}
	
	@Test
	public void testGetUserByName() {
		String userName = "易临风";
		List<UserPo> userList = userService.getUserByName(userName);
		System.out.println("----------------完美分割线----------------");
		System.out.println(userList.get(0));
		System.out.println("----------------完美分割线----------------");
	}

	@Test
	public void testQueryByWord() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById(){
		
	}
	
}
