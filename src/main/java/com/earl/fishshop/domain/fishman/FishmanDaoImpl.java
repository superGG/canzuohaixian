package com.earl.fishshop.domain.fishman;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;
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
		Long identityId = (Long) getCurrentSession().save(model);
		String hql = "update UserPo set userType =:userType,state=:state, identityId=:identityId where userId =:userId";
		getCurrentSession().createQuery(hql)
				.setLong("identityId", identityId)
				.setInteger("userType", MyConstant.user_fishman)
				.setInteger("state", MyConstant.user_wait)
				.setLong("userId", userId).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FishmanPo> getFishman(Long fishmanId) {
		String hql = "from FishmanPo f where f.fishmanId = :fishmanId";
		List<FishmanPo> list = getCurrentSession().createQuery(hql)
				.setLong("fishmanId", fishmanId).list();
		return list;
	}

	@Override
	public void passAuthenticationFishman(Long userId) {
		String hql = "update UserPo set state=:state where userId =:userId";
		getCurrentSession().createQuery(hql)
				.setInteger("state", MyConstant.user_pass)
				.setLong("userId", userId).executeUpdate();
	}

	@Override
	public void noPassAuthenticationFishman(Long userId) {
		String hql = "update UserPo set state=:state where userId =:userId";
		getCurrentSession().createQuery(hql)
//				.setLong("identityId", 0l)
//				.setInteger("userType", MyConstant.user_normal)
				.setInteger("state", MyConstant.user_nopass)
				.setLong("userId", userId).executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FishmanPo> getFishmanByShop(Long shopId) {
		String hql = "from FishmanPo f where f.shopId = :shopId";
		List<FishmanPo> list = getCurrentSession().createQuery(hql)
				.setLong("shopId", shopId).list();
		return list;
	}
	
	
	
	
}