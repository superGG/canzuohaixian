package com.earl.fishshop.domain.farmers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.vo.FarmersFileVo;
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

	@Resource(name = "fileUpload")
	FileUploadImpl fileUpload;

	@Override
	public Boolean authenticationFarmer(Long userId, FarmersPo model,
			FarmersFileVo farmersFileVo) {
		List<String> photoPath = fileUpload.uploadFarmerFile(
				farmersFileVo.getFile(), farmersFileVo.getFileFileName());
		model.setForntIdentityPhoto(photoPath.get(0));
		model.setBackIdentityPhoto(photoPath.get(1));
		String addressPhoto = photoPath.get(2);
		if(photoPath.size() >= 4) {
			for (int i=3; i<photoPath.size()-1; i++) {
				addressPhoto = addressPhoto + ";" + photoPath.get(i);
			}
		}
		model.setAddressPhoto(addressPhoto);
		try {
			farmersDao.authenticationFarmers(userId, model);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<FarmersPo> getFarmers(Long identityId) {
		List<FarmersPo> list = farmersDao.getFarmers(identityId);
		return list;
	}

	@Override
	public Boolean passAuthenticationFarmers(Long userId) {
		try {
			farmersDao.passAuthenticationFarmers(userId);
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

}
