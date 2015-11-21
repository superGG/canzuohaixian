package com.earl.fishshop.domain.searecord;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.base.BaseServiceImpl;
import com.earl.fishshop.pojo.SeaRecordPo;

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

	@Override
	public Boolean addSeaRecord(SeaRecordPo model) {
		// TODO 未测试.
		try {
			seaRecordDao.addSeaRecord(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
