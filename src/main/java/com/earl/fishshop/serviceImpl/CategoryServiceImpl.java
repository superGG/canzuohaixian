package com.earl.fishshop.serviceImpl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

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

	@Resource(name = "categoryDao")
	CategoryDao categoryDao;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryPo> getHotCategory(Map<String,Object> application) {
		// TODO 未测试.
		String object = (String) application.get("date");
		int i = Calendar.getInstance().get(Calendar.MONTH);
		int y = Calendar.getInstance().get(Calendar.YEAR);
		String date = y+"-"+String.valueOf(i);
		String date2 = y+"-"+String.valueOf(i+1);
		
		if(object != date){
			List<CategoryPo> categoryList = categoryDao.getHotCategory(date,date2, 6);
			application.put("hotGoods", categoryList);
			application.put("date", date);
			return categoryList;
		}else{
			return (List<CategoryPo>)application.get("hotGoods");
		}
	}
}
