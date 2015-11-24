package com.earl.fishshop.domain.verifycode;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.domain.base.BaseDaoImpl;


/**
 * 
 * 
 */
@Repository("verifyCodeDao")
public class VerifyCodeDaoImpl extends BaseDaoImpl<VerifyCodePo> implements VerifyCodeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<VerifyCodePo> getVerifyCode(String phoneNumber) {
		String hql = "from VerifyCodePo v where v.phoneNumber = :phoneNumber";
		List<VerifyCodePo> list = getCurrentSession().createQuery(hql)
				.setString("phoneNumber", phoneNumber).list();
		return list;
	}

}