/**
 * Copyright (c) 2014 Wteamfly.  All rights reserved. 网飞公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.earl.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



/**
 * 根据vo属性，过滤po属性.
 * @author 黄祥谦 
 * 过滤po属性，设置其值为null
 *
 */
public class FilterPropertiesUtil {
	
	
	static Logger logger = LogManager.getLogger(FilterPropertiesUtil.class);

	/**
	 * 耗时4毫秒.性能相对下面高出一个数量级.
	 * @author 黄祥谦.
	 * @param po
	 * @param vo
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T>  T filterProperties(T po,Class<?> vo) throws IllegalArgumentException, IllegalAccessException{
		long begintime = System.currentTimeMillis();
		logger.debug("进入filterProperties构造方法");
		ArrayList<String> arrayList = new ArrayList<String>();
		Field[] fields = vo.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
			arrayList.add(field.getName());
		}
		Field[] declaredFields = po.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			if(arrayList.contains(field.getName())){
			}else{
				field.setAccessible(true);
				field.set(po, null);
			}
		}
		long endtime = System.currentTimeMillis();
		long spend = endtime-begintime;
		logger.debug("退出filterProperties方法,毫秒数: "+spend+"毫秒;耗费时间：" + spend/1000 + "秒");
		return po;
	}
	
	public static Object filterProperties2(Object po,Class<?> vo) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		Object newInstance = vo.newInstance();
		long begintime = System.currentTimeMillis();
		logger.debug("进入filterProperties2构造方法");
		BeanUtils.copyProperties(newInstance,po);
		long endtime = System.currentTimeMillis();
		long spend = endtime-begintime;
		logger.debug("退出filterProperties2方法,毫秒数: "+spend+"毫秒;耗费时间：" + spend/1000 + "秒");
		return newInstance;
	}
	
}


