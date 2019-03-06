package com.epoint.px.redis;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class RedisSetTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.del("set");

		// 添加元素
		jedis.sadd("set", "item1");
		jedis.sadd("set", "item2");
		jedis.sadd("set", "item3");
		jedis.sadd("set", "item4");

		// 获取所有元素
		Set<String> item = jedis.smembers("set");
		System.out.println("集合元素：" + item);

		// 检查给定元素是否存在于集合中
		System.out.println("元素item1是否存在：" + jedis.sismember("set", "item1"));
		System.out.println("元素item5是否存在：" + jedis.sismember("set", "item5"));

		// 移除元素
		jedis.srem("set", "item1");
		System.out.println("移除后集合元素：" + jedis.smembers("set"));
		jedis.close();
	}

}
