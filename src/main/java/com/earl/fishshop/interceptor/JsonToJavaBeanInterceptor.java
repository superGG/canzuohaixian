/**
 * Copyright (c) 2014 Wteamfly.  All rights reserved. 网飞公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.earl.fishshop.interceptor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.earl.fishshop.helper.JsonHelper;
import com.earl.fishshop.helper.ValidateHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * json封装到javabean拦截器拦截器.
 * 
 * @author 侯骏雄
 * @since 3.0.0
 */
public class JsonToJavaBeanInterceptor extends AbstractInterceptor {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager
            .getLogger(JsonToJavaBeanInterceptor.class);

    /**
     * 拦截action进行json封装处理.
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
        logger.debug("进入json封装到javabean拦截器");
        // 获取参数
        ActionContext ctx = invocation.getInvocationContext();
        @SuppressWarnings("rawtypes")
        Map parm = ctx.getParameters();
        Class<? extends Object> actionClass = invocation.getAction().getClass();

        List<String> actionClassFieldNameList = new ArrayList<String>();
        for (Field tempField : actionClass.getDeclaredFields()) {
            actionClassFieldNameList.add(tempField.getName());
        }

        Field declaredField = null;
        Object[] tempJson = null;
        boolean validataResult = true;
        for (Object key : parm.keySet()) {
            boolean isExit = actionClassFieldNameList.contains(key.toString());
            if (isExit) {
                declaredField = actionClass.getDeclaredField(key.toString());
                Class<?> fieldClass = declaredField.getType();
                	//TODO 添加对list对象的支持
                    tempJson = (Object[]) parm.get(key);
                    if (tempJson[0] != null) {
                    	Object jsonBean = JsonHelper.jsonToBean(tempJson[0].toString(), fieldClass);
                        validataResult = ValidateHelper.vaildateBean(jsonBean);
                        if (validataResult) {
                        	declaredField.setAccessible(true);
                        	declaredField.set(invocation.getAction(), jsonBean);
                            parm.put(key, jsonBean);
                        } else {
                            logger.error("非法的黑客访问");
                            break;
                        }
                }
            }
        }
        if (validataResult) {
            invocation.invoke();
        }
        logger.debug("退出json封装到javabean拦截器");
        return null;
    }
}