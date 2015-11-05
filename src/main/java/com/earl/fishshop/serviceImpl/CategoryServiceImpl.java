package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.CategoryDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.service.CategoryService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
@Service(value = "categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<CategoryPo> implements
		CategoryService {
	// public GoodsServiceImpl() {
	// baseDao = goodsDao;
	// }

	@Resource(name = "categoryDao")
	CategoryDao categoryDao;

	// @PreDestroy
	@PostConstruct
	public void initBaseDao() {
		baseDao = categoryDao;
	}

	@Override
	public List<CategoryPo> getHierarchyCategory() {
		List<CategoryPo> categoryList = categoryDao.getHierarchyCategory();
		return categoryList;
	}

	@Override
	public List<CategoryPo> getTopCategory() {
		List<CategoryPo> categoryList = categoryDao.getTopCategory();
		return categoryList;
	}

	@Override
	public List<CategoryPo> getNextLevelCategory(Long parentId) {
		List<CategoryPo> nextLevelCategory = categoryDao
				.getNextLevelCategory(parentId);
		return nextLevelCategory;
	}

}
