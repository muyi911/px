package com.epoint.px.redis;

import redis.clients.jedis.Jedis;

public class RedisStringTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.del("string");

		// String类型
		// 添加
		jedis.set("string", "hello world");

		// 获取
		String str = jedis.get("string");
		System.out.println("string的值为：" + str);

		// 删除
		jedis.del("string");
		str = jedis.get("string");
		System.out.println("string的值为：" + str);
		jedis.close();
	}

}
