package com.earl.fishshop.domain.searecord;

import java.util.Date;

import com.earl.fishshop.domain.base.BaseService;

public interface SeaRecordService extends BaseService<SeaRecordPo>{

	/**
	 * 添加出航记录
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Boolean addSeaRecord(SeaRecordPo model);

	/**
	 * 商家提前到港.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param endSeeTime
	 * @return
	 */
	Boolean aheadEndSeaing(Long shopId, Date endSeeTime);

	/**
	 * 商家延迟到港.
	 * @author 黄祥谦.
	 * @param shopId
	 * @param endSeeTime
	 * @return
	 */
	Boolean delayEndSeaing(Long shopId, Date endSeeTime);

	/**
	 * 检测商家是否到港.
	 * @author 黄祥谦.
	 * @param shopId
	 * @return
	 */
	Boolean booleanEndSeaing(Long shopId);

	

	
	
	
}
