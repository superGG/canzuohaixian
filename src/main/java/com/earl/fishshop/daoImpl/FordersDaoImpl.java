package com.earl.fishshop.daoImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.FordersDao;
import com.earl.fishshop.pojo.FordersPo;


/**
 * 
 * 
 */
@Repository("fordersDao")
public class FordersDaoImpl extends BaseDaoImpl<FordersPo> implements FordersDao {

	@Override
	public Long addForders(FordersPo forder) {
		// TODO 未测试.
		Serializable save = getCurrentSession().save(forder);
		return (Long)save;
	}
	// property constants
	
}