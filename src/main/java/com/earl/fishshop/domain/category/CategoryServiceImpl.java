package com.earl.fishshop.domain.category;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.gettype.GetTypePo;
import com.earl.fishshop.domain.searecord.SeaRecordPo;
import com.earl.fishshop.domain.shop.ShopPo;
import com.earl.fishshop.domain.user.UserPo;
import com.earl.fishshop.helper.JsonHelper;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.vo.PageInfo;
import com.earl.fishshop.vo.SingleFileVo;
import com.earl.util.FilterPropertiesUtil;

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
		for (CategoryPo categoryPo : nextLevelCategory) {
			try {
				FilterPropertiesUtil.filterProperties(categoryPo, CategoryForNextLevel.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		
		if(!date.equals(object)){
			List<CategoryPo> categoryList = categoryDao.getHotCategory(date,date2, 6);
			application.put("hotGoods", categoryList);
			application.put("date", date);
			return categoryList;
		}else{
			return (List<CategoryPo>)application.get("hotGoods");
		}
	}

	@Override
	public List<ShopPo> getGoodsShops(Long categoryId, Integer indexPageNum, Integer size) {
		List<ShopPo> shopList = shopDao.getGoodsShops(categoryId,indexPageNum, size);
		for (ShopPo shopPo : shopList) {
			UserPo userPo = userDao.get(shopPo.getUserId());
			if(userPo.getUserType() == MyConstant.user_farmer){
			}else if(userPo.getUserType() == MyConstant.user_fishman){
				if(shopPo.getSeaRecordId() != null){
					SeaRecordPo serecord = seaRecordDao.get(shopPo.getSeaRecordId());
					shopPo.setPortTime(serecord.getEndSeeTime());
					shopPo.setShipPort(serecord.getShipportName());
					shopPo.setLatitude(serecord.getLatitude());
					shopPo.setLongitude(serecord.getLongitude());
				}
			}
			String getType = shopPo.getGetType();
			ArrayList<String> getTypeName = new ArrayList<String>();
			@SuppressWarnings("unchecked")
			List<Double> jsonToBean = JsonHelper.jsonToBean(getType, List.class);
			for (Double long1 : jsonToBean) {
				GetTypePo getTypePo = getTypeDao.get(long1.longValue());
				getTypeName.add(getTypePo.getGetName());
			}
			shopPo.setGetTypeString(getTypeName);
		}
		return shopList;
	}

	@Override
	public List<ShopPo> getGoodsFarmerShops(Long categoryId, PageInfo pageInfo) {
		List<ShopPo> shopList = shopDao.getPointTypeGoodsShops(categoryId,MyConstant.shop_farmerman, pageInfo);
		return shopList;
	}
	
	@Override
	public List<ShopPo> getGoodsFishShops(Long categoryId, PageInfo pageInfo) {
		List<ShopPo> shopList = shopDao.getPointTypeGoodsShops(categoryId,MyConstant.shop_fishman, pageInfo);
		return shopList;
	}

	@Override
	public Boolean addCategory(CategoryPo model, SingleFileVo categoryFile) {
		try {
			String uploadCategoryFile = fileUpload.uploadCategoryFile(categoryFile.getFile(), categoryFile.getFileFileName());
			model.setFishPhoto(uploadCategoryFile);
			categoryDao.addCategory(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean updateCategory(CategoryPo model, SingleFileVo categoryFile) {
		// TODO 未测试.
		try {
				String uploadCategoryFile = fileUpload.uploadCategoryFile(categoryFile.getFile(), categoryFile.getFileFileName());
				model.setFishPhoto(uploadCategoryFile);
			categoryDao.updateCategory(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CategoryPo getCategoryWithSku(Long categoryId) {
		// TODO 未测试.
		CategoryPo category = categoryDao.getCategoryWithSku(categoryId);
		return category;
	}

	@Override
	public List<CategoryPo> getAllNextLevelCategory() {
		// TODO 未测试.
		List<CategoryPo> categoryList = categoryDao.getAllNextLevelCategory();
		return categoryList;
	}
	
	@Override
	public List<ShopPo> getGoodsShops(Long categoryId, Integer indexPageNum, Integer size,Integer sortType) {
		List<ShopPo> shopList = shopDao.getGoodsShops(categoryId,indexPageNum, size,sortType);
		for (ShopPo shopPo : shopList) {
			UserPo userPo = userDao.get(shopPo.getUserId());
			if(userPo.getUserType() == MyConstant.user_farmer){
				
			}else if(userPo.getUserType() == MyConstant.user_fishman){
				if(shopPo.getSeaRecordId() != null){
					SeaRecordPo serecord = seaRecordDao.get(shopPo.getSeaRecordId());
					shopPo.setPortTime(serecord.getEndSeeTime());
					shopPo.setShipPort(serecord.getShipportName());
					shopPo.setLatitude(serecord.getLatitude());
					shopPo.setLongitude(serecord.getLongitude());
				}
			}
			String getType = shopPo.getGetType();
			ArrayList<String> getTypeName = new ArrayList<String>();
			@SuppressWarnings("unchecked")
			List<Double> jsonToBean = JsonHelper.jsonToBean(getType, List.class);
			for (Double long1 : jsonToBean) {
				GetTypePo getTypePo = getTypeDao.get(long1.longValue());
				getTypeName.add(getTypePo.getGetName());
			}
			shopPo.setGetTypeString(getTypeName);
		}
		return shopList;
	}

	@Override
	public List<ShopPo> getGoodsFarmerShops(Long categoryId, PageInfo pageInfo,Integer sortType) {
		List<ShopPo> shopList = shopDao.getPointTypeGoodsShops(categoryId,MyConstant.shop_farmerman, pageInfo,sortType);
		return shopList;
	}
	
	@Override
	public List<ShopPo> getGoodsFishShops(Long categoryId, PageInfo pageInfo,Integer sortType) {
		List<ShopPo> shopList = shopDao.getPointTypeGoodsShops(categoryId,MyConstant.shop_fishman, pageInfo,sortType);
		return shopList;
	}

}
