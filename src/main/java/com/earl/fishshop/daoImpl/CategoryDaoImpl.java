package com.earl.fishshop.daoImpl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.CategoryDao;
import com.earl.fishshop.pojo.CategoryPo;


/**
 * 
 * 
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDaoImpl<CategoryPo> implements CategoryDao {
	// property constants
	
	//事例方法
	public List savesf(){
		List list = getCurrentSession().createQuery("from user where userid = 1").list();
		return list;
	}

	@Override
	public List<CategoryPo> getCategoryHire() {
		// TODO 未测试.
		String hql = "from CategoryPo c left join fetch c.childCategory on c.categotyId = null";
		List<CategoryPo> list = getCurrentSession().createQuery(hql).list();
		return list;
	}
}