package com.earl.fishshop.domain.searecord;

import com.earl.fishshop.domain.base.BaseDao;
import com.earl.fishshop.domain.shop.ShopPo;

public interface SeaRecordDao extends BaseDao<SeaRecordPo>{

	/**
	 * 添加出航记录
	 * @author 黄祥谦.
	 * @param model
	 */
	void addSeaRecord(SeaRecordPo model);

	/**
	 * 商家提前到港. 
	 * @author 黄祥谦.
	 * @param shop
	 * @param seaRecord
	 */
	void updateShopAndSeaRecord(ShopPo shop, SeaRecordPo seaRecord);

}
