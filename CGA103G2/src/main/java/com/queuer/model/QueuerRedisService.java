package com.queuer.model;

import redis.clients.jedis.Jedis;

public class QueuerRedisService {
	


		public String showRemainNO() {
			String remainNO;
			Jedis jedis = getJedisConnection();
			
			if(jedis.exists("queuerList")) {
				if(!jedis.exists("currentNO")) {
					remainNO = Long.toString(jedis.llen("queuerList"));
				}else {
					remainNO = Long.toString(jedis.llen("queuerList") - Long.parseLong(jedis.get("currentNO")));
					
				}
			}else{
				remainNO = "0";
				
			}
			
			jedis.close();
			return remainNO;
		}
		
		public String showNextNO() {
			String nextNO;
			Jedis jedis = getJedisConnection();
			
			if(Long.parseLong(jedis.get("nextNO")) == Long.parseLong(jedis.get("currentNO"))) {
				nextNO = "0";
			}else{
				nextNO = jedis.get("nextNO");
			}
			jedis.close();
			return nextNO;
		}
		
		public String showCurrentNO() {
			String currentNO;
			Jedis jedis = getJedisConnection();
			
			if(!jedis.exists("currentNO")) {
				currentNO = "0";
			}else if(jedis.get("currentNO").equals(Long.toString(jedis.llen("queuerList")))){
				currentNO = jedis.get("currentNO");
			}else {
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
			
			jedis.lpush("overList", jedis.get("currentNO"));
			
			jedis.close();
		}
		
		public void doSeatedNO() {
			Jedis jedis = getJedisConnection();
			
			jedis.rpush("seatedList", jedis.get("currentNO"));
			
			jedis.close();
		}
		
		public void doNextNO() {
			
			Jedis jedis = getJedisConnection();
			long index = 0;
			String currentNO = "";
			String nextNO = "";
			
			try {
				if(!jedis.exists("index") || jedis.get("index").equals("0")) {
					// 表示為第一個
					jedis.set("index", "0");
					currentNO = jedis.lrange("queuerList", index, index).get(0);
					nextNO = jedis.lrange("queuerList", index + 1, index + 1).get(0);
					jedis.set("index", currentNO);
					jedis.set("currentNO", currentNO);
					jedis.set("nextNO", nextNO);
				
				}else {
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
				nextNO = jedis.lrange("queuerList", index , index).get(0);
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
					if(!jedis.exists("queuerList")) {
						
						
						// 表示當下是第一個排隊者
						jedis.rpush("queuerList", "1");
						
						queuerNOValue = jedis.llen("queuerList");
						queuerNO = Long.toString(queuerNOValue);
						
					}else {
						
						// 存在則為後面候位號碼
						
						queuerNOValue = jedis.llen("queuerList") + 1;
						queuerNO = Long.toString(queuerNOValue);
						
						jedis.rpush("queuerList", queuerNO);
									
					}
			jedis.close();
			
		}
		
		public static Jedis getJedisConnection() {
			
			Jedis jedis =new Jedis("localhost", 6379);
			
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
