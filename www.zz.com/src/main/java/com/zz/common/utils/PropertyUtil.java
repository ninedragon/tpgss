package com.zz.common.utils;

import java.util.ResourceBundle;


/**
 * 读取配置文件
 * 
 * @author xul
 * 
 */
public class PropertyUtil {

	// common请求的配置文件
	public static String COMMON = "properties/common";

	/**
	 * 获取property文件中key对应的值
	 * 
	 * @param propertyName
	 *            property文件的名称
	 * @param key
	 *            property文件中key
	 * @return String
	 */
	public static String getValueByKey(String propertyName, String key) {

		ResourceBundle rb = ResourceBundle.getBundle(propertyName);
		String value = rb.getString(key);
		return value;
	}
	/**
	 * 获取websocket对应IP地址
	 * @param tagStr
	 * @return
	 */
	public static String getWebsocketIp(String tagStr) {
		return PropertyUtil.getValueByKey(PropertyUtil.COMMON, tagStr);
	}
}
