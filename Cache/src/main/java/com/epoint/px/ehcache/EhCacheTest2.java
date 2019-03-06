package com.epoint.px.ehcache;

/**
 * 简单封装
 * 
 * @author caozn
 *
 */
public class EhCacheTest2 {
	public static void main(String[] args) {
		EhcacheUtil ehCacheUtil = EhcacheUtil.getInstance();
		ehCacheUtil.put("CacheTest", "key1", "value1");
		String value = (String) ehCacheUtil.get("CacheTest", "key1");
		System.out.println("key1：" + value);
	}
}
