package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.SkuDao;
import com.earl.fishshop.pojo.SkuPo;


/**
 * 
 * 
 */
@Repository("skuDao")
public class SkuDaoImpl extends BaseDaoImpl<SkuPo> implements SkuDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}