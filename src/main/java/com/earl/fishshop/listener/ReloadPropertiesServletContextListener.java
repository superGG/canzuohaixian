package com.earl.fishshop.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.earl.util.PropertiesWatch;

/*
 * 此监听用来获取当前项目的运行环境参数,并且把参数写入到Properties配置文件中,后期项目可以使用
 * 例如文件上传的真实, 例如后面的索引库路径
 * */
public class ReloadPropertiesServletContextListener implements
		ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {

		new PropertiesWatch(this.getClass()
				.getResource("/applicationContext-bean.xml").getPath(),
				event.getServletContext()).start();
	}
}
