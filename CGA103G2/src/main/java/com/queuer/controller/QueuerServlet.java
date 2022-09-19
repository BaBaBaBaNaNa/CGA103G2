package com.queuer.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.queuer.model.QueuerRedisService;

import redis.clients.jedis.Jedis;

public class QueuerServlet extends HttpServlet{
		
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
			QueuerRedisService queuer = new QueuerRedisService();
			PrintWriter out = res.getWriter();
			Jedis jedis = new Jedis("localhost",6379);
			JSONObject output = new JSONObject();
			
			// 前台action
			
			// 前台我要候位按鈕功能
			if( "queueInList".equals(action)) {
				queuer.queueInList();
				
//			res.setContentType("application/json");
				try {
					output.put("queuerNO", queuer.getQueuerNO());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
			// 顯示剩餘組數
			if("showRemainNO".equals(action)) {
				queuer.getRemainNO();
				try {
					output.put("remainNO", queuer.getQueuerNO());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			// 後台action
			
			// 後台按鈕下一號 顯示當前號碼 顯示下一號 剩餘組數的功能
			if("getNextNO".equals(action)) {
				try {
					output.put("currentNO", queuer.getCurrentNO());
					output.put("nextNO", queuer.getNextNO() );
					output.put("remainNO", queuer.getRemainNO());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if("showTotalNO".equals(action)) {
				try {
					output.put("totalNO", queuer.getTotalNO());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if("doSeatedList".equals(action)) {
				queuer.doSeatedList();
				try {
					output.put("seatedNO", "success");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if("doOverList".equals(action)) {
				queuer.doOverList();
				try {
					output.put("overNO", "success");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if("openOrClose".equals(action)) {
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
