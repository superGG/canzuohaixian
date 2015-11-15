package com.earl.fishshop.daoImpl;

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
		save(model);
		String hql = "update UserPo set userType =:userType,state=:state  where userId =:userId";
		getCurrentSession().createQuery(hql)
				.setInteger("userType", MyConstant.user_farmer)
				.setInteger("state", MyConstant.user_wait)
				.setLong("userId", userId).executeUpdate();
		
	}
	// property constants
	
}