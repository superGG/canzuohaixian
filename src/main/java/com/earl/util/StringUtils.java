package com.earl.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * 字符串工具类
 * 
 * @author liufl / 2014年3月18日
 */
public abstract class StringUtils {

	/**
	 * 字符串是空的
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str);
	}

	/**
	 * 字符串是空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return isEmpty(str) || "".equals(str.trim());
	}

	/**
	 * 字符串不是空白
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}

	public static InputStream toStream(String str, String charset) {

		InputStream stream = null;
		try {
			stream = new ByteArrayInputStream(str.getBytes(charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return stream;
	}
	

}
