package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.ShopDao;
import com.earl.fishshop.pojo.FarmersPo;
import com.earl.fishshop.pojo.FishmanPo;
import com.earl.fishshop.pojo.ShopPo;
import com.earl.fishshop.pojo.UserPo;
import com.earl.fishshop.service.ShopService;
import com.earl.fishshop.util.MyConstant;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "shopService")
public class ShopServiceImpl extends BaseServiceImpl<ShopPo> implements
		ShopService {

	@Resource(name = "shopDao")
	ShopDao shopDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = shopDao;
	}

	@Override
	public ShopPo getMyShop(Long userId) {
		// TODO 未测试.
		ShopPo shop = shopDao.getMyShop(userId);
		return shop;
	}

	@Override
	public Boolean updateSentPrice(Long shopId, Double sendPrice) {
		// TODO 未测试.
		try {
			shopDao.updateSentPrice(shopId, sendPrice);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean addShop(ShopPo model) {
		// TODO 未测试.
		try {
			UserPo userPo = userDao.get(model.getUserId());
			if(userPo.getUserType() == MyConstant.user_farmer){
				FarmersPo farmersPo = farmersDao.get(userPo.getIdentityId());
				model.setGetType(farmersPo.getMultiGetType());
				model.setAddress(farmersPo.getAddress());
				model.setOnSell(MyConstant.shop_onSell);
				shopDao.save(model);
			}else if(userPo.getUserType() == MyConstant.user_fishman){
				FishmanPo farmersPo = fishmanDao.get(userPo.getIdentityId());
				model.setGetType(String.valueOf(farmersPo.getGetType()));
				model.setOnSell(MyConstant.shop_notOnSell);
				shopDao.save(model);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Boolean endSeaing(Long shopId) {
		// TODO 未测试.
		ShopPo shopPo = shopDao.get(shopId);
		shopPo.setOnSell(false);
		boolean update = shopDao.update(shopPo);
		return update;
	}

}
