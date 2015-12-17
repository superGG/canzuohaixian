package com.earl.fishshop.domain.searecord;


import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.base.BaseServiceImpl;
import com.earl.fishshop.domain.shipport.ShipPortPo;
import com.earl.fishshop.domain.shop.ShopPo;
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
			model.setLongitude(shipPortPo.getLontitude());
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
			ShopPo shop= shopDao.get(shopId);
			if(shop.getSeaRecordId() == null){
				throw new RuntimeException("商店已经到港，请勿重复操作！");
			}
			SeaRecordPo seaRecordPo = seaRecordDao.get(shop.getSeaRecordId());
			seaRecordPo.setEndSeeTime(endSeeTime);
			seaRecordPo.setState(MyConstant.searecord_ahead);
			shop.setOnSell(MyConstant.shop_notOnSell);
			shop.setSeaRecordId(null);
			seaRecordDao.updateShopAndSeaRecord(shop,seaRecordPo);
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
			ShopPo shop= shopDao.get(shopId);
			if(shop.getSeaRecordId() == null){
				throw new RuntimeException("商店已经到港，请勿重复操作！");
			}
			SeaRecordPo seaRecordPo = seaRecordDao.get(shop.getSeaRecordId());
			seaRecordPo.setEndSeeTime(endSeeTime);
			seaRecordPo.setState(MyConstant.searecord_delay);
			seaRecordDao.update(seaRecordPo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean booleanEndSeaing(Long shopId) {
		// TODO 未测试.
			ShopPo shop= shopDao.get(shopId);
			SeaRecordPo seaRecordPo = get(shop.getSeaRecordId());
			Date date = new Date();
			long  between = date.getTime() - seaRecordPo.getEndSeeTime().getTime();
			if(between > 0){
				shop.setOnSell(MyConstant.shop_notOnSell);
				shop.setSeaRecordId(null);
				shopDao.update(shop);
			    return true;
			}
		return false;
	}
	
}
