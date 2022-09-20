package com.queuer.model;

import redis.clients.jedis.Jedis;

public class QueuerRedisService {
	
	private static Jedis getJedisConnection() {
		// 取得redis 連線
		Jedis jedis = new Jedis("localhost", 6379);
				
		// 選擇db15
		jedis.select(15);
		return jedis;
	}
	
	
	public String getTotalNO() {
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		// 宣告變數
		String totalNO = "";
		long totalNOValue = 0;
		
		totalNOValue = jedis.llen("queuerList");
		totalNO =  Long.toString(totalNOValue);
		
		return totalNO;
	}
	
	public String getRemainNO() {
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		// 宣告變數
		String remainNO = "";
		long remainNOValue = 0;
		if(jedis.exists("currentCount")){
			
			remainNOValue = (jedis.llen("queuerList") - Integer.parseInt(jedis.get("currentCount") ));
			remainNO = Long.toString(remainNOValue);
		}else{
			remainNOValue = jedis.llen("queuerList");
			remainNO = Long.toString(remainNOValue);
		}
		
		return remainNO;
		
	}
	
	public String getQueuerNO() {
		
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		// 宣告變數
		String queuerNO = "";
		long queuerNOValue = 0;
		
		queuerNOValue = jedis.llen("queuerList");
		queuerNO = Long.toString(queuerNOValue);
		
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
			
		}else {
			
			// 存在則為後面候位號碼
			
			queuerNOValue = jedis.llen("queuerList") + 1;
			queuerNO = Long.toString(queuerNOValue);
			
			jedis.rpush("queuerList", queuerNO);
						
		}
		
		// 關閉連線
		jedis.close();
		
	}
	
	public String getCurrentNO() {
		
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		
		// 宣告空字串存放元素
		String currentNO = "";
		
		// 宣告整數索引值
		int index = 0;
		
		// 如果這個記數不存在，表示取第一個候位號碼
		if(!jedis.exists("currentCount")) {
			
			// 設定計數為0(索引值)
			jedis.set("currentCount","0");
			
			//設定索引值
			index = Integer.valueOf(jedis.get("currentCount"));
			
			// 取出排隊list中當前號碼，並存入字串變數中。
			currentNO = jedis.lrange("queuerList", index, index).get(0);
			
		}else {
			
			//設定索引值
			index = Integer.valueOf(jedis.get("currentCount"));
			
			// 取出排隊line中當前號碼，並存入字串變數中。
			currentNO = jedis.lrange("queuerList", index, index).get(0);
			
		}
		
		jedis.close();
		return currentNO;
	}

	public String getNextNO() {
		// 取得redis連線
		Jedis jedis = getJedisConnection();
				
		// 宣告空字串存放元素
		String nextNO = "";
				
		// 宣告整數索引值
		int index = 0;			
		

		//設定索引值
		index = Integer.valueOf(jedis.get("currentCount")) + 1;
					
		// 取出排隊list中當前號碼，並存入字串變數中。
		nextNO = jedis.lrange("queuerList", index, index).get(0);
		
		return nextNO;
	}
	
	public void doOverList() {
		
		// --後台按鈕"過號"的功能--
		
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		
		// 宣告變數存入當前號碼
		String currentNO = "";
		
		// 宣告索引值
		int index = 0;
		// 後台若點擊"過號"
		
		// 如果count計數存在(表示已開始取得下一號)
		if(jedis.exists("currentCount")) {
			
			// 取出當前號碼
			index = Integer.valueOf(jedis.get("currentCount"));
			currentNO = jedis.lrange("queuerList", index, index).get(0);
			
			// 存入過號隊伍
			jedis.rpush("overList", currentNO);

			// 索引值遞增並轉型
			String nextNO = Integer.toString(index + 1);
			
			// 計數+1存回currentCount內
			jedis.set("currentCount", nextNO);
		}
		
		// 關閉連線
		jedis.close();
	}
	
	public void doSeatedList() {
		
		// --後台按鈕"過號"的功能--
		
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		
		// 宣告變數存入當前號碼
		String currentNO = "";
		
		// 宣告索引值
		int index = 0;
		// 後台若點擊"過號"
		
		// 如果count計數存在(表示已開始取得下一號)
		if(jedis.exists("currentCount")) {
			
			// 取出當前號碼
			index = Integer.valueOf(jedis.get("currentCount"));
			currentNO = jedis.lrange("queuerList", index, index).get(0);
			
			// 當前號碼存入入座list
			jedis.rpush("seatedList", currentNO);
			
			// 索引值遞增並轉型
			String nextNO = Integer.toString(index + 1);
			
			// 計數+1存回currentCount內
			jedis.set("currentCount", nextNO);
		}
		
		// 關閉連線
		jedis.close();
	}
	
	public  void closeShop() {
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		
		jedis.flushDB();
		
		// 關閉連線
		jedis.close();		
	}
}
