package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.GoodsDao;
import com.earl.fishshop.pojo.GoodsPo;


/**
 * 
 * 
 */
@Repository("goodsDao")
public class GoodsDaoImpl extends BaseDaoImpl<GoodsPo> implements GoodsDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}