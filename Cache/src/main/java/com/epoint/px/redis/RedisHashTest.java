package com.epoint.px.redis;

import redis.clients.jedis.Jedis;

public class RedisHashTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.del("hash");

		// 添加元素
		jedis.hset("hash", "key1", "value1");

		// 获取元素
		String value = jedis.hget("hash", "key1");
		System.out.println("key1：" + value);

		// 获取所有键值对
		System.out.println("所有键值对" + jedis.hgetAll("hash"));

		// 移除某个键
		jedis.hdel("hash", "key1");
		System.out.println("所有键值对" + jedis.hgetAll("hash"));
		jedis.close();
	}

}
