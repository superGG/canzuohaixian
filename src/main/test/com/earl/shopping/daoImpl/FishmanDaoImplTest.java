package com.earl.shopping.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.dao.FishmanDao;
import com.earl.fishshop.pojo.FishmanPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class FishmanDaoImplTest {

	@Resource
	FishmanDao fishmanDao;

	@Resource(name = "sessionFactory")
	SessionFactoryImpl sessionFactory;

	@Resource(name = "transactionManager")
	HibernateTransactionManager transactionManager;

	@Test
	public void testSave() {
		FishmanPo fishman = new FishmanPo();
//		fishman.set
		fishmanDao.save(fishman);
	}

	@Test
	public void testGet() {
		FishmanPo unitPo = fishmanDao.get(1L);
		System.out.println(unitPo);
	}

	@Test
	public void testFindAll() {
		List<FishmanPo> findAll = fishmanDao.findAll();
		System.out.println(findAll);
	}

	@Test
	public void testAuthenticationFishman(){
		FishmanPo fishman = new FishmanPo();
		fishman.setEnginePower(10000L);
		fishman.setGetType(1);
//		fishman.setIdentityPhoto("lkdjflka.png");
//		fishman.setLongitude(123.231);
//		fishman.setLatitude(2423.234);
		fishman.setSeaPassPhoto("sdklfjsl.png");
		fishman.setShipPhoto("sldkjf.png");
		fishman.setShopId(1L);
		fishman.setTonnage(235L);
		
		fishmanDao.authenticationFishman(1L, fishman);
	}
}
