package com.earl.fishshop.domain.postage;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;
import com.earl.fishshop.domain.region.RegionPo;

public interface PostageService extends BaseService<PostagePo>{

	/**
	 * 得到所有发货省，收货省.
	 * @author 黄祥谦.
	 * @return
	 */
	List<PostagePo> findAllPostage();

	/**
	 * 得到未指定邮费的省份
	 * @author 黄祥谦.
	 * @param valueOf
	 * @return
	 */
	List<RegionPo> getUnSetRegion(Long valueOf);

}
