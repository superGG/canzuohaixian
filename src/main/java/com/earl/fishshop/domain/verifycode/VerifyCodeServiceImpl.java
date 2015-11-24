package com.earl.fishshop.domain.verifycode;

import java.util.List;

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
 @Service(value = "verifyCodeService")
public class VerifyCodeServiceImpl extends BaseServiceImpl<VerifyCodePo> implements
		VerifyCodeService {

	@Resource(name = "verifyCodeDao")
	VerifyCodeDao verifyCodeDao;

//	@PreDestroy(对象销毁前)
	@PostConstruct//在构造函数之后执行.
	public void initBaseDao(){
		baseDao = verifyCodeDao;
	}

	@Override
	public void saveVerifyCode(VerifyCodePo verifyCodePo) {
		List<VerifyCodePo> list = verifyCodeDao.getVerifyCode(verifyCodePo.getPhoneNumber());
		if ( list.size() != 0) {
			list.get(0).setVerifyCode(verifyCodePo.getVerifyCode());
			verifyCodeDao.update(list.get(0));
		} else {
			verifyCodeDao.save(verifyCodePo);
		}
	}

	@Override
	public String getVerifyCode(String phoneNumber) {
		List<VerifyCodePo> list = verifyCodeDao.getVerifyCode(phoneNumber);
		if (list.size() != 0) {
			String verifyCode = list.get(0).getVerifyCode();
			return verifyCode;
		} else return null;
	}
}
