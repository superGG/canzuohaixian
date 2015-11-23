package com.earl.fishshop.domain.searecord;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;
import com.earl.fishshop.domain.shop.ShopPo;


/**
 * 
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

}