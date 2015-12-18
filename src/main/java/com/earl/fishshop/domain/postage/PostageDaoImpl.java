package com.earl.fishshop.domain.postage;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;


/**
 * 
 * 
 */
@Repository("postageDao")
public class PostageDaoImpl extends BaseDaoImpl<PostagePo> implements PostageDao {

	@Override
	public List<PostagePo> getHaveSetRegion(Long valueOf) {
		// TODO 未测试.
		String hql = "from PostagePo where origin = :addrescode";
		@SuppressWarnings("unchecked")
		List<PostagePo> list = getCurrentSession().createQuery(hql).setLong("origin", valueOf).list();
		return list;
	}

}