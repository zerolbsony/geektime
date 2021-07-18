package com.nero.geektime.week11.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.nero.geektime.week11.config.RedisPool;
import com.nero.geektime.week11.entity.Response;
import com.nero.geektime.week11.model.Publisher;
import com.nero.geektime.week11.utils.SubThread;
import com.nero.geektime.week8.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.JedisPool;

@Controller
public class OrderController {

	@RequestMapping("/order/create")
	public String createOrder(@RequestParam Order order) {
		Response response = new Response();
		response.setErrorCode(200);
		response.setErrorMsg("ok");
		if (null == order) {
			response.setErrorCode(10000);
			response.setErrorMsg("入参为空");
			return JSONUtils.toJSONString(response);
		}
		String lockKey = order.getOrderNo().toString();
		//分布式锁保证只会有一个处理成功
		if (null == RedisPool.getJedis().get(lockKey)) {
			RedisPool.getJedis().set(lockKey, JSONUtils.toJSONString(order), "nx", "ex", 5000);
			//减库存
			String productKey = "product:" + order.getProductId().toString() + ":num";
			RedisPool.getJedis().decr(productKey);

		}
		return JSONUtils.toJSONString(response);
	}

	public void pubSub() {
		JedisPool jedisPool = RedisPool.getJedisPool();
		SubThread subThread = new SubThread(jedisPool);
		subThread.start();

		Publisher publisher = new Publisher(jedisPool);
		publisher.start();
	}
}
