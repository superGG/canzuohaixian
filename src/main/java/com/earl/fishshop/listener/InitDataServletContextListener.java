package com.earl.fishshop.listener;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
 * 此监听用来获取当前项目的运行环境参数,并且把参数写入到Properties配置文件中,后期项目可以使用
 * 例如文件上传的真实, 例如后面的索引库路径
 * */
public class InitDataServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent event) {
		String basePath=event.getServletContext().getRealPath("/");
		// 没有 / 与当前类同步目录
		InputStream in=null;
		OutputStream out=null;
		// 获取public.properties配置文件,写入公共信息
		Properties prop=new Properties();
		try {
			// 读取跟目录下面的配置文件信息
			in = new FileInputStream(this.getClass().getResource("/public.properties").getPath());
			// 获取当前配置文件的绝对路径
			prop.load(in);
			prop.setProperty("basePath",basePath);
			prop.setProperty("filePath","image");
			out=new FileOutputStream(this.getClass().getResource("/public.properties").getPath());
			prop.store(out, "我是注释!");
			System.out.println(new Date());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}finally{
				try {
					out.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
