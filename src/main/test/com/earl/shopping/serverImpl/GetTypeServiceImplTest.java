package com.earl.shopping.serverImpl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.domain.gettype.GetTypeService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class GetTypeServiceImplTest {
	
	@Resource
	GetTypeService getTypeService ;

	@Test
	public void testGetGetTypeName() {
		String getType = "[2,3,4]";
		getTypeService.getGetTypeName(getType);
	}

	
	
	
	
}
