package com.earl.fishshop.domain.postage;

import com.earl.fishshop.domain.base.BaseService;

public interface PostageService extends BaseService<PostagePo>{

	/**
	 * 添加物流
	 * @author 黄祥谦.
	 * @param model
	 * @param destinationList
	 * @return
	 */
	Boolean addPostage(PostagePo model, Long[] destinationList);


}
