package com.queuer.model;

import redis.clients.jedis.Jedis;

public class QueuerRedisFuction {
	
	public static void main(String[] args) {
		
		int i = 2;
		
		switch (i) {
		case 0 : 
			queueInList();
			break;
			
		case 1 : 
			getNextNO();
			break;
			
		case 2 : 
			doSeatedList();
			break;
			
		case 3 : 
			doOverList();
			break;
			
			}
	}
	
	private static Jedis getJedisConnection() {
		// 取得redis 連線
		Jedis jedis = new Jedis("localhost", 6379);
				
		// 選擇db15
		jedis.select(15);
		return jedis;
	}
	
	public static void queueInList() {
		
		// --前台按鈕"我要候位"的功能--
		
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		
		// 宣告候位者號碼
		long queuerNOValue = 0;
		
		// 如果jedis不存在"queuerList"
		if(!jedis.exists("queuerList")) {
			
			
			// 表示當下是第一個排隊者
			jedis.rpush("queuerList", "1");
			
			queuerNOValue = jedis.llen("queuerList");
			
			// 回傳前台"您的號碼"
			System.out.println("您的候位號碼：" + queuerNOValue);
			
		}else {
			
			// 存在則為後面候位號碼
			
			queuerNOValue = jedis.llen("queuerList") + 1;
			String queuerNO = Long.toString(queuerNOValue);
			
			jedis.rpush("queuerList", queuerNO);
						
			// 回傳前台"您的號碼"
			System.out.println("您的候位號碼：" + queuerNOValue);
		}
		
		
		
		
		// console印出，表示任務完成！
		System.out.println("MISSION COMPLETE!");
		
		// 關閉連線
		jedis.close();
		
	}
	
	public static void getNextNO() {
		
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
			
			// 將此變數(型態未定)回傳至後台"當前號碼"
			System.out.println("後台\"當前號碼\"" + currentNO);
						
			// 將此變數(型態未定)回傳至前台"當前號碼"
			System.out.println("前台\"當前號碼\"" + currentNO);
			
			
			
			// console印出，表示任務完成！
			System.out.println("MISSION COMPLETE!");
			
		}else {
			
			//設定索引值
			index = Integer.valueOf(jedis.get("currentCount"));
			
			// 取出排隊line中當前號碼，並存入字串變數中。
			currentNO = jedis.lrange("queuerList", index, index).get(0);
			
			// 將此變數(型態未定)回傳至後台"當前號碼"
			System.out.println("後台\"當前號碼\"" +currentNO);
						
			// 將此變數(型態未定)回傳至前台"當前號碼"
			System.out.println("前台\"當前號碼\"" + currentNO);
			
			
			
			// console印出，表示任務完成！
			System.out.println("MISSION COMPLETE!");
			
		}
		
		jedis.close();
		
	}
	
	public static void doOverList() {
		
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
			
			// 測試過號功能
			System.out.println(currentNO + "已過號");
			
			// console印出，表示任務完成！
			System.out.println("MISSION COMPLETE!");
			
			// 索引值遞增並轉型
			String nextNO = Integer.toString(index + 1);
			
			// 計數+1存回currentCount內
			jedis.set("currentCount", nextNO);
		}
		
		// 關閉連線
		jedis.close();
	}
	
	public static void doSeatedList() {
		
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
			
			// 測試入座功能
			System.out.println(currentNO + "已入座");
			
			// console印出，表示任務完成！
			System.out.println("MISSION COMPLETE!");
			
			// 索引值遞增並轉型
			String nextNO = Integer.toString(index + 1);
			
			// 計數+1存回currentCount內
			jedis.set("currentCount", nextNO);
		}
		
		// 關閉連線
		jedis.close();
	}
	
	public static void closeShop() {
		// 取得redis連線
		Jedis jedis = getJedisConnection();
		
		jedis.flushDB();
		
		// 關閉連線
		jedis.close();		
	}
}
