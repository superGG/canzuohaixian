package com.earl.shopping.serverImpl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.earl.fishshop.pojo.GoodsPo;
import com.earl.fishshop.service.GoodsService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-*.xml")
public class GoodsServiceImplTest {
	
	@Resource
	GoodsService goodsService ;

	@Test
	public void testGoodsServiceImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveGoods() {
		GoodsPo goods = new GoodsPo();
		goodsService.save(goods);
	}

	@Test
	public void testQueryByWord() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById(){
		
		goodsService.deleteById(1L);
		
	}
	
}
