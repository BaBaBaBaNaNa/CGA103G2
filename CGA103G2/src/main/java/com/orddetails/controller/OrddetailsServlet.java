package com.orddetails.controller;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orddetails.model.OrddetailsDAO;
import com.orddetails.model.OrddetailsService;
import com.orddetails.model.OrddetailsVO;


//@WebServlet("/OrddetailsServlet")
public class OrddetailsServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
if ("getOne_For_Display4".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1接收請求參數 - 輸入格式的錯誤處理 **********************/
			System.out.println("d;lk;lfdkg;lfdkg;lfd");
			String str = req.getParameter("orderDetailId");
			if (str == null || (str.trim()).length()== 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return; // �{�����_	
			}

			Integer orddetailsID = null;
			try {
				orddetailsID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			/******** 2.開始查詢資料 *************/
			OrddetailsService orddetailsSvc = new OrddetailsService();
			List<OrddetailsVO> orddetailsVO = orddetailsSvc.getOneOrddetails(orddetailsID);
			System.out.println(orddetailsVO);
			if (orddetailsVO == null) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return;
			} 
			
			/******** 3查詢完成,準備轉交 **********/
			
			req.setAttribute("orddetailsVO", orddetailsVO);
			String url = "/front-end/order/order-details.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}		
		
if ("getOne_For_Display3".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1接收請求參數 - 輸入格式的錯誤處理 **********************/
			System.out.println("d;lk;lfdkg;lfdkg;lfd");
			String str = req.getParameter("orderDetailId");
			if (str == null || (str.trim()).length()== 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return; // �{�����_	
			}

			Integer orddetailsID = null;
			try {
				orddetailsID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			/******** 2.開始查詢資料 *************/
			OrddetailsService orddetailsSvc = new OrddetailsService();
			List<OrddetailsVO> orddetailsVO = orddetailsSvc.getOneOrddetails(orddetailsID);
			System.out.println(orddetailsVO);
			if (orddetailsVO == null) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return;
			} 
			
			/******** 3查詢完成,準備轉交 **********/
			
			req.setAttribute("orddetailsVO", orddetailsVO);
			String url = "/front-end/order/order-details-waisong.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}		
		
if ("getOne_For_Display2".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1接收請求參數 - 輸入格式的錯誤處理 **********************/
			System.out.println("d;lk;lfdkg;lfdkg;lfd");
			String str = req.getParameter("orderDetailId");
			if (str == null || (str.trim()).length()== 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return; // �{�����_	
			}

			Integer orddetailsID = null;
			try {
				orddetailsID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			/******** 2.開始查詢資料 *************/
			OrddetailsService orddetailsSvc = new OrddetailsService();
			List<OrddetailsVO> orddetailsVO = orddetailsSvc.getOneOrddetails(orddetailsID);
			System.out.println(orddetailsVO);
			if (orddetailsVO == null) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return;
			} 
			
			/******** 3查詢完成,準備轉交 **********/
			
			req.setAttribute("orddetailsVO", orddetailsVO);
			String url = "/front-end/order/order-details-waidai.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if ("getOne_For_Display".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			/*************************** 1接收請求參數 - 輸入格式的錯誤處理 **********************/
			System.out.println("d;lk;lfdkg;lfdkg;lfd");
			String str = req.getParameter("orderDetailId");
			if (str == null || (str.trim()).length()== 0) {
				errorMsgs.add("請輸入訂單編號");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return; // �{�����_	
			}

			Integer orddetailsID = null;
			try {
				orddetailsID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			/******** 2.開始查詢資料 *************/
			OrddetailsService orddetailsSvc = new OrddetailsService();
			List<OrddetailsVO> orddetailsVO = orddetailsSvc.getOneOrddetails(orddetailsID);
			System.out.println(orddetailsVO);
			if (orddetailsVO == null) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/select_page.jsp");
				failureView.forward(req, res);
				return;
			} 
			
			/******** 3查詢完成,準備轉交 **********/
			
			req.setAttribute("orddetailsVO", orddetailsVO);
			String url = "/back-end/orddetails/listOneOrddetails.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
//		if ("getOne_For_Update".equals(action)) {
//			List<String> errorMsgs = new LinkedList<String>();
//
//			req.setAttribute("errorMsgs", errorMsgs);
//			/*********** 1接收請求參數 **************/
//			Integer orddetailsID = Integer.valueOf(req.getParameter("orddetailsID"));
//
//			/********** 2.開始查詢資料***********/
//			OrddetailsService orddetailsSvc = new OrddetailsService();
//			List<OrddetailsVO> orddetailsVO = orddetailsSvc.getOneOrddetails(orddetailsID);
//			/********** 3.查詢完成,準備轉交 **********/
//			req.setAttribute("orddetailsVO", orddetailsVO);
//			String url = "/back-end/orddetails/update_orddetails_input.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
//		}
		
		if ("xxx".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			Integer orddetailsID = Integer.valueOf(req.getParameter("orddetailsID"));
			OrddetailsService orddetailsSvc = new OrddetailsService();
			OrddetailsVO orddetailsVO = orddetailsSvc.getOneOrddetails1(orddetailsID);
			req.setAttribute("orddetailsVO", orddetailsVO);
			String url = "/back-end/orddetails/update_orddetails_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
//				update
		if ("update".equals(action)) { // 來自update_orddetails_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*********** 1.接收請求參數 --輸入格式的錯誤處理  **************/
			
			Integer orddetailsID = Integer.valueOf(req.getParameter("orddetailsID").trim());
			
			Integer ordersID = Integer.valueOf(req.getParameter("ordersID").trim());
			
			Integer mealsID = Integer.valueOf(req.getParameter("mealsID").trim());
			
			Integer orddetailsMealsQuantity = Integer.valueOf(req.getParameter("orddetailsMealsQuantity").trim());
			
			Integer orddetailsMealsAmount = Integer.valueOf(req.getParameter("orddetailsMealsAmount").trim());
			
			Integer orddetailsMealsStatus = null;
			try {
				orddetailsMealsStatus = Integer.valueOf(req.getParameter("orddetailsMealsStatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
			Integer orddetailsDeliverStatus = null;
			try {
				orddetailsDeliverStatus = Integer.valueOf(req.getParameter("orddetailsDeliverStatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
		
			OrddetailsVO orddetailsVO = new OrddetailsVO();
			orddetailsVO.setOrddetailsID(orddetailsID);
			orddetailsVO.setOrdersID(ordersID);
			orddetailsVO.setMealsID(mealsID);
			orddetailsVO.setOrddetailsMealsQuantity(orddetailsMealsQuantity);
			orddetailsVO.setOrddetailsMealsAmount(orddetailsMealsAmount);
			orddetailsVO.setOrddetailsMealsStatus(orddetailsMealsStatus);
			orddetailsVO.setOrddetailsDeliverStatus(orddetailsDeliverStatus);
			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("orddetailsVO", orddetailsVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/orddetails/update_orddetails_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷_
			}
//			---------------------2.修改資料-------------------------------
			OrddetailsService orddetailsSvc = new OrddetailsService();
			orddetailsVO = orddetailsSvc.updateOrddetails( orddetailsID,  ordersID,  mealsID,
					 orddetailsMealsQuantity,  orddetailsMealsAmount,  orddetailsMealsStatus,
					 orddetailsDeliverStatus);
			/**************** 3.修改完成準備移交數據 *********************/
			req.setAttribute("orddetailsVO", orddetailsVO);
			String url =  "/back-end/orddetails/listOneAllDetails.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		/*******************                   insert                                      ************************/		
		if ("insert".equals(action)) { //來自addOrddetails.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*********** 1.接收請求參數 --輸入格式的錯誤處理  **************/
			
			Integer orddetailsID = null;
			try {
				orddetailsID = Integer.valueOf(req.getParameter("orddetailsID").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
			
			Integer ordersID = null;
			try {
				ordersID = Integer.valueOf(req.getParameter("ordersID").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
			
			Integer mealsID = null;
			try {
				mealsID = Integer.valueOf(req.getParameter("mealsID").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
			Integer orddetailsMealsQuantity = null;
			try {
				orddetailsMealsQuantity = Integer.valueOf(req.getParameter("orddetailsMealsQuantity").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
			
			Integer orddetailsMealsAmount = null;
			try {
				orddetailsMealsAmount = Integer.valueOf(req.getParameter("orddetailsMealsAmount").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
			
			Integer orddetailsMealsStatus = null;
			try {
				orddetailsMealsStatus = Integer.valueOf(req.getParameter("orddetailsMealsStatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
			Integer orddetailsDeliverStatus = null;
			try {
				orddetailsDeliverStatus = Integer.valueOf(req.getParameter("orddetailsDeliverStatus").trim());
			} catch (NumberFormatException e) {
				errorMsgs.add("請勿留白");
			}
			
			OrddetailsVO orddetailsVO = new OrddetailsVO();
			
			orddetailsVO.setOrddetailsID(orddetailsID);
			orddetailsVO.setOrdersID(ordersID);
			orddetailsVO.setMealsID(mealsID);
			orddetailsVO.setOrddetailsMealsQuantity(orddetailsMealsQuantity);
			orddetailsVO.setOrddetailsMealsAmount(orddetailsMealsAmount);
			orddetailsVO.setOrddetailsMealsStatus(orddetailsMealsStatus);
			orddetailsVO.setOrddetailsDeliverStatus(orddetailsDeliverStatus);
			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("orddetailsVO", orddetailsVO);
				RequestDispatcher  failureView = req.getRequestDispatcher("/back-end/orddetails/addOrddetails.jsp");
				failureView.forward(req, res);
				return; // �{�����_
			}
//			---------------------2.新增資料------------------------------- ***/
			OrddetailsService orddetailsSvc = new OrddetailsService();
			orddetailsVO = orddetailsSvc.addOrddetails( orddetailsID,  ordersID,  mealsID,
					 orddetailsMealsQuantity,  orddetailsMealsAmount,  orddetailsMealsStatus,
					 orddetailsDeliverStatus);
			/**************** 3.新增完成準備移交數據 *********************/
			String url =  "/back-end/orddetails/listOneOrddetails.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		
		if ("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
		//
		//
		req.setAttribute("errorMsgs", errorMsgs);	
		/***************************1.接收請求參數***************************************/
		Integer orddetailsID = Integer.valueOf(req.getParameter("orddetailsID"));
		
		/***************************2.開始刪除資料***************************************/
		OrddetailsService orddetailsSvc = new OrddetailsService();
		orddetailsSvc.deleteOrddetails(orddetailsID);
		
		/***************************3刪除完成,準備轉交(Send the Success view)***********/		
		
		String url = "/back-end/orddetails/listAllOrddetails";
		RequestDispatcher successView = req.getRequestDispatcher(url);    // 刪除成功後,轉交回送出刪除的來源網頁
		successView.forward(req, res);
		
		}
		
		
	}
	
}
