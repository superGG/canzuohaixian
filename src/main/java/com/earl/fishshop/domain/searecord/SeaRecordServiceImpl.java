package com.earl.fishshop.domain.searecord;


import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.shipport.ShipPortPo;
import com.earl.fishshop.util.MyConstant;

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
			ShipPortPo shipPortPo = shipPortDao.get(model.getShipportId());
			model.setShipportName(shipPortPo.getShipportName());
			model.setLatitude(shipPortPo.getLatitude());
			model.setLongitude(shipPortPo.getLongitude());
			model.setState(MyConstant.searecord_seaing);
			seaRecordDao.addSeaRecord(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean aheadEndSeaing(Long shopId, Date endSeeTime) {
		// TODO 未测试.
		try {
			seaRecordDao.aheadEndSeaing(shopId,endSeeTime);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delayEndSeaing(Long shopId, Date endSeeTime) {
		// TODO 未测试.
		try {
			seaRecordDao.delayEndSeaing(shopId,endSeeTime);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean booleanEndSeaing(Long shopId) {
		// TODO 未测试.
		try {
			seaRecordDao.booleanEndSeaing(shopId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
}
