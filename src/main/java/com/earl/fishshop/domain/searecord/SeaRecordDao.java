package com.earl.fishshop.domain.searecord;

import com.earl.fishshop.base.BaseDao;

public interface SeaRecordDao extends BaseDao<SeaRecordPo>{

	/**
	 * 添加出航记录
	 * @author 黄祥谦.
	 * @param model
	 */
	void addSeaRecord(SeaRecordPo model);

}
