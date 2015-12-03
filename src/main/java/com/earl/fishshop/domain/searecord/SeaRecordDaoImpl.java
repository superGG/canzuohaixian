package com.earl.fishshop.domain.searecord;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;
import com.earl.fishshop.domain.shop.ShopPo;

/**
 * 
 */
@Repository("seaRecordDao")
public class SeaRecordDaoImpl extends BaseDaoImpl<SeaRecordPo> implements SeaRecordDao {

	@Override
	public void addSeaRecord(SeaRecordPo model) {
		// TODO 未测试.
		Long save = (Long) getCurrentSession().save(model);
		ShopPo shop= (ShopPo) getCurrentSession().get(ShopPo.class, save);
		shop.setSeaRecordId(save);
		shop.setOnSell(true);
		getCurrentSession().save(shop);
	}

	@Override
	public void aheadEndSeaing(Long shopId, Date endSeeTime) {
		// TODO 未测试.
		ShopPo shop= (ShopPo) getCurrentSession().get(ShopPo.class, shopId);
		SeaRecordPo seaRecordPo = get(shop.getSeaRecordId());
		seaRecordPo.setEndSeeTime(endSeeTime);
		shop.setOnSell(false);
		shop.setSeaRecordId(null);
		getCurrentSession().update(shop);
		getCurrentSession().update(seaRecordPo);
		
	}

	@Override
	public void delayEndSeaing(Long shopId, Date endSeeTime) {
		// TODO 未测试.
		ShopPo shop= (ShopPo) getCurrentSession().get(ShopPo.class, shopId);
		SeaRecordPo seaRecordPo = get(shop.getSeaRecordId());
		seaRecordPo.setEndSeeTime(endSeeTime);
		getCurrentSession().update(seaRecordPo);
	}

	@Override
	public Boolean booleanEndSeaing(Long shopId) {
		ShopPo shop= (ShopPo) getCurrentSession().get(ShopPo.class, shopId);
		SeaRecordPo seaRecordPo = get(shop.getSeaRecordId());
		Date date = new Date();
		long  between = date.getTime() - seaRecordPo.getEndSeeTime().getTime();
		if(between > 0){
			shop.setOnSell(false);
			shop.setSeaRecordId(null);
		    return true;
		}
		return false;
	}

}