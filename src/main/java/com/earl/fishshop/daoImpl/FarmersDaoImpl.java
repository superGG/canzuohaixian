package com.earl.fishshop.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.FarmersDao;
import com.earl.fishshop.pojo.FarmersPo;
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
	
}