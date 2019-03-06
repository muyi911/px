package com.epoint.px.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 简单使用
 * 
 * @author caozn
 *
 */
public class EhCacheTest {
	public static void main(String[] args) {
		// 1. 创建缓存管理器
		CacheManager cacheManager = CacheManager.create("./src/main/resources/ehcache.xml");

		// 2. 获取缓存对象
		Cache cache = cacheManager.getCache("CacheTest");

		// 3. 创建元素
		Element element = new Element("key1", "value1");

		// 4. 将元素添加到缓存
		cache.put(element);

		// 5. 获取缓存
		Element value = cache.get("key1");
		System.out.println("第一次命中：" + value);
		System.out.println("key1：" + value.getObjectValue());

		value = cache.get("key1");
		System.out.println("第二次命中：" + value);

		// 6. 删除元素
		cache.remove("key1");
		value = cache.get("key1");
		System.out.println("删除key1：" + value);

		// 7. 刷新缓存
		cache.flush();

		// 8. 关闭缓存管理器
		cacheManager.shutdown();
	}
}
