package com.epoint.px.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

/**
 * 动态创建
 * 
 * @author caozn
 *
 */
public class EhCacheTest3 {
	private static final String CACHENAME = "DynamicCreateCache";

	public static void main(String[] args) {
		CacheManager cacheManager = CacheManager.newInstance();
		cacheManager.addCacheIfAbsent(CACHENAME);
		Cache cache = cacheManager.getCache(CACHENAME);

		CacheConfiguration config = cache.getCacheConfiguration();
		config.setTimeToIdleSeconds(60); // 设置对象在失效前的允许闲置时间（单位：秒）
		config.setTimeToLiveSeconds(120); // 设置对象在失效前允许存活时间（单位：秒）
		config.maxEntriesLocalHeap(10000); // 堆内存中最大缓存对象数,0没有限制(必须设置)
		config.maxEntriesLocalDisk(1000000); // 当内存中对象数量达到maxElementsInMemory时，Ehcache将会对象写到磁盘中

		System.out.println("CacheName：" + cache.getName());

		// 添加元素
		Element element = new Element("key1", "value1");
		cache.put(element);

		// 取出元素
		Element value = cache.get("key1");
		System.out.println("key1：" + value.getObjectValue());
		cacheManager.shutdown();
	}
}
