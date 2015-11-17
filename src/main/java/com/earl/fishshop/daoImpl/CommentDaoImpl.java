package com.earl.fishshop.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.earl.fishshop.dao.CommentDao;
import com.earl.fishshop.pojo.CommentPo;


/**
 * 
 * 
 */
@Repository("commentDao")
public class CommentDaoImpl extends BaseDaoImpl<CommentPo> implements CommentDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentPo> getShopComment(Long shopId) {
		String hql = "from CommentPo c where shopId = : shopId";
		List<CommentPo> list = getCurrentSession().createQuery(hql)
					.setLong("shopId", shopId).list();
		return list;
	}
	
	
}