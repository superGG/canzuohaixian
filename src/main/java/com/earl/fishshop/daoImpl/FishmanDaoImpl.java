package com.earl.fishshop.daoImpl;

import java.util.List;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<FishmanPo> getFishman(Long identityId) {
		String hql = "from FishmanPo f where f.fishmanId = :identityId";
		List<FishmanPo> list = getCurrentSession().createQuery(hql)
				.setLong("identityId", identityId).list();
		return list;
	}
	
	
	
	
}