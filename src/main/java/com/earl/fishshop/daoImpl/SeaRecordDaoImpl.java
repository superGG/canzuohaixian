package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.base.BaseDaoImpl;
import com.earl.fishshop.dao.SeaRecordDao;
import com.earl.fishshop.pojo.SeaRecordPo;


/**
 * 
 * 
 */
@Repository("seaRecordDao")
public class SeaRecordDaoImpl extends BaseDaoImpl<SeaRecordPo> implements SeaRecordDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}
}