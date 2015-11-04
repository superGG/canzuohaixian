package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.CheckoutDao;
import com.earl.fishshop.pojo.CheckoutPo;


/**
 * 
 * 
 */
@Repository("checkoutDao")
public class CheckoutDaoImpl extends BaseDaoImpl<CheckoutPo> implements CheckoutDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}