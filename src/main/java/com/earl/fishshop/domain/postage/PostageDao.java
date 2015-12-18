package com.earl.fishshop.domain.postage;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;

public interface PostageDao extends BaseDao<PostagePo>{

	List<PostagePo> getHaveSetRegion(Long valueOf);


}
