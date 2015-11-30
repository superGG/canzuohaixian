package com.earl.fishshop.domain.getaddress;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;


/**
 * 
 * 
 */
@Repository("getAddressDao")
public class GetAddressDaoImpl extends BaseDaoImpl<GetAddressPo> implements GetAddressDao {
	// property constants
	
	@Override
	public List<GetAddressPo> getUserAllAddress(Long userId) {
		// TODO 未测试.
		String hql = " from GetAddressPo where userId =:userId";
		@SuppressWarnings("unchecked")
		List<GetAddressPo> getAddressList = getCurrentSession().createQuery(hql).setLong("userId", userId).list();
		return getAddressList;
	}

	@Override
	public void addGetAddress(GetAddressPo model) {
		// TODO 未测试.
		Long getAddressId = (Long) getCurrentSession().save(model);
		String hql = "update from UserPo set getAddressId=:getAddressId where userId =:userId ";
		getCurrentSession().createQuery(hql).setLong("getAddressId", getAddressId).setLong("userId", model.getUserId()).executeUpdate();
	}

	@Override
	public void updateUserAddress(Long getAddressId, Long userId) {
		// TODO 未测试.
		String hql = "update from UserPo set getAddressId=:getAddressId where userId =:userId ";
		getCurrentSession().createQuery(hql).setLong("getAddressId", getAddressId).setLong("userId", userId).executeUpdate();
	}

	@Override
	public GetAddressPo getFirst(Long userId) {
		// TODO 未测试.
		String hql = " from GetAddressPo where userId =:userId";
		GetAddressPo getAddress = (GetAddressPo) getCurrentSession().createQuery(hql).setLong("userId", userId).setFirstResult(0).setMaxResults(1).uniqueResult();
		return getAddress;
	}
}