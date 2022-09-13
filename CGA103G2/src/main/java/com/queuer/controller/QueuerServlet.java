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
			if("queueInList".equals(action)) {
				queuer.queueInList();
				
				
				JSONObject output = new JSONObject();
//			res.setContentType("application/json");
				try {
					output.put("queuerNO", queuer.getQueuerNO());
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
				
				out.write(output.toString());
				out.flush();
				out.close();
				jedis.close();
			}
			
	}
}
