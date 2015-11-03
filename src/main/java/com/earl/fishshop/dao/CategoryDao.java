package com.earl.fishshop.dao;

import java.util.List;

import com.earl.fishshop.pojo.CategoryPo;

public interface CategoryDao extends BaseDao<CategoryPo>{

	List<CategoryPo> getCategoryHire();

}
