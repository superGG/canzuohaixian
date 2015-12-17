package com.earl.fishshop.domain.postage;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;

public interface PostageService extends BaseService<PostagePo>{

	/**
	 * 得到所有发货省，收货省.
	 * @author 黄祥谦.
	 * @return
	 */
	List<PostagePo> findAllPostage();

}
