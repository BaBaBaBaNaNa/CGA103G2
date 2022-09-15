package com.shopcart.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopcart.model.ShopCartService;
import com.shopcart.model.ShopCartVO;

@WebServlet("/front-end/shopcart/ShopCartServlet.do")
public class ShopCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		action = "insertInside";
		
		// ----- ----- ----- insertInside start ----- ----- -----
		if ("insertInside".equals(action)) { 
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
 
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			//----- 產生內用訂單 -----
			
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
			
			//產生訂單明細


			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front-end/shopcart/ShopCart.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ShopCartService shopcartSvc = new ShopCartService();
			shopcartSvc.addInsideOrder(ordersType, ordersStatus, ordersBuildDate);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("shopcartVO", shopcartVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/front-end/shopcart/ShopCartAddSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- insertInside end ----- ----- -----
	}
}
