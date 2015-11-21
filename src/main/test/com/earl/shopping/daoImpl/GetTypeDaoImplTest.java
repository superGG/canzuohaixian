package com.earl.shopping.daoImpl;


import javax.annotation.Resource;

import org.hibernate.internal.SessionFactoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.domain.gettype.GetTypeDao;
import com.earl.fishshop.domain.gettype.GetTypePo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class GetTypeDaoImplTest {

	@Resource
	GetTypeDao getTypeDao;
	
	@Resource(name="sessionFactory")
	SessionFactoryImpl sessionFactory;
	
	@Resource(name="transactionManager")
	HibernateTransactionManager transactionManager;
	
	@Test
	public void testUpdate(){
		GetTypePo getTypePo = getTypeDao.get(1L);
		getTypePo.setGetName("dodo1");
		getTypeDao.update(getTypePo);
	}
}
