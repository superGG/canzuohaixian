package com.earl.fishshop.daoImpl;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.SeaRecordDao;
import com.earl.fishshop.pojo.SeaRecordPo;
import com.earl.fishshop.pojo.ShopPo;


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