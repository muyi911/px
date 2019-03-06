package com.epoint.px.redis;

import redis.clients.jedis.Jedis;

public class RedisListTest {

	public static void main(String[] args) {
		Jedis jedis = RedisUtil.getJedis();
		jedis.del("list");

		// 将值推入列表右端
		jedis.rpush("list", "element1");

		// 从列表的左端弹出一个值，并返回被弹出的值
		String elem = jedis.lpop("list");
		System.out.println("弹出左边第一个元素：" + elem);

		// 获取列表在给定范围上的所有值
		jedis.rpush("list", "element1");
		jedis.rpush("list", "element2");
		jedis.rpush("list", "element3");
		System.out.println("获取序号为0，1，2的三个元素：" + jedis.lrange("list", 0, 2));

		// 获取列表给定位置上的值
		System.out.println("获取第二个元素：" + jedis.lindex("list", 1));
		jedis.close();
	}
}
