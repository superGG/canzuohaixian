package com.earl.fishshop.domain.goods;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.vo.PageInfo;

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
	public Boolean updateGoodPrice(Long goodsId, Double price) {
		try {
			goodsDao.updateGoodPrice(goodsId,price);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean updateGoodNowNumber(Long goodsId, Long nowNumber) {
		try {
			goodsDao.updateGoodNowNumber(goodsId,nowNumber);
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
	public List<CategoryPo> getCategoryWithTotalNumber(Long shopId) {
		List<CategoryPo> goodsList = goodsDao.getCategoryWithTotalNumber(shopId);
		return goodsList;
	}

	@Override
	public List<GoodsPo> getShopAllGoods(Long shopId, PageInfo pageInfo) {
		List<GoodsPo> goodsList = goodsDao.getShopAllGoods(shopId, pageInfo);
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

}
