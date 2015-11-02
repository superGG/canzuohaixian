package com.earl.fishshop.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.earl.fishshop.dao.BaseDao;
import com.earl.fishshop.dao.CategoryDao;
import com.earl.fishshop.dao.CommentDao;
import com.earl.fishshop.dao.FarmersDao;
import com.earl.fishshop.dao.FishmanDao;
import com.earl.fishshop.dao.GoodsDao;
import com.earl.fishshop.dao.OrdersDao;
import com.earl.fishshop.dao.SeaRecordDao;
import com.earl.fishshop.dao.ShopDao;
import com.earl.fishshop.dao.SkuDao;
import com.earl.fishshop.dao.SordersDao;
import com.earl.fishshop.dao.UnitDao;
import com.earl.fishshop.dao.UserDao;
import com.earl.fishshop.service.BaseService;

/**
 * @author Administrator
 * 
 * @param <T>
 */
@Service("baseService")
@SuppressWarnings("unchecked")
@Lazy(value=true)
public class BaseServiceImpl<T> implements BaseService<T> {

	// 不同的T对应不同的Dao

	@SuppressWarnings("rawtypes")
	
	BaseDao baseDao;
	
	@Resource
	protected GoodsDao goodsDao;
	@Resource
	protected CommentDao commentDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource
	protected OrdersDao ordersDao;
	@Resource
	protected FarmersDao farmersDao;
	@Resource
	protected FishmanDao fishmanDao;
	@Resource
	protected SeaRecordDao seaRecordDao;
	@Resource
	protected ShopDao shopDao;
	@Resource
	protected SkuDao skuDao;
	@Resource
	protected SordersDao sordersDao;
	@Resource
	protected UnitDao unitDao;
	@Resource
	protected UserDao userDao;
	

	public BaseServiceImpl() {

	}

	@Override
	public void save(T model) {
//		Assert.assertNotNull("baseDao is null", baseDao);

		baseDao.save(model);
	}

	@Override
	public void update(T t) {
		baseDao.update(t);
	}

	@Override
	public void deleteById(Integer id) {
		baseDao.deleteById(id);
	}

	@Override
	public T get(Integer id) {
		return (T) baseDao.get(id);
	}

	@Override
	public List<T> findAll() {
		return baseDao.findAll();
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<T> pagefindAll(PageInfo pageInfo) {
//
//		return baseDao.pageFindAll(pageInfo);
//	}

	@Override
	public List<T> findByGivenCreteria(T object) {

		return baseDao.findByGivenCriteria(object);
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<T> findByGivenCreteriaWithPage(T object, PageInfo pageInfo) {
//
//		return baseDao.findByGivenCreteriaWithPage(object, pageInfo);
//	}
}
