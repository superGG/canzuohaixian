package com.earl.fishshop.serviceImpl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.CategoryDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.SeaRecordPo;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.service.CategoryService;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.vo.PageInfo;

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
	public List<CategoryPo> getNextLevelCategory(Long parentId, PageInfo pageInfo) {
		List<CategoryPo> nextLevelCategory = categoryDao
				.getNextLevelCategory(parentId, pageInfo);
		return nextLevelCategory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryPo> getHotCategory(Map<String,Object> application) {
		String object = (String) application.get("date");
		int i = Calendar.getInstance().get(Calendar.MONTH);
		int y = Calendar.getInstance().get(Calendar.YEAR);
		String date = y+"-"+String.valueOf(i)+"-1";
		String date2 = y+"-"+String.valueOf(i+1)+"-1";
		
		if(!object.equals(date)){
			List<CategoryPo> categoryList = categoryDao.getHotCategory(date,date2, 6);
			application.put("hotGoods", categoryList);
			application.put("date", date);
			return categoryList;
		}else{
			return (List<CategoryPo>)application.get("hotGoods");
		}
	}

	@Override
	public List<ShopPo> getGoodsShops(Long categoryId, PageInfo pageInfo) {
		List<ShopPo> shopList = shopDao.getGoodsShops(categoryId,pageInfo);
		for (ShopPo shopPo : shopList) {
			UserPo userPo = userDao.get(shopPo.getUserId());
			if(userPo.getUserType() == MyConstant.user_farmer){
			}else if(userPo.getUserType() == MyConstant.user_fishman){
				SeaRecordPo farmersPo = seaRecordDao.get(shopPo.getSeaRecordId());
				shopPo.setShipPort(farmersPo.getShipportName());
				shopPo.setLatitude(farmersPo.getLatitude());
				shopPo.setLongitude(farmersPo.getLongitude());
			}
		}
		return shopList;
	}

	@Override
	public List<ShopPo> getGoodsFarmerShops(Long categoryId, PageInfo pageInfo) {
		// TODO 未测试.
		List<ShopPo> shopList = shopDao.getPointTypeGoodsShops(categoryId,MyConstant.shop_farmerman, pageInfo);
		return shopList;
	}
	
	@Override
	public List<ShopPo> getGoodsFishShops(Long categoryId, PageInfo pageInfo) {
		// TODO 未测试.
		List<ShopPo> shopList = shopDao.getPointTypeGoodsShops(categoryId,MyConstant.shop_fishman, pageInfo);
		return shopList;
	}
}
