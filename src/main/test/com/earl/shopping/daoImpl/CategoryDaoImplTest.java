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

import com.earl.fishshop.dao.CategoryDao;
import com.earl.fishshop.pojo.CategoryPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class CategoryDaoImplTest {

	@Resource
	CategoryDao categoryDao;
	
	@Resource(name="sessionFactory")
	SessionFactoryImpl sessionFactory;
	
	@Resource(name="transactionManager")
	HibernateTransactionManager transactionManager;
	
	//TODO lala
	@Test
	public void testSave() {
		CategoryPo category = new CategoryPo();
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
		
		categoryDao.save(category);
	}

	@Test
	public void testGetTopCategory(){
		List<CategoryPo> categoryList = categoryDao.getTopCategory();
		System.out.println(categoryList);
	}

	@Test
	public void testGetNextLevelCategory(){
		List<CategoryPo> categoryList = categoryDao.getNextLevelCategory(1L);
		System.out.println(categoryList);
		
	}

	@Test
	public void testGetHierarchyCategory(){
		List<CategoryPo> categoryHire = categoryDao.getHierarchyCategory();
		System.out.println(categoryHire);
	}

	@Test
	public void testDeleteById() {
		categoryDao.deleteById(1L);
	}

	@Test
	public void testGet() {
		CategoryPo category = categoryDao.get(1L);
		System.out.println(category);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAll() {
		fail("Not yet implemented");
	}
}
