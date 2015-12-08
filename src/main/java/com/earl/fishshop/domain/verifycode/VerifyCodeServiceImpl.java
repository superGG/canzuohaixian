package com.earl.fishshop.domain.verifycode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	public void saveVerifyCode(final VerifyCodePo verifyCodePo) {
		List<VerifyCodePo> list = verifyCodeDao.getVerifyCode(verifyCodePo.getPhoneNumber());
		if ( list.size() != 0) {
			list.get(0).setVerifyCode(verifyCodePo.getVerifyCode());
			verifyCodeDao.update(list.get(0));
		} else {
			verifyCodeDao.save(verifyCodePo);
			SimpleDateFormat startdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println(startdate.format(new Date()));// new Date()为获取当前系统时间
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				public void run(){
					deleVerifyCodeByPhone(verifyCodePo.getPhoneNumber());
					SimpleDateFormat enddate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					System.out.println(enddate.format(new Date()));// new Date()为获取当前系统时间
					System.out.println("验证码已删除");
				}
			}, 60000);
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
	
	public void deleVerifyCodeByPhone(String phoneNumber){
		VerifyCodePo verifyCode = verifyCodeDao.getVerifyCode(phoneNumber).get(0);
		verifyCodeDao.deleteById(verifyCode.getVerifycodeId());
	}
}
