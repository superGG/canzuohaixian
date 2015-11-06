//package com.earl.fishshop.serviceImpl;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import com.earl.fishshop.dao.ShopDao;
//import com.earl.fishshop.pojo.ShopPo;
//import com.earl.fishshop.service.ShopService;
//
///**
// * 每个ServiceImpl都要继承相对应的service接口
// * 
// * @author Administrator
// * 
// */
// @Service(value = "shopService")
//public class ShopServiceImpl extends BaseServiceImpl<ShopPo> implements
//		ShopService {
//
//	@Resource(name = "shopDao")
//	ShopDao shopDao;
//
//	@PostConstruct
//	public void initBaseDao(){
//		baseDao = shopDao;
//	}
//
//	@Override
//	public ShopPo getMyShop(Long userId) {
//		// TODO 未测试.
//		ShopPo shop = shopDao.getMyShop(userId);
//		return shop;
//	}
//
//	@Override
//	public Boolean updateSentPrice(Long shopId, Double sendPrice) {
//		// TODO 未测试.
//		try {
//			shopDao.updateSentPrice(shopId, sendPrice);
//			return true;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}
//	}
//	
//}
