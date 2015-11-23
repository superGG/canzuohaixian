package com.earl.fishshop.domain.fishman;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.vo.FishmanFileVo;
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

	@Override
	public Boolean authenticationFishman(Long userId, FishmanPo model,
			FishmanFileVo fishmanFileVo) {
		// TODO 未测试.
		List<String> photoPath = fileUpload.uploadFishmanFile(
				fishmanFileVo.getFile(), fishmanFileVo.getFileFileName());
		model.setFrontIdentityPhoto(photoPath.get(0));//第一张是身份证正面
		model.setBackIdentityPhoto(photoPath.get(1));//第二张是身份证背面
		model.setSeaPassPhoto(photoPath.get(2));//第三张是船舶证
		String shipPhoto = photoPath.get(3);//之后的是船的照片
		if (photoPath.size() >= 5) {
			for (int i = 4; i < photoPath.size()-1; i++) {
				shipPhoto = shipPhoto + ";" + photoPath.get(i);
			}
		}
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
	public List<FishmanPo> getFishman(Long identityId) {
		List<FishmanPo> list = fishmanDao.getFishman(identityId);
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

}
