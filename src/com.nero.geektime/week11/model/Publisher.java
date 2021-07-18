package com.nero.geektime.week11.model;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class Publisher {
	private final JedisPool jedisPool;

	public Publisher(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	public void start() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Jedis jedis = jedisPool.getResource();
		while (true) {
			String line = null;
			try {
				line = reader.readLine();
				if (!"quit".equals(line)) {
					jedis.publish("mychannel", line);
				} else {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}