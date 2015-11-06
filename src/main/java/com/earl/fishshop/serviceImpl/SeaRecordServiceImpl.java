package com.earl.fishshop.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.SeaRecordDao;
import com.earl.fishshop.pojo.SeaRecordPo;
import com.earl.fishshop.service.SeaRecordService;

/**
 * 每个ServiceImpl都要继承相对应的service接口
 * 
 * @author Administrator
 * 
 */
 @Service(value = "seaRecordService")
public class SeaRecordServiceImpl extends BaseServiceImpl<SeaRecordPo> implements
		SeaRecordService {

	@Resource(name = "seaRecordDao")
	SeaRecordDao seaRecordDao;

	@PostConstruct
	public void initBaseDao(){
		baseDao = seaRecordDao;
	}
	
}
