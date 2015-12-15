package com.earl.fishshop.domain.base;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.earl.fishshop.domain.category.CategoryDao;
import com.earl.fishshop.domain.comment.CommentDao;
import com.earl.fishshop.domain.farmers.FarmersDao;
import com.earl.fishshop.domain.fishman.FishmanDao;
import com.earl.fishshop.domain.getaddress.GetAddressDao;
import com.earl.fishshop.domain.gettype.GetTypeDao;
import com.earl.fishshop.domain.goods.GoodsDao;
import com.earl.fishshop.domain.orders.OrdersDao;
import com.earl.fishshop.domain.ordersdetail.OrdersDetailDao;
import com.earl.fishshop.domain.postage.PostageDao;
import com.earl.fishshop.domain.searecord.SeaRecordDao;
import com.earl.fishshop.domain.shipport.ShipPortDao;
import com.earl.fishshop.domain.shop.ShopDao;
import com.earl.fishshop.domain.sku.SkuDao;
import com.earl.fishshop.domain.unit.UnitDao;
import com.earl.fishshop.domain.user.UserDao;
import com.earl.fishshop.domain.verifycode.VerifyCodeDao;
import com.earl.fishshop.vo.PageInfo;
import com.earl.util.FileUploadImpl;

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
	
	protected BaseDao baseDao;
	
	@Resource
	protected GoodsDao goodsDao;
	@Resource
	protected CommentDao commentDao;
	@Resource
	protected CategoryDao categoryDao;
	@Resource
	protected OrdersDao ordersDao;
	@Resource
	protected OrdersDetailDao ordersDetailDao;
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
	protected UnitDao unitDao;
	@Resource
	protected UserDao userDao;
	@Resource
	protected GetTypeDao getTypeDao;
	@Resource
	protected GetAddressDao getAddressDao;
	@Resource
	protected PostageDao postageDao;
	@Resource
	protected ShipPortDao shipPortDao;
	@Resource
	protected VerifyCodeDao verifyCodeDao;
	@Resource(name = "fileUpload")
	protected FileUploadImpl fileUpload;
	
	public BaseServiceImpl() {

	}

	@Override
	public Boolean save(T model) {
//		Assert.assertNotNull("baseDao is null", baseDao);
		try {
			baseDao.save(model);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean update(T t) {
		try {
			baseDao.update(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			baseDao.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public T get(Long id) {
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
	public List<T> findAll(PageInfo pageInfo) {
		// TODO 未测试.
		return baseDao.findAll(pageInfo);
	}

	@Override
	public List<T> findByGivenCreteria(T object) {

		return baseDao.findByGivenCriteria(object);
	}

	@Override
	public Boolean updateWithNotNullProperties(T t) {
		try {
			baseDao.updateWithNotNullProperties(t);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<T> findByGivenCreteriaWithPage(T object, PageInfo pageInfo) {
//
//		return baseDao.findByGivenCreteriaWithPage(object, pageInfo);
//	}
}
