package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.GoodsDao;
import com.earl.fishshop.pojo.CategoryPo;
import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.service.GoodsService;

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
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean updateGoodNowNumber(Long goodsId, Long nowNumber) {
		try {
			goodsDao.updateGoodNowNumber(goodsId,nowNumber);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public List<GoodsPo> getGoodsWithCategory(Integer goodsCategory) {
		// TODO 未测试.
		List<GoodsPo> goodsList = goodsDao.getGoodsWithCategory(goodsCategory);
		return goodsList;
	}

	@Override
	public List<CategoryPo> getCategoryWithTotalNumber(Long shopId) {
		// TODO 未测试.
		List<CategoryPo> goodsList = goodsDao.getCategoryWithTotalNumber(shopId);
		return goodsList;
	}
	
}
