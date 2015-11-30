package com.earl.fishshop.domain.searecord;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;

public interface SeaRecordDao extends BaseDao<SeaRecordPo>{

	/**
	 * 添加出航记录
	 * @author 黄祥谦.
	 * @param model
	 */
	void addSeaRecord(SeaRecordPo model);

	/**
	 * 通过商店id获取航海记录.
	 *@author 宋文光.
	 * @param shopId
	 * @return
	 */
	List<SeaRecordPo> getSeaRecordByShop(Long shopId);

}
