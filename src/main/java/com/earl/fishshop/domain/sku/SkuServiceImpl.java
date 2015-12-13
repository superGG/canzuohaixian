package com.earl.fishshop.domain.sku;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "skuService")
public class SkuServiceImpl extends BaseServiceImpl<SkuPo> implements
		SkuService {

	@Resource(name = "skuDao")
	SkuDao skuDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = skuDao;
	}

	@Override
	public Boolean addSku(SkuPo model) {
		// TODO 未测试.
		try {
			model.setSkuName(model.getSkuName()+"("+model.getLowscale()+"-"+model.getHighscale()+")");
			skuDao.save(model);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
}
