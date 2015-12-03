package com.earl.fishshop.domain.searecord;

import java.util.Date;

import com.earl.fishshop.domain.base.BaseDao;

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
	 * @param shopId
	 * @param endSeeTime
	 */
	void aheadEndSeaing(Long shopId, Date endSeeTime);

	/**
	 * 商家延迟到港.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param endSeeTime
	 */
	void delayEndSeaing(Long shopId, Date endSeeTime);

	/**
	 * 查看商家是否已经到港.true 代表到港， false 代表未到港
	 * @author 黄祥谦.
	 * @param shopId
	 * @return TODO
	 */
	Boolean booleanEndSeaing(Long shopId);

}
