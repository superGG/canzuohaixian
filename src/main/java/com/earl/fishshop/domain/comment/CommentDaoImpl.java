package com.earl.fishshop.domain.comment;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.base.BaseDaoImpl;
import com.earl.fishshop.vo.PageInfo;


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

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentPo> getGoodComment(Long shopId) {
		String hql = "from CommentPo c where commentType = '1' and shopId = :shopId";
		List<CommentPo> list = getCurrentSession().createQuery(hql)
								.setLong("shopId", shopId).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentPo> getMidComment(Long shopId) {
		String hql = "from CommentPo c where commentType = '0' and shopId = :shopId";
		List<CommentPo> list = getCurrentSession().createQuery(hql)
								.setLong("shopId", shopId).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentPo> getBedComment(Long shopId) {
		String hql = "from CommentPo c where commentType = '-1' and shopId = :shopId";
		List<CommentPo> list = getCurrentSession().createQuery(hql)
								.setLong("shopId", shopId).list();
		return list;
	}

	@Override
	public List<CommentPo> getShopComment(Long shopId, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId)).add(Restrictions.gt("nowNumber", 0L));
		
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<CommentPo> commentList = createCriteria.list();
		
		Long size = (Long) createCriteria.setProjection(Projections.rowCount())
                .uniqueResult();
		pageInfo.setTotalCount(size);
		return commentList;
	}
	
	public List<CommentPo> getGoodComment(Long shopId, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId))
						.add(Restrictions.eq("commentType", 1))
						.add(Restrictions.gt("nowNumber", 0L));
		
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<CommentPo> commentList = createCriteria.list();
		
		Long size = (Long) createCriteria.setProjection(Projections.rowCount())
                .uniqueResult();
		pageInfo.setTotalCount(size);
		return commentList;
	}
	
	public List<CommentPo> getMidComment(Long shopId, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId))
						.add(Restrictions.eq("commentType", 0))
						.add(Restrictions.gt("nowNumber", 0L));
		
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<CommentPo> commentList = createCriteria.list();
		
		Long size = (Long) createCriteria.setProjection(Projections.rowCount())
                .uniqueResult();
		pageInfo.setTotalCount(size);
		return commentList;
	}
	
	public List<CommentPo> getBedComment(Long shopId, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("shopId", shopId))
						.add(Restrictions.eq("commentType", -1))
						.add(Restrictions.gt("nowNumber", 0L));
		
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<CommentPo> commentList = createCriteria.list();
		
		Long size = (Long) createCriteria.setProjection(Projections.rowCount())
                .uniqueResult();
		pageInfo.setTotalCount(size);
		return commentList;
	}

	@Override
	public List<CommentPo> getUserComment(Long creatorId, PageInfo pageInfo) {
		Criteria createCriteria = getCurrentSession().createCriteria(clazz);
		createCriteria.add(Restrictions.eq("creatorId", creatorId))
						.add(Restrictions.gt("nowNumber", 0L));
		
		createCriteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize());
		@SuppressWarnings("unchecked")
		List<CommentPo> commentList = createCriteria.list();
		
		Long size = (Long) createCriteria.setProjection(Projections.rowCount())
                .uniqueResult();
		pageInfo.setTotalCount(size);
		return commentList;
	}
	
}