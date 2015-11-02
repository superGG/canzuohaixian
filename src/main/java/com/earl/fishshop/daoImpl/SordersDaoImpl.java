package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.SordersDao;
import com.earl.fishshop.pojo.SordersPo;


/**
 * 
 * 
 */
@Repository("sordersDao")
public class SordersDaoImpl extends BaseDaoImpl<SordersPo> implements SordersDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}