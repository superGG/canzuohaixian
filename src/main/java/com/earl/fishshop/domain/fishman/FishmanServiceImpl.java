package com.earl.fishshop.domain.fishman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.gettype.GetTypeService;
import com.earl.fishshop.domain.searecord.SeaRecordPo;
import com.earl.fishshop.domain.shop.ShopPo;
import com.earl.fishshop.helper.JsonHelper;
import com.earl.fishshop.vo.MulitFileVo;
import com.earl.util.FileUploadImpl;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
@Service(value = "fishmanService")
public class FishmanServiceImpl extends BaseServiceImpl<FishmanPo> implements
		FishmanService {

	@Resource(name = "fishmanDao")
	FishmanDao fishmanDao;

	@PostConstruct
	public void initBaseDao() {
		baseDao = fishmanDao;
	}

	@Resource(name = "fileUpload")
	FileUploadImpl fileUpload;

	@Resource
	protected GetTypeService getTypeServer;

	@Override
	public Boolean authenticationFishman(Long userId, FishmanPo model,
			MulitFileVo fishmanFileVo) {
		List<String> photoPath = fileUpload.uploadFishmanFile(
				fishmanFileVo.getFile(), fishmanFileVo.getFileFileName());
		model.setFrontIdentityPhoto(photoPath.get(0));// 第一张是身份证正面
		model.setBackIdentityPhoto(photoPath.get(1));// 第二张是身份证背面
		model.setSeaPassPhoto(photoPath.get(2));// 第三张是船舶证

		List<String> shipPhotoList = new ArrayList<String>();
		shipPhotoList.add(photoPath.get(3));// 之后的是船的照片
		if (photoPath.size() >= 5) {
			for (int i = 4; i < photoPath.size(); i++) {
				shipPhotoList.add(photoPath.get(i));
			}
		}
		String shipPhoto = JsonHelper.toJson(shipPhotoList);
		model.setShipPhoto(shipPhoto);
		try {
			fishmanDao.authenticationFishman(userId, model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<FishmanPo> getFishman(Long fishmanId) {
		List<FishmanPo> list = fishmanDao.getFishman(fishmanId);
		return list;
	}

	@Override
	public Boolean passAuthenticationFishman(Long userId) {
		try {
			fishmanDao.passAuthenticationFishman(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean noPassAuthenticationFishman(Long userId, Long fishmanId) {
		try {
			fishmanDao.noPassAuthenticationFishman(userId);
			// fishmanDao.deleteById(fishmanId); //删除渔户
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<String, Object> getFishmanByShop(FishmanPo model) {
		Map<String, Object> map = new HashMap<String, Object>();// 存放一条信息
		ShopPo shop = shopDao.get(model.getShopId());
		SeaRecordPo seaRecordPo = seaRecordDao.get(shop.getShopId());
		List<FishmanPo> fishman = fishmanDao.getFishmanByShop(model.getShopId());
		map.put("fishman", fishman);
		map.put("shipportName", seaRecordPo.getShipportName());//预定靠岸口
		map.put("endSeeTime", seaRecordPo.getEndSeeTime());//预定靠岸时间
		String getName = getTypeServer.getGetTypeName(shop.getGetType());
		map.put("getName", getName);
		return map;

	}

}
