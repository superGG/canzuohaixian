package com.earl.shopping.serverImpl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.service.CategoryService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class CategoryServiceImplTest {
	
	@Resource
	CategoryService categoryService ;

	@Test
	public void testGoodsServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHotCategory() {
//		List<CategoryPo> hotCategory = categoryService.getHotCategory();
//		System.out.println(hotCategory);
	}

	
}
