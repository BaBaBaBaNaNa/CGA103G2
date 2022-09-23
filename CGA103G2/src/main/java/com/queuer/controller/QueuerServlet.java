package com.queuer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.queuer.model.QueuerRedisService;

import redis.clients.jedis.Jedis;

public class QueuerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		QueuerRedisService queuer = new QueuerRedisService();
		PrintWriter out = res.getWriter();
		Jedis jedis = new Jedis("localhost", 6379);
		JSONObject output = new JSONObject();

		// 前台我要候位按鈕
		if ("queueInList".equals(action)) {
			queuer.queueInList();
			try {
				output.put("queuerNO", queuer.showQueuerNO());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 前台 後台顯示當前號碼
		if ("showCurrentNO".equals(action)) {
			try {
				output.put("currentNO", queuer.showCurrentNO());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 前台 後台 顯示剩餘組數
		if ("showRemainNO".equals(action)) {
			try {
				output.put("remainNO", queuer.showRemainNO());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 後台 顯示總組數
		if("showTotalNO".equals(action)) {
			try {
				output.put("totalNO", queuer.showTotalNO());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 後台 顯示最近入座號碼
		if("showSeatedList".equals(action)) {
			try {
				output.put("seatedList", queuer.showSeatedList());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 後台 顯示最近過號號碼
		if("showOverList".equals(action)) {
			try {
				output.put("overList", queuer.showOverList());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 後台下一號按鈕
		if("doNextNO".equals(action)) {
			queuer.doNextNO();
			
			try {
				output.put("currentNO", queuer.showCurrentNO());
				output.put("nextNO", queuer.showNextNO());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 後台入座按鈕
		if("doSeatedList".equals(action)) {
			queuer.doSeatedNO();
			try {
				output.put("seatedNO", "success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 後台過號按鈕
		if("doOverList".equals(action)) {
			queuer.doOverNO();
			try {
				output.put("overNO", "success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		// 關閉系統按鈕觸發清除redis資料
		if ("openOrClose".equals(action)) {
			queuer.closeShop();
			try {
				output.put("closeShop", "success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		out.write(output.toString());
		out.flush();
		out.close();
		jedis.close();

	}
}
