package com.earl.fishshop.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.GetAddressDao;
import com.earl.fishshop.pojo.GetAddressPo;


/**
 * 
 * 
 */
@Repository("getAddressDao")
public class GetAddressDaoImpl extends BaseDaoImpl<GetAddressPo> implements GetAddressDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}

	@Override
	public List<GetAddressPo> getUserAllAddress(Long userId) {
		// TODO 未测试.
		String hql = " from GetAddressPo where userId =:userId";
		@SuppressWarnings("unchecked")
		List<GetAddressPo> getAddressList = getCurrentSession().createQuery(hql).setLong("userId", userId).list();
		return getAddressList;
	}
}