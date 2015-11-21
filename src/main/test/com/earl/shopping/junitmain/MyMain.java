package com.earl.shopping.junitmain;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.earl.fishshop.domain.category.CategoryPo;
import com.earl.fishshop.vo.CategoryForxxxVo;
import com.earl.util.FilterPropertiesUtil;

public class MyMain {
	
	CategoryPo category;
	
	@Before
	public void aaa(){
		category = new CategoryPo();
		category.setCategoryId(1L);
		category.setCreateTime(new Date());
		category.setHotDegree(5L);
		category.setIsDelete(false);
		category.setLowPrice(34.5);
		category.setTotalNowNumber(55L);
		category.setCategorySimpleName("东星白班鱼");
		category.setCategoryAcademicName("东星白班鱼");
		category.setCategoryEnglishName("whitefish");
		category.setFishPhoto("localhost:8080//aaa.jpg");
		category.setParentId(1l);
		category.setIsDelete(false);
		category.setGetType(3);
		category.setUnit(1);
		category.setVersion(1L);
		category.setTotalSellNumber(0L);
	}

	@Test
	public void testFilterProperties() throws IllegalArgumentException, IllegalAccessException {
		CategoryPo filterProperties = FilterPropertiesUtil.filterProperties(category, CategoryForxxxVo.class);
		System.out.println("filterProperties:"+filterProperties);
	}

	@Test
	public void testFilterProperties2() throws IllegalAccessException, InvocationTargetException, InstantiationException{
		CategoryForxxxVo filterProperties2 = (CategoryForxxxVo) FilterPropertiesUtil.filterProperties2(category, CategoryForxxxVo.class);
		System.out.println("filterProperties2:"+filterProperties2);
	}
	
}
