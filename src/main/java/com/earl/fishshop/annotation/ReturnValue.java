package com.earl.fishshop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 添加该注解的对象将会被转化成json对象返回前台.
 * @author 黄祥谦.
 * @date:2015-10-30 上午8:11:22
 * @version :
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReturnValue {

}
