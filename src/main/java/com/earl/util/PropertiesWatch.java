package com.earl.util;

import javax.servlet.ServletContext;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.earl.fishshop.util.FileWatchDog;

/**
 * @author 黄祥谦.
 * @date:2015-12-8 上午10:16:33
 * @version :
 */
public class PropertiesWatch extends FileWatchDog {

	/**
	 * log4j实例对象.
	 */
	private static Logger logger = LogManager.getLogger(PropertiesWatch.class
			.getName());

	ServletContext servletContext;

	protected PropertiesWatch(String filename) {
		super(filename);
	}

	public PropertiesWatch(String filename, ServletContext servletContext) {
		super(filename);
		this.servletContext = servletContext;
	}

	@Override
	protected void doOnChange() {
		// TODO 未测试.
		logger.debug("watching" + this.filename);
		XmlWebApplicationContext context2 = (XmlWebApplicationContext) WebApplicationContextUtils
				.getWebApplicationContext(this.servletContext);
		context2.refresh();
	}

}
