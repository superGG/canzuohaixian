package com.earl.fishshop.domain.farmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.gettype.GetTypeService;
import com.earl.fishshop.domain.shop.ShopPo;
import com.earl.fishshop.helper.JsonHelper;
import com.earl.fishshop.util.MyConstant;
import com.earl.fishshop.vo.MulitFileVo;
import com.earl.util.FileUploadImpl;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
@Service(value = "farmersService")
public class FarmersServiceImpl extends BaseServiceImpl<FarmersPo> implements
		FarmersService {

	@Resource(name = "farmersDao")
	FarmersDao farmersDao;

	@PostConstruct
	public void initBaseDao() {
		baseDao = farmersDao;
	}
	
	@Resource
	protected GetTypeService getTypeServer;

	@Resource(name = "fileUpload")
	FileUploadImpl fileUpload;

	@Override
	public Boolean authenticationFarmer(Long userId, FarmersPo model,
			MulitFileVo farmersFileVo) {
		List<String> photoPath = fileUpload.uploadFarmerFile(
				farmersFileVo.getFile(), farmersFileVo.getFileFileName());
		model.setForntIdentityPhoto(photoPath.get(0));//第一张是身份证正面
		model.setBackIdentityPhoto(photoPath.get(1));//第二张是身份证背面
		
		List<String> addressPhotoList = new ArrayList<String>();//将之后养殖场照片放到list中装成json
		addressPhotoList.add(photoPath.get(2));
		if(photoPath.size() >= 4) {
			for (int i=3; i<photoPath.size(); i++) {
				addressPhotoList.add(photoPath.get(i));
			}
		}
		String addressPhoto = JsonHelper.toJson(addressPhotoList);
		model.setAddressPhoto(addressPhoto);
		try {
			farmersDao.authenticationFarmers(userId, model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<FarmersPo> getFarmers(Long farmersId) {
		List<FarmersPo> list = farmersDao.getFarmers(farmersId);
		return list;
	}

	@Override
	public Boolean passAuthenticationFarmers(Long userId,FarmersPo model) {
		try {
			farmersDao.passAuthenticationFarmers(userId);
			
			String shopName = "养殖户商店"+String.valueOf(userId);
			ShopPo shop = new ShopPo();
			shop.setUserId(userId);
			shop.setShopName(shopName);
			shop.setShopType(MyConstant.shop_farmerman);
			shop.setOnSell(true);
			Long shopId = shopDao.addShop(shop); //添加新的商店
			
			FarmersPo farmer = farmersDao.get(model.getFarmersId());
			farmer.setShopId(shopId);
			farmersDao.update(farmer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean noPassAuthenticationFarmers(Long userId, Long farmersId) {
		try {
			farmersDao.noPassAuthenticationFarmers(userId);
			// farmersDao.deleteById(farmersId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<String, Object> getFarmerByShop(FarmersPo model) {
		Map<String, Object> map = new HashMap<String, Object>();// 存放一条信息
		ShopPo shop = shopDao.get(model.getShopId());
		FarmersPo farmer = farmersDao.getFarmerByShop(model.getShopId());
		map.put("farmer", farmer);
		map.put("address", shop.getAddress());//养殖场地址
		String getName = getTypeServer.getGetTypeName(shop.getGetType());
		map.put("getName", getName);
		return map;
	}

}
