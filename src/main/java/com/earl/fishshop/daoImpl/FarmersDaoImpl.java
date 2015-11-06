package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.base.BaseDaoImpl;
import com.earl.fishshop.dao.FarmersDao;
import com.earl.fishshop.pojo.FarmersPo;


/**
 * 
 * 
 */
@Repository("farmersDao")
public class FarmersDaoImpl extends BaseDaoImpl<FarmersPo> implements FarmersDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}