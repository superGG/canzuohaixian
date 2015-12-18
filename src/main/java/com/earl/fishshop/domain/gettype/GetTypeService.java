package com.earl.fishshop.domain.gettype;

import java.util.List;

import com.earl.fishshop.domain.base.BaseService;

public interface GetTypeService extends BaseService<GetTypePo>{

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

	/**
	 * 获取捕捞方式.
	 *@author 宋文光.
	 * @param getType
	 * @return 
	 */
	String getGetTypeName(String getType);

	/**
	 * 获取养殖方式.
	 *@author 宋文光.
	 * @param model
	 * @return
	 */
	List<GetTypePo> getFarmerGetType(GetTypePo model);
	
	
	
}
