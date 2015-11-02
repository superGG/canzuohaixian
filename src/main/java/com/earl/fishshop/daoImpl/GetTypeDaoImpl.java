package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.GetTypeDao;
import com.earl.fishshop.pojo.GetTypePo;


/**
 * 
 * 
 */
@Repository("getTypeDao")
public class GetTypeDaoImpl extends BaseDaoImpl<GetTypePo> implements GetTypeDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}