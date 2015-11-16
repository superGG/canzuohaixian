package com.earl.fishshop.dao;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.pojo.SeaRecordPo;

public interface SeaRecordDao extends BaseDao<SeaRecordPo>{

	/**
	 * 添加出航记录
	 * @author 黄祥谦.
	 * @param model
	 */
	void addSeaRecord(SeaRecordPo model);

}
