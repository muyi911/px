package com.epoint.px.redis;

import redis.clients.jedis.Jedis;

public class RedisZSetTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.del("zset");

		// 添加
		jedis.zadd("zset", 100.0, "member1");
		jedis.zadd("zset", 200.0, "member2");
		jedis.zadd("zset", 10.0, "member3");

		// 获取
		System.out.println("获取序号为0，1，2的三个元素：" + jedis.zrange("zset", 0, 2));

		// 获取给定分值范围内的元素
		System.out.println("获取分值在50-300之间的元素：" + jedis.zrangeByScore("zset", 50, 300));

		// 删除第二个元素
		jedis.zrem("zset", "member2");
		System.out.println("获取分值在0-300之间的元素：" + jedis.zrangeByScore("zset", 0, 300));
		jedis.close();
	}

}
