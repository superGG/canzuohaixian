package com.earl.fishshop.domain.goods;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.category.CategoryPo;
import com.earl.fishshop.domain.sku.SkuPo;
import com.earl.fishshop.vo.PageInfo;
import com.earl.fishshop.vo.SingleFileVo;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "goodsService")
public class GoodsServiceImpl extends BaseServiceImpl<GoodsPo> implements
		GoodsService {

	@Resource(name = "goodsDao")
	GoodsDao goodsDao;
	
	@PostConstruct
	public void initBaseDao(){
		baseDao = goodsDao;
	}

	@Override
	public Boolean updateGoodPrice(@SuppressWarnings("rawtypes") List goodsList) {
		try {
			goodsDao.updateGoodPrice(goodsList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean updateGoodNowNumber(@SuppressWarnings("rawtypes") List goodsList) {
		try {
			goodsDao.updateGoodNowNumber(goodsList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<GoodsPo> getGoodsWithCategory(Long cagtegoryId, PageInfo pageInfo) {
		List<GoodsPo> goodsList = goodsDao.getGoodsWithCategory(cagtegoryId, pageInfo);
		return goodsList;
	}

	@Override
	public List<CategoryPo> getCategoryWithTotalNumber(Long shopId, Integer indexPageNum, Integer size) {
		List<CategoryPo> goodsList = goodsDao.getCategoryWithTotalNumber(shopId, indexPageNum, size);
		return goodsList;
	}

	@Override
	public List<GoodsPo> getShopAllGoods(Long shopId, PageInfo pageInfo) {
		List<GoodsPo> goodsList = goodsDao.getShopAllGoods(shopId, pageInfo);
		for (GoodsPo goodsPo : goodsList) {
			goodsPo.setSkuString(skuDao.get(goodsPo.getSkuId()).getSkuName());
		}
		return goodsList;
	}

	@Override
	public GoodsPo getGoodsInfo(Long goodsId) {
		// TODO 未测试.
		GoodsPo goods = goodsDao.get(goodsId);
		return goods;
	}

	@Override
	public Boolean deletePointCategoryGoods(Long categoryId, Long shopId) {
		try {
			goodsDao.deletePointCategoryGoods(categoryId,shopId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean addGoods(CategoryPo model, SingleFileVo goodsFile) {
		// TODO 未测试.
		try {
			String goodsPhoto = fileUpload.uploadGoodsFile(goodsFile.getFile(), goodsFile.getFileFileName());
			CategoryPo categoryPo = categoryDao.get(model.getCategoryId());
			List<SkuPo> skuArrayList = model.getSkuArrayList();
			List<GoodsPo> arrayList = new ArrayList<GoodsPo>();
			for (SkuPo skuPo : skuArrayList) {
				GoodsPo goodsPo = new GoodsPo();
				BeanUtils.copyProperties(model, goodsPo);
				goodsPo.setGoodsPhoto(goodsPhoto);
				goodsPo.setGoodsQuality(0);
				goodsPo.setGetType(categoryPo.getGetType());
				goodsPo.setUnit(categoryPo.getUnit());
				goodsPo.setGoodsName(categoryPo.getCategorySimpleName());
				goodsPo.setSkuId(skuPo.getSkuId());
				goodsPo.setPrice(skuPo.getPrice());
				arrayList.add(goodsPo);
			}
			goodsDao.saveList(arrayList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<SkuPo> getPointCategoryGoodsInfo(Long shopId, Long categoryId) {
		// TODO 未测试.
		List<SkuPo> pointCategoryGoodsInfo = goodsDao.getPointCategoryGoodsInfo(shopId,categoryId);
		return pointCategoryGoodsInfo;
	}

	@Override
	public List<GoodsPo> getShopPointCategory(Long shopId, Long categoryId, Integer indexPageNum, Integer size) {
		// TODO 未测试.
		List<GoodsPo> goodsList = goodsDao.getShopPointCategory(shopId,categoryId, indexPageNum, size);
		return goodsList;
	}

}
