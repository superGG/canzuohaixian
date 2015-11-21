package com.earl.fishshop.interceptor;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 转码拦截器.
 * 
 * @author 侯骏雄
 * @since 3.0.0
 */
public class EscapeInterceptor extends AbstractInterceptor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(EscapeInterceptor.class
            .getName());

    /**
     * 拦截action进行参数转码处理.
     * 
     * @param invocation
     *            action作用域
     * @throws Exception
     *             普通异常
     * @return 拦截结果
     */
    @SuppressWarnings("unchecked")
    @Override
    public final String intercept(final ActionInvocation invocation)
            throws Exception {
        logger.debug("进入转码拦截器");
        // 获取参数
        ActionContext ctx = invocation.getInvocationContext();
        
        // 获取HttpServletRequest   
        HttpServletRequest request = (HttpServletRequest)ctx.get(StrutsStatics.HTTP_REQUEST);
        String header = request.getHeader("Content-Type");
        Enumeration headerNames = request.getHeaderNames();
        if(header != null){
        	logger.info("header Content-Type " + header);
        }
        //不是form表单，并且没有指定utf-8
        if(header == null || (header != null && !((header.indexOf("utf-8") == -1 || header.indexOf("UTF-8") == -1 )&& header.indexOf("multipart/form-data") == -1))){
        	
        		}else{
        			@SuppressWarnings("rawtypes")
        			Map parm = ctx.getParameters();
        			Object[] tempObjArr = null;
        			Object[] turnObjArr = null;
        			for (Object key : parm.keySet()) {
        				tempObjArr = (Object[]) parm.get(key);
        				if (tempObjArr[0] != null && tempObjArr[0].getClass().isAssignableFrom(String.class)) {
        					turnObjArr = new Object[1];
        					logger.info("beforeEscape "+key + " : " + tempObjArr[0]);
        					turnObjArr[0] = new String(
        							((String) tempObjArr[0]).getBytes("iso-8859-1"),
        							"utf-8");
        					parm.put(key, turnObjArr);
        					logger.info("afterEscape "+key + " : " + turnObjArr[0]);
        		}
        	}
        }
        invocation.invoke();
        logger.debug("退出转码拦截器");
        return null;
    }
}
