package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.UnitDao;
import com.earl.fishshop.pojo.UnitPo;


/**
 * 
 * 
 */
@Repository("unitDao")
public class UnitDaoImpl extends BaseDaoImpl<UnitPo> implements UnitDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}