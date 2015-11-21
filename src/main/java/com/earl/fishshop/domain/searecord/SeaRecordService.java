package com.earl.fishshop.domain.searecord;

import com.earl.fishshop.base.BaseService;

public interface SeaRecordService extends BaseService<SeaRecordPo>{

	/**
	 * 添加出航记录
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Boolean addSeaRecord(SeaRecordPo model);

	

	
	
	
}
