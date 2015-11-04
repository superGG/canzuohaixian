package com.earl.fishshop.daoImpl;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.FishmanDao;
import com.earl.fishshop.pojo.FishmanPo;
import com.earl.fishshop.util.MyConstant;

/**
 * 
 * 
 */
@Repository("fishmanDao")
public class FishmanDaoImpl extends BaseDaoImpl<FishmanPo> implements
		FishmanDao {

	@Override
	public void authenticationFishman(Long userId, FishmanPo model) {
		save(model);
		String hql = "update UserPo set userType =:userType,state=:state  where userId =:userId";
		getCurrentSession().createQuery(hql)
				.setInteger("userType", MyConstant.user_fishman)
				.setInteger("state", MyConstant.user_wait)
				.setLong("userId", userId).executeUpdate();
	}
}