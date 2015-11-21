package com.earl.fishshop.domain.sku;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.base.BaseDaoImpl;
import com.earl.fishshop.pojo.SkuPo;


/**
 * 
 * 
 */
@Repository("skuDao")
public class SkuDaoImpl extends BaseDaoImpl<SkuPo> implements SkuDao {
	// property constants
	
	@Override
	public List<SkuPo> getSkuFromUnit(Long unitId) {
		String hql = "from SkuPo where unitId = :unitId";
		@SuppressWarnings("unchecked")
		List<SkuPo> skuList = getCurrentSession().createQuery(hql).setLong("unitId", unitId).list();
		return skuList;
	}
}