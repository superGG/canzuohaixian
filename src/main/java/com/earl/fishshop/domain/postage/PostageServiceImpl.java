package com.earl.fishshop.domain.postage;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "postageService")
public class PostageServiceImpl extends BaseServiceImpl<PostagePo> implements
		PostageService {

	@Resource(name = "postageDao")
	PostageDao postageDao;

//	@PreDestroy(对象销毁前)
	@PostConstruct//在构造函数之后执行.
	public void initBaseDao(){
		baseDao = postageDao;
	}

	@Override
	public Boolean addPostage(PostagePo model, Long[] destinationList) {
		// TODO 未测试.
		try {
		for (Long long1 : destinationList) {
				PostagePo postagePo = new PostagePo();
				BeanUtils.copyProperties(postagePo, model);
				postagePo.setDestination(long1.toString());
				postageDao.save(postagePo);
		}
		return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}

}
