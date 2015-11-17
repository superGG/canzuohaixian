package com.earl.fishshop.service;

import com.earl.fishshop.pojo.SeaRecordPo;

public interface SeaRecordService extends BaseService<SeaRecordPo>{

	/**
	 * 添加出航记录
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Boolean addSeaRecord(SeaRecordPo model);

	

	
	
	
}
