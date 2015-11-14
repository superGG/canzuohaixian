package com.earl.fishshop.daoImpl;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanMap;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.earl.fishshop.base.BaseDao;
import com.earl.fishshop.vo.PageInfo;


/**
 * 这里用到工具类 HibernateHelper
 * 
 * @author 黄祥谦
 * @time 2015/7/16
 */
@Repository("baseDao")
@Lazy(value=true)
public class BaseDaoImpl<T> implements BaseDao<T> {

	@SuppressWarnings("rawtypes")
	Class clazz; // 用来存储BaseDaoImpl泛型T的实际类型

	static Logger logger = null; // 这个日志工具暂时没有必要,驻澳用于记录日志，在构造方法中进行实例化

	@Resource(name="sessionFactory")
	SessionFactory sessionFactory;
	
	@SuppressWarnings("rawtypes")
	public BaseDaoImpl() {
		logger = Logger.getLogger(this.getClass());
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		Type genType = parameterizedType.getActualTypeArguments()[0];
		System.out.println(genType + "-----baseDaoImpl");
		this.clazz = (Class) genType;
		logger.debug("construct " + clazz.getName() + " instance");
	}

	public Session getCurrentSession() {
		logger.debug("进入getCurrentSession函数");
		return sessionFactory.getCurrentSession();
	}

	// 插入对象
	@Override
	/**
	 * @author Administrator
	 * 
	 * @Param  T   object
	 * @Result void
	 */
	public void save(T t) {
		System.out.println("dodo1");
		logger.debug("saving " + clazz.getName() + " instance");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		System.out.println(transaction.getLocalStatus());
		System.out.println(transaction.getTimeout());
		System.out.println(transaction);
		session.save(t);
	}

	// 更新对象
	@Override
	public boolean update(T t) {
		logger.debug("update " + clazz.getName() + " instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Transaction transaction = session.getTransaction();
			System.out.println(transaction.getLocalStatus());
			System.out.println(transaction.getTimeout());
			getCurrentSession().update(t);
			return true;
		} catch (Exception e) {
			logger.debug(e);
			return false;
		}
	}

	// 根据ID删除对象
	@Override
	public void deleteById(Long id) {
		logger.debug("delete " + clazz.getName() + " instance");
		delete(get(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Long id) {
		logger.debug("get " + clazz.getName() + " instance");
		T object = (T) getCurrentSession().get(clazz, id);
		return object;
	}

	// 查找该表中的所有记录，
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String hql = "from " + clazz.getSimpleName();
		List<T> list = getCurrentSession().createQuery(hql).list();
		return list;
	}

	// 查找该表中的所有记录，并且分页显示，需要信息，当前页数，
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<T> pageFindAll(PageInfo pageInfo) {
//		logger.debug("findAll " + clazz.getName() + " instance");
//		Transaction tran = getCurrentSession().beginTransaction();
//		String hql = "from " + clazz.getSimpleName();
//		List<T> list = getCurrentSession()
//				.createQuery(hql)
//				.setFirstResult(
//						(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
//				.setMaxResults(pageInfo.getSize()).list();
//		tran.commit();
//		return list;
//	}

	// 删除所有对象
	@Override
	public void deleteAll() {
		logger.debug("delete " + clazz.getName() + " instance");
		String hql = "delete from " + clazz.getName();
		getCurrentSession().createQuery(hql).executeUpdate();
	}

	/**
	 * 通过对象来进行删除,软删除对象 
	 */ 
	@Override
	public void delete(T persistentInstance) {
		logger.debug("delete " + clazz.getName() + " instance");
			try {
				@SuppressWarnings("unchecked")
				Method method = clazz.getMethod("setIsDelete",Boolean.class);
				method.invoke(persistentInstance, true);
				getCurrentSession().update(persistentInstance);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	// 通过给定条件进行查询
	@Override
	public List<T> findByGivenCriteria(T object) {
		// 业务逻辑开始
		Map<String, Object> notNullParam = null;
		notNullParam = getNotNullProperties(object);
		Criteria criteria = getCurrentSession().createCriteria(clazz);
		for (String key : notNullParam.keySet()) {
			criteria.add(Restrictions.eq(key, notNullParam.get(key)));
		}

		@SuppressWarnings("unchecked")
		List<T> listObject = criteria.list();

		// 业务逻辑结束
		logger.debug("退出findByGivenCreteria方法");
		return listObject;
	}

	/**
	 * 通过给定条件查询,并且分页.
	 */
	public List<T> findByGivenCreteriaWithPage(T object, PageInfo pageInfo) {
//		// 业务逻辑开始

		Map<String, Object> notNullParam = null;
		notNullParam = getNotNullProperties(object);

		Criteria criteria = getCurrentSession().createCriteria(clazz);
		for (String key : notNullParam.keySet()) {
			criteria.add(Restrictions.eq(key, notNullParam.get(key)));
		}
		// 分页
		criteria.setFirstResult(
				(pageInfo.getIndexPageNum() - 1) * pageInfo.getSize())
				.setMaxResults(pageInfo.getSize()).list();

		@SuppressWarnings("unchecked")
		List<T> listObject = criteria.list();

		return listObject;
	}

	private Map<String, Object> getNotNullProperties(T object) {
		Map<String, Object> notNullParam = null;
		BeanMap beanMap = new BeanMap(object);
		notNullParam = new HashMap<String, Object>();
		Iterator<Object> keyIterator = beanMap.keySet().iterator();
		String propertyName = null;
		while (keyIterator.hasNext()) {
			propertyName = (String) keyIterator.next();
			if (!propertyName.equals("class")
					&& beanMap.get(propertyName) != null
					&& beanMap.get(propertyName) != ""
					) {
				notNullParam.put(propertyName, beanMap.get(propertyName));
			}
		}
		return notNullParam;
	}
}