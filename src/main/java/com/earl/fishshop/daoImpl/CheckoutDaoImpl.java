package com.earl.fishshop.daoImpl;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.CheckoutDao;
import com.earl.fishshop.pojo.CheckoutPo;
import com.earl.fishshop.util.MyConstant;


/**
 * 
 * 
 */
@Repository("checkoutDao")
public class CheckoutDaoImpl extends BaseDaoImpl<CheckoutPo> implements CheckoutDao {
	// property constants
	
	@Override
	public void passRecord(Long checkoutId) {
		
		CheckoutPo checkout = get(checkoutId);
		
		checkout.setState(MyConstant.checkout_pass);
		
		getCurrentSession().update(checkout);
		
		String hql = "update UserPo set state =:state where userId =:userId";
		
		getCurrentSession().createQuery(hql).setInteger("state", MyConstant.user_pass).setLong("userId", checkout.getUserId()).executeUpdate();
	}

	@Override
	public void nopassRecord(Long checkoutId) {
		
		CheckoutPo checkout = get(checkoutId);
		
		checkout.setState(MyConstant.checkout_nopass);
		
		getCurrentSession().update(checkout);
		
		String hql = "update UserPo set state =:state where userId =:userId";
		
		getCurrentSession().createQuery(hql).setInteger("state", MyConstant.user_nopass).setLong("userId", checkout.getUserId()).executeUpdate();
		
	}
	
}