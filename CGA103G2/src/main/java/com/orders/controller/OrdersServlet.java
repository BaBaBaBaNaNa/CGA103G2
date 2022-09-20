package com.orders.controller;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.orders.model.*;


//@WebServlet("/OrdersServlet")
public class OrdersServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("ordersID");
			if (str == null || (str.trim()).length() == 0||str == "0") {
				errorMsgs.add("請輸入訂單編號");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/order/order_details.jsp");
				failureView.forward(req, res);
				return; // 程式中斷	
			}

			Integer ordersID = null;
			try {
				ordersID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/order/order_details.jsp");
				failureView.forward(req, res);
				return;
			}
			/******** 2.開始查詢資料 *************/

			OrdersService ordersSvc = new OrdersService();
			OrdersVO ordersVO = ordersSvc.getOneOrders(ordersID);
			if (ordersVO == null) {
				errorMsgs.add("查無資料");
			}
//			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/order/order_details.jsp");
				failureView.forward(req, res);
				return;
			}
			/******** 3.查詢完成,準備轉交 **********/
			req.setAttribute("ordersVO", ordersVO);
			String url = "/back-end/order/listOneOrders.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);
			/*********** 1.接收請求參數 **************/
			Integer ordersID = Integer.valueOf(req.getParameter("ordersID"));

			/********** 2.開始查詢資料 ***********/
			OrdersService ordersSvc = new OrdersService();
			OrdersVO ordersVO = ordersSvc.getOneOrders(ordersID);
			/********** 3.查詢完成, 準備移交 **********/
			req.setAttribute("ordersVO", ordersVO);
			String url = "/back-end/order/update_orders_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		
