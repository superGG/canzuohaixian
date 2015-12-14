package com.earl.fishshop.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.earl.fishshop.helper.JsonHelper;
import com.earl.fishshop.vo.ResultMessage;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class ErrorInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * log4j实例对象.
     */
	private static Logger logger = LogManager
            .getLogger(ErrorInterceptor.class);
	
	public void init() {

	}

	public String intercept(ActionInvocation actioninvocation) {

		String result = null; // Action的返回值
		try {
			// 运行被拦截的Action,期间如果发生异常会被catch住
			result = actioninvocation.invoke();
			return result;
		} catch (Exception e) {
			/**
			 * 处理异常
			 */
			e.printStackTrace();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
				ResultMessage resultMessage = new ResultMessage();
				resultMessage.setServiceResult(false);
				resultMessage.setResultInfo("请求失败");
				String json = JsonHelper.toJson(resultMessage);
				out.println(json);
				logger.info("resultMessage =>" + json);
				out.flush();
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}
		// ...end of catch
	}

	public void destroy() {

	}
}
