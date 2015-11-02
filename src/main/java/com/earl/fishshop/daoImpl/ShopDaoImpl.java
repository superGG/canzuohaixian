package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.ShopDao;
import com.earl.fishshop.pojo.ShopPo;


/**
 * 
 * 
 */
@Repository("shopDao")
public class ShopDaoImpl extends BaseDaoImpl<ShopPo> implements ShopDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}