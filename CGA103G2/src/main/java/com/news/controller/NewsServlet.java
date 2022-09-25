package com.news.controller;

import java.io.IOException;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news.model.NewsService;
import com.news.model.NewsVO;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.*;

//@WebServlet("/NewsServlet.do")
@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 750 * 1024 * 1024)
public class NewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

//		if ("getOne_For_Display".equals(action)) {
//			List<String> errorMsgs = new LinkedList<String>();
//			req.setAttribute("errorMsgs", errorMsgs);
//
//		/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
//		
//			String str = req.getParameter("newsID");
//			if (str == null || (str.trim()).length() == 0||str == "0") {
//				errorMsgs.add("請輸入消息編號");
//			}
//
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/select_page.jsp");
//				failureView.forward(req, res);
//				return; // 程式中斷	
//			}
//
//			Integer newsID = null;
//			try {
//				newsID = Integer.valueOf(str);
//			} catch (Exception e) {
//				errorMsgs.add("消息編號格式不正確");
//			}
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/select_page.jsp");
//				failureView.forward(req, res);
//				return;
//			}
//			/******** 2.開始查詢資料 *************/
//
//			NewsService newsSvc = new NewsService();
//			NewsVO newsVO = newsSvc.getOneNews(newsID);
//			if (newsVO == null) {
//				errorMsgs.add("查無資料");
//			}
//			
//			if (!errorMsgs.isEmpty()) {
//				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/select_page.jsp");
//				failureView.forward(req, res);
//				return;
//			}
//			/******** 3.查詢完成,準備轉交 **********/
//			req.setAttribute("newsVO", newsVO);
//			String url = "/back-end/news/listOneNews.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);
//			successView.forward(req, res);
//		}

		if ("getOne_For_Update".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);
			/*********** 1.接收請求參數 **************/
			Integer newsID = Integer.valueOf(req.getParameter("newsID"));

			/********** 2.開始查詢資料 ***********/
			NewsService newsSvc = new NewsService();
			NewsVO newsVO = newsSvc.getOneNews(newsID);
			/********** 3.查詢完成, 準備移交 **********/
			req.setAttribute("newsVO", newsVO);
			String url = "/back-end/news/update_news_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
		}

		if ("update".equals(action)) { // 來自update_news_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*********** 1.接收請求參數 --輸入格式的錯誤處理 **************/
			Integer newsID = Integer.valueOf(req.getParameter("newsID").trim());
			
			Integer empID = null;
			try {
				empID = Integer.valueOf(req.getParameter("empID").trim());
			} catch (NumberFormatException e) {
				empID = 0;
				errorMsgs.add("員工編號:請勿留白");
			}

			Timestamp newsDate = null;
			try {
				newsDate = Timestamp.valueOf(req.getParameter("newsDate").trim());
			} catch (IllegalArgumentException e) {
				newsDate = new Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入消息日期!");
			}

			String newsTitle = req.getParameter("newsTitle");
			if (newsTitle == null || newsTitle.trim().length() == 0) {
				errorMsgs.add("請輸入內容");
			}


			String newsInformation = req.getParameter("newsInformation");
			if (newsInformation == null || newsInformation.trim().length() == 0) {
				errorMsgs.add("請輸入內容");
			}

			Integer newsControl = null;
			try {
				newsControl = Integer.valueOf(req.getParameter("newsControl").trim());
			} catch (NumberFormatException e) {
				newsControl = 0;
				errorMsgs.add("控制狀態");
			}
			//圖片
			InputStream in = req.getPart("newsPictures").getInputStream();
			byte[] newsPictures = null;
			if (in.available() !=0 ) {
				newsPictures = new byte[in.available()];
				in.read(newsPictures);
				in.close();
			} else {
				NewsService newsSvc = new NewsService();
				newsPictures = newsSvc.getOneNews(newsID).getNewsPictures();
			}if (newsPictures == null) {
				errorMsgs.add("請新增圖片");
			}
			
			
			NewsVO newsVO = new NewsVO();
			newsVO.setNewsID(newsID);
			newsVO.setEmpID(empID);
			newsVO.setNewsDate(newsDate);
			newsVO.setNewsTitle(newsTitle);
			newsVO.setNewsInformation(newsInformation);
			newsVO.setNewsControl(newsControl);
			newsVO.setNewsPictures(newsPictures);

//			
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("newsID", newsID);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/update_news_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

//			---------------------2.修改資料-------------------------------
			NewsService newsSvc = new NewsService();
			newsVO = newsSvc.updateNews(newsID, empID, newsDate, newsTitle,newsInformation, newsControl, 
					newsPictures);
			/**************** 3.修改完成準備移交數據 *********************/
			req.setAttribute("newsVO", newsVO);
			String url =  "/back-end/news/listOneNews.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
		}
		/*******************                   insert                                      ************************/		
		if ("insert".equals(action)) { // 來自addNewss.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*********** 1.接收請求參數 --輸入格式的錯誤處理 **************/
			
			Integer empID = null;
			try {
				empID = Integer.valueOf(req.getParameter("empID").trim());
			} catch (NumberFormatException e) {
				empID = 0;
				errorMsgs.add("會員編號:請勿留白");
			}

			Timestamp newsDate = null;
			try {
				newsDate = Timestamp.valueOf(req.getParameter("newsDate").trim());
			} catch (IllegalArgumentException e) {
				newsDate = new Timestamp(System.currentTimeMillis());
				errorMsgs.add("請輸入消息日期!");
			}

			String newsTitle = req.getParameter("newsTitle");
			if (newsTitle == null || newsTitle.trim().length() == 0) {
				errorMsgs.add("請輸入內容");
			}


			String newsInformation = req.getParameter("newsInformation");
			if (newsInformation == null || newsInformation.trim().length() == 0) {
				errorMsgs.add("請輸入內容");
			}

			Integer newsControl = null;
			try {
				newsControl = Integer.valueOf(req.getParameter("NewsControl").trim());
			} catch (Exception e) {
				newsControl = 0;
				errorMsgs.add("控制狀態");
			}

			//照片
			InputStream in = req.getPart("newsPictures").getInputStream();
			byte[] newsPictures = null;
			if(in.available()!=0) {
				newsPictures = new byte[in.available()];
				in.read(newsPictures);
				in.close();
			} else errorMsgs.add("請上傳照片");
				
			NewsVO newsVO = new NewsVO();

			newsVO.setEmpID(empID);
			newsVO.setNewsDate(newsDate);
			newsVO.setNewsTitle(newsTitle);
			newsVO.setNewsInformation(newsInformation);
			newsVO.setNewsControl(newsControl);
			newsVO.setNewsPictures(newsPictures);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("newsVO", newsVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/news/addNews.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

//			---------------------2.新增資料-------------------------------
			NewsService newsSvc = new NewsService();
			newsVO = newsSvc.addNews(empID, newsDate, newsTitle,newsInformation, newsControl, 
					newsPictures);
			/**************** 3.新增完成準備移交數據 *********************/
			req.setAttribute("newsVO", newsVO);
			String url = "listOneNews.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			
		}
	}
	
}