//						update
		if ("update".equals(action)) { // 來自update_orders_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*********** 1.接收請求參數 --輸入格式的錯誤處理 **************/
			Integer ordersID = null;
			try {
				ordersID = Integer.valueOf(req.getParameter("ordersID").trim());
			} catch (NumberFormatException e) {
				ordersID = 0;
				errorMsgs.add("訂單編號:請勿留白");
			}
			
			Integer memID = null;
			try {
				memID = Integer.valueOf(req.getParameter("memID").trim());
			} catch (NumberFormatException e) {
				memID = 0;
				errorMsgs.add("會員編號:請勿留白");
			}

			Integer empCounterID = null;
			try {
				empCounterID = Integer.valueOf(req.getParameter("empCounterID").trim());
			} catch (NumberFormatException e) {
				empCounterID = 0;
				errorMsgs.add("櫃台員工編號:請勿留白");
			}

			Integer empDeliveryID = null;
			try {
				empDeliveryID = Integer.valueOf(req.getParameter("empDeliveryID").trim());
			} catch (NumberFormatException e) {
				empDeliveryID = 0;
				errorMsgs.add("外送員工編號");
			}

			Integer seatID = null;
			try {
				seatID = Integer.valueOf(req.getParameter("seatID").trim());
			} catch (NumberFormatException e) {
				seatID = 0;
				errorMsgs.add("座位號碼");
			}

			Integer ordersType = null;
			try {
				ordersType = Integer.valueOf(req.getParameter("ordersType").trim());
			} catch (NumberFormatException e) {
				ordersType = 0;
				errorMsgs.add("請確認訂單種類");
			}

			Integer ordersAmount = null;
			try {
				ordersAmount = Integer.valueOf(req.getParameter("ordersAmount").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("訂單金額請填數字.");
			}

			Integer ordersStatus = null;
			try {
				ordersStatus = Integer.valueOf(req.getParameter("ordersStatus").trim());
			} catch (NumberFormatException e) {
				ordersStatus = 0;
				errorMsgs.add("請確認訂單狀態");
			}

			String ordersDestination = req.getParameter("ordersDestination");
//			String ordersDestination = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]$";
			if (ordersDestination == null || ordersDestination.trim().length() == 0) {
				errorMsgs.add("地址: 請勿空白");
			}
//			else if (!ordersDestination.trim().matches(ordersDestination)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("地址: 只能是中、英文字母、數字和_ ");
//			}f

			Timestamp ordersBuildDate = null;
			try {
				ordersBuildDate = Timestamp.valueOf(req.getParameter("ordersBuildDate").trim());
			} catch (IllegalArgumentException e) {
				ordersBuildDate = new Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入成立訂單日!");
			}

			Timestamp ordersMakeDate = null;
			try {
				ordersMakeDate = Timestamp.valueOf(req.getParameter("ordersMakeDate").trim());
			} catch (IllegalArgumentException e) {
				ordersMakeDate = new Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入預計製作日!");
			}

			OrdersVO ordersVO = new OrdersVO();
			ordersVO.setOrdersID(ordersID);
			ordersVO.setMemID(memID);
			ordersVO.setEmpCounterID(empCounterID);
			ordersVO.setEmpDeliveryID(empDeliveryID);
			ordersVO.setSeatID(seatID);
			ordersVO.setOrdersType(ordersType);
			ordersVO.setOrdersAmount(ordersAmount);
			ordersVO.setOrdersStatus(ordersStatus);
			ordersVO.setOrdersDestination(ordersDestination);
			ordersVO.setOrdersBuildDate(ordersBuildDate);
			ordersVO.setOrdersMakeDate(ordersMakeDate);

//			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("ordersVO", ordersVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/order/update_orders_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

//			---------------------2.修改資料-------------------------------
			OrdersService orderSvc = new OrdersService();
			ordersVO = orderSvc.updateOrders(ordersID, memID, empCounterID, empDeliveryID, seatID, ordersType,
					ordersAmount, ordersStatus, ordersDestination, ordersBuildDate, ordersMakeDate);
			/**************** 3.修改完成準備移交數據 *********************/
			req.setAttribute("ordersVO", ordersVO);
			String url =  "/back-end/order/listOneOrders.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		/*******************                   insert                                      ************************/		
		if ("insert".equals(action)) { // 來自addOrders.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*********** 1.接收請求參數 --輸入格式的錯誤處理 **************/
			Integer ordersID = null;
			try {
				ordersID = Integer.valueOf(req.getParameter("ordersID").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("會員編號:請勿留白");
			}
			
			Integer memID = null;
			try {
				memID = Integer.valueOf(req.getParameter("memID").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("會員編號:請勿留白");
			}

			Integer empCounterID = null;
			try {
				empCounterID = Integer.valueOf(req.getParameter("empCounterID").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("櫃台員工編號:請勿留白");
			}

			Integer empDeliveryID = null;
			try {
				empDeliveryID = Integer.valueOf(req.getParameter("empDeliveryID").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("外送員工編號");
			}

			Integer seatID = null;
			try {
				seatID = Integer.valueOf(req.getParameter("seatID").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請確認桌位編號");
			}

			Integer ordersType = null;
			try {
				ordersType = Integer.valueOf(req.getParameter("ordersType").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請確認訂單種類");
			}

			Integer ordersAmount = null;
			try {
				ordersAmount = Integer.valueOf(req.getParameter("ordersAmount").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("訂單金額請填數字.");
			}

			Integer ordersStatus = null;
			try {
				ordersStatus = Integer.valueOf(req.getParameter("ordersStatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請確認訂單狀態");
			}

			String ordersDestination = req.getParameter("ordersDestination").trim();
			String ordersReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,30}$";
			if (ordersDestination == null || ordersDestination.trim().length() == 0) {
				errorMsgs.add("地址: 請勿空白");
			} 
			else if (!ordersDestination.matches(ordersReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("地址: 只能是中、英文字母、數字和_ ");
			}

			Timestamp ordersBuildDate = null;
				try {
					ordersBuildDate = Timestamp.valueOf(req.getParameter("ordersBuildDate").trim());					
				} catch (IllegalArgumentException e) {
					ordersBuildDate = new Timestamp(System.currentTimeMillis());
				}
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss:SSS");
			Timestamp ordersMakeDate = null;
			try {
				ordersMakeDate = Timestamp.valueOf(req.getParameter("ordersMakeDate"));
			} catch (IllegalArgumentException e) {
				ordersMakeDate = new Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入預計製作日!");
			}

			OrdersVO ordersVO = new OrdersVO();
			ordersVO.setOrdersID(ordersID);
			ordersVO.setMemID(memID);
			ordersVO.setEmpCounterID(empCounterID);
			ordersVO.setEmpDeliveryID(empDeliveryID);
			ordersVO.setSeatID(seatID);
			ordersVO.setOrdersType(ordersType);
			ordersVO.setOrdersAmount(ordersAmount);
			ordersVO.setOrdersStatus(ordersStatus);
			ordersVO.setOrdersDestination(ordersDestination);
			ordersVO.setOrdersBuildDate(ordersBuildDate);
			ordersVO.setOrdersMakeDate(ordersMakeDate);

//			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("ordersVO", ordersVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/order/addOrders.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

//			---------------------2.新增資料-------------------------------
			OrdersService orderSvc = new OrdersService();
			ordersVO = orderSvc.addOrders(ordersID, memID, empCounterID, empDeliveryID, seatID, ordersType,
					ordersAmount, ordersStatus, ordersDestination, ordersBuildDate, ordersMakeDate);
			/**************** 3.新增完成準備移交數據 *********************/
			req.setAttribute("ordersVO", ordersVO);
			String url = "/back-end/order/listOneOrders.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if ("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
		//
		//
		req.setAttribute("errorMsgs", errorMsgs);	
		/***************************1.接收請求參數***************************************/
		Integer ordersID = Integer.valueOf(req.getParameter("ordersID"));
		
		/***************************2.開始刪除資料***************************************/
		OrdersService ordersSvc = new OrdersService();
		ordersSvc.deleteOrders(ordersID);
		
		/***************************3.刪除完成,準備轉交(Send the Success view)***********/		
		
		String url = "/back-end/order/listAllOrders";
		RequestDispatcher successView = req.getRequestDispatcher(url);    // 刪除成功後,轉交回送出刪除的來源網頁
		successView.forward(req, res);
		
		}
		
		
	
		

	}

}
