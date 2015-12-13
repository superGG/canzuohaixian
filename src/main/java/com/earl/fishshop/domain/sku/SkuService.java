package com.earl.fishshop.domain.sku;

import com.earl.fishshop.domain.base.BaseService;

public interface SkuService extends BaseService<SkuPo>{

	/**
	 * 添加规格.
	 * @author 黄祥谦.
	 * @param model
	 * @return
	 */
	Boolean addSku(SkuPo model);

	

	
	
	
}
