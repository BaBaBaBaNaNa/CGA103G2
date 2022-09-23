package com.shopcart.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.shopcart.model.ShopCartService;
import com.shopcart.model.ShopCartVO;

@WebServlet("/front-end/shopcart/ShopCartServlet.do")
public class ShopCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		action = "insertInside";

		// ----- ----- ----- insertInside start ----- ----- -----
		if ("insertInside".equals(action)) {
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			// ----- 產生內用訂單 -----

			// 訂單種類 0:外帶, 1:外送, 2: 內用
			Integer ordersType = 2;

			// 訂單狀態 0:完成 , 1:未完成 , 2: 退回
			Integer ordersStatus = 1;

			Timestamp ordersBuildDate = null;
			try {
//					ordersBuildDate = Timestamp.valueOf(req.getParameter("ordersBuildDate").trim());			
				ordersBuildDate = new Timestamp(System.currentTimeMillis());
			} catch (IllegalArgumentException e) {
				ordersBuildDate = new Timestamp(System.currentTimeMillis());
			}

			ShopCartVO shopcartVO = new ShopCartVO();

			shopcartVO.setOrdersType(ordersType);
			shopcartVO.setOrdersStatus(ordersStatus);
			shopcartVO.setOrdersBuildDate(ordersBuildDate);

			// 產生訂單明細

			// =====使用json gson 處理進來的資料 品名 數量 價格 =====
			Gson gson = new Gson();
			// 資料進來先丟到Jsonobject
			JsonObject Jsonobject = gson.fromJson(req.getReader(), JsonObject.class);

			// 輸出測試取得cart
//			System.out.println (Jsonobject.get("cart"));
			
			JSONArray jArray = null;
			
			ArrayList PriceArrayList = new ArrayList();
			ArrayList NameArrayList = new ArrayList();
			ArrayList CountArrayList = new ArrayList();
			ArrayList NameidArrayList = new ArrayList();
			try {
				// cart丟到 jArray 處理
				jArray = new JSONArray(Jsonobject.get("cart").toString());
				// 輸出看看是否成功
//				System.out.println(jArray); 
				
				for (int i = 0; i < jArray.length(); i++) {
					// 東西丟到 jObject 取得每項的key value
					JSONObject jObject = new JSONObject(jArray.get(i).toString());
					
					// 測試東西
//					System.out.println(jObject);
//					System.out.println("price:" + jObject.get("price"));
//					System.out.println("name:" + jObject.get("name"));
//					System.out.println("count:" + jObject.get("count"));
//					System.out.println("==========");
					
					PriceArrayList.add(jObject.get("price"));
					NameArrayList.add(jObject.get("name"));
					CountArrayList.add(jObject.get("count"));
					NameidArrayList.add(jObject.get("nameid"));
					// 測試東西
//					System.out.println(PriceArrayList);
//					System.out.println(NameArrayList);
//					System.out.println(CountArrayList);
//					System.out.println("==========");
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			System.out.println("有執行10");
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/shopcart/ShopCart.jsp");
				failureView.forward(req, res);
				return;
			}
			/*************************** 2.開始新增資料 ***************************************/
			// 新增訂單
			ShopCartService shopcartSvc = new ShopCartService();
			shopcartSvc.addInsideOrder(ordersType, ordersStatus, ordersBuildDate,PriceArrayList,NameArrayList,CountArrayList,NameidArrayList);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("shopcartVO", shopcartVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/front-end/shopcart/ShopCartAddSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- insertInside end ----- ----- -----
	}
}
