//package com.earl.fishshop.serviceImpl;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import com.earl.fishshop.dao.FishmanDao;
//import com.earl.fishshop.pojo.FishmanPo;
//import com.earl.fishshop.service.FishmanService;
//
///**
// * 每个ServiceImpl都要继承相对应的service接口
// * 
// * @author Administrator
// * 
// */
// @Service(value = "fishmanService")
//public class FishmanServiceImpl extends BaseServiceImpl<FishmanPo> implements
//		FishmanService {
//
//	@Resource(name = "fishmanDao")
//	FishmanDao fishmanDao;
//
//	@PostConstruct
//	public void initBaseDao(){
//		baseDao = fishmanDao;
//	}
//
//	@Override
//	public Boolean authenticationFishman(Long userId, FishmanPo model) {
//		// TODO 未测试.
//		try {
//			fishmanDao.authenticationFishman(userId,model);
//			return true;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}
//	}
//	
//}
