package com.earl.fishshop.domain.gettype;

import java.util.List;

import com.earl.fishshop.domain.base.BaseDao;

public interface GetTypeDao extends BaseDao<GetTypePo>{

	/**
	 * 得到下一级的捕捞方式或者养殖方式.
	 * @author 黄祥谦.
	 * @param getTypeId 父类级别的捕捞方式.
	 * @return
	 */
	List<GetTypePo> getNextLevelGetType(Long parentId);

	/**
	 * 得到顶层的捕捞方式或者养殖方式.
	 * @author 黄祥谦.
	 * @return
	 */
	List<GetTypePo> getTopGetType();

	/**
	 * 得到带层级结构的捕捞方式，或者养殖方式.
	 * @author 黄祥谦.
	 * @return
	 */
	List<GetTypePo> getHierarchyGetType();

}
