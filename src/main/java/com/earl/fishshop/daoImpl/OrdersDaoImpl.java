package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.OrdersDao;
import com.earl.fishshop.pojo.OrdersPo;


/**
 * 
 * 
 */
@Repository("ordersDao")
public class OrdersDaoImpl extends BaseDaoImpl<OrdersPo> implements OrdersDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}