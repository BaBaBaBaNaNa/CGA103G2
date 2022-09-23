package com.queuer.model;

import redis.clients.jedis.Jedis;

public class QueuerRedisService {

	public String showOverList() {
		Jedis jedis = getJedisConnection();
		int overIndex = 0, max = 0, min = 0;
		String overList = "";
		
		try {
			overIndex = Integer.parseInt(jedis.get("overIndex"));
			
			if (overIndex >= 4) {
				max = overIndex;
				min = overIndex - 4;
			} else {
				max = overIndex;
				min = 0;
			}
			for (int i = 0; i < jedis.lrange("overList", min, max).size(); i++) {
				if (jedis.lrange("overList", min, max).size() - 1 == i) {
					overList += jedis.lrange("overList", min, max).get(i);
				} else {
					overList += jedis.lrange("overList", min, max).get(i) + ",";
				}
			}
		} catch (Exception e) {
			overList = "0";
		}
		return overList;
	}

	public String showSeatedList() {
		Jedis jedis = getJedisConnection();
		int seatedIndex = 0, max = 0, min = 0;
		String seatedList = "";
		
		try {
			seatedIndex = Integer.parseInt(jedis.get("seatedIndex"));
			
			if (seatedIndex >= 4) {
				max = seatedIndex;
				min = seatedIndex - 4;
			} else {
				max = seatedIndex;
				min = 0;
			}
			for (int i = 0; i < jedis.lrange("seatedList", min, max).size(); i++) {
				if (jedis.lrange("seatedList", min, max).size() - 1 == i) {
					seatedList += jedis.lrange("seatedList", min, max).get(i);
				} else {
					seatedList += jedis.lrange("seatedList", min, max).get(i) + ",";
				}
			}
		} catch (Exception e) {
			seatedList = "0";
		}
		
		return seatedList;
	}

	public String showRemainNO() {
		String remainNO;
		Jedis jedis = getJedisConnection();

		if (jedis.exists("queuerList")) {
			if (!jedis.exists("currentNO")) {
				remainNO = Long.toString(jedis.llen("queuerList"));
			} else {
				remainNO = Long.toString(jedis.llen("queuerList") - Long.parseLong(jedis.get("currentNO")));

			}
		} else {
			remainNO = "0";

		}

		jedis.close();
		return remainNO;
	}

	public String showNextNO() {
		String nextNO;
		Jedis jedis = getJedisConnection();

		if (Long.parseLong(jedis.get("nextNO")) == Long.parseLong(jedis.get("currentNO"))) {
			nextNO = "0";
		} else {
			nextNO = jedis.get("nextNO");
		}
		jedis.close();
		return nextNO;
	}

	public String showCurrentNO() {
		String currentNO;
		Jedis jedis = getJedisConnection();

		if (!jedis.exists("currentNO")) {
			currentNO = "0";
		} else if (jedis.get("currentNO").equals(Long.toString(jedis.llen("queuerList")))) {
			currentNO = jedis.get("currentNO");
		} else {
			currentNO = jedis.get("currentNO");
		}

		jedis.close();
		return currentNO;
	}

	public String showTotalNO() {
		String totalNO;
		Jedis jedis = getJedisConnection();
		totalNO = Long.toString(jedis.llen("queuerList"));
		jedis.close();
		return totalNO;
	}

	public void doOverNO() {
		Jedis jedis = getJedisConnection();
		String overIndex = "";

		if (!jedis.exists("overIndex")) {

			jedis.set("overIndex", "0");
			jedis.rpush("overList", jedis.get("currentNO"));
		} else {

			overIndex = Integer.toString(Integer.parseInt(jedis.get("overIndex")) + 1);

			jedis.set("overIndex", overIndex);
			jedis.lpush("overList", jedis.get("currentNO"));
		}

		jedis.close();
	}

	public void doSeatedNO() {
		Jedis jedis = getJedisConnection();
		String seatedIndex = "";

		if (!jedis.exists("seatedIndex")) {

			jedis.set("seatedIndex", "0");
			jedis.rpush("seatedList", jedis.get("currentNO"));

		} else {
			seatedIndex = Integer.toString(Integer.parseInt(jedis.get("seatedIndex")) + 1);

			jedis.set("seatedIndex", seatedIndex);
			jedis.rpush("seatedList", jedis.get("currentNO"));

		}

		jedis.close();
	}

	public void doNextNO() {

		Jedis jedis = getJedisConnection();
		long index = 0;
		String currentNO = "";
		String nextNO = "";

		try {
			if (!jedis.exists("index") || jedis.get("index").equals("0")) {
				// 表示為第一個
				jedis.set("index", "0");
				currentNO = jedis.lrange("queuerList", index, index).get(0);
				nextNO = jedis.lrange("queuerList", index + 1, index + 1).get(0);
				jedis.set("index", currentNO);
				jedis.set("currentNO", currentNO);
				jedis.set("nextNO", nextNO);

			} else {
				index = Long.parseLong(jedis.get("index"));
				currentNO = jedis.lrange("queuerList", index, index).get(0);
				nextNO = jedis.lrange("queuerList", index + 1, index + 1).get(0);
				jedis.set("index", Long.toString(index + 1));
				jedis.set("currentNO", currentNO);
				jedis.set("nextNO", nextNO);
			}
		} catch (Exception e) {
			index = Long.parseLong(jedis.get("index"));
			currentNO = jedis.lrange("queuerList", index, index).get(0);
			nextNO = jedis.lrange("queuerList", index, index).get(0);
			jedis.set("index", Long.toString(index + 1));
			jedis.set("currentNO", currentNO);
			jedis.set("nextNO", nextNO);

		}

		jedis.close();

	}

	public String showQueuerNO() {
		String queuerNO = "";
		Jedis jedis = getJedisConnection();
		queuerNO = Long.toString(jedis.llen("queuerList"));

		return queuerNO;
	}

	public void queueInList() {

		// --前台按鈕"我要候位"的功能--

		// 取得redis連線
		Jedis jedis = getJedisConnection();

		// 宣告候位者號碼
		long queuerNOValue = 0;

		String queuerNO = "";

		// 如果jedis不存在"queuerList"
		if (!jedis.exists("queuerList")) {

			// 表示當下是第一個排隊者
			jedis.rpush("queuerList", "1");

			queuerNOValue = jedis.llen("queuerList");
			queuerNO = Long.toString(queuerNOValue);

		} else {

			// 存在則為後面候位號碼

			queuerNOValue = jedis.llen("queuerList") + 1;
			queuerNO = Long.toString(queuerNOValue);

			jedis.rpush("queuerList", queuerNO);

		}
		jedis.close();

	}

	public static Jedis getJedisConnection() {

		Jedis jedis = new Jedis("localhost", 6379);

		jedis.select(15);

		return jedis;
	}

	public void closeShop() {
		Jedis jedis = getJedisConnection();

		jedis.select(15);

		jedis.flushDB();

		jedis.close();
	}

}
