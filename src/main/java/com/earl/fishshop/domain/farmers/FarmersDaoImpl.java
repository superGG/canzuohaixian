package com.earl.fishshop.domain.farmers;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;
import com.earl.fishshop.util.MyConstant;


/**
 * 
 * 
 */
@Repository("farmersDao")
public class FarmersDaoImpl extends BaseDaoImpl<FarmersPo> implements FarmersDao {

	@Override
	public void authenticationFarmers(Long userId, FarmersPo model) {
		Long identityId = (Long) getCurrentSession().save(model);
		String hql = "update UserPo set userType =:userType,state=:state, identityId=:identityId  where userId =:userId";
		getCurrentSession().createQuery(hql)
				.setLong("identityId", identityId)
				.setInteger("userType", MyConstant.user_farmer)
				.setInteger("state", MyConstant.user_wait)
				.setLong("userId", userId).executeUpdate();
		
	}
	// property constants

	@SuppressWarnings("unchecked")
	@Override
	public List<FarmersPo> getFarmers(Long identityId) {
		String hql = "from FarmersPo f where f.farmersId = :identityId";
		List<FarmersPo> list = getCurrentSession().createQuery(hql)
				.setLong("identityId", identityId).list();
		return list;
	}

	@Override
	public void passAuthenticationFarmers(Long userId) {
		String hql = "update UserPo set state=:state where userId =:userId";
		getCurrentSession().createQuery(hql)
				.setInteger("state", MyConstant.user_pass)
				.setLong("userId", userId).executeUpdate();
		
	}

	@Override
	public void noPassAuthenticationFarmers(Long userId) {
		String hql = "update UserPo set userType =:userType,state=:state, identityId=:identityId where userId =:userId";
		getCurrentSession().createQuery(hql)
				.setLong("identityId", 0l)
				.setInteger("userType", MyConstant.user_normal)
				.setInteger("state", MyConstant.user_nopass)
				.setLong("userId", userId).executeUpdate();
		
	}

	@Override
	public FarmersPo getFarmerByShop(Long shopId) {
		String hql = "from FarmersPo f where f.shopId =:shopId";
		FarmersPo farmers = (FarmersPo) getCurrentSession().createQuery(hql)
				.setLong("shopId", shopId).uniqueResult();
		return farmers;
	}
	
}