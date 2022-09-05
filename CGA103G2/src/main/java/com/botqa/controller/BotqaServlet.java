package com.botqa.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.MultipartConfig;

import java.util.*;
import com.botqa.model.*;

@MultipartConfig(fileSizeThreshold = 0 * 1024 * 1024, maxFileSize = 1 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class BotqaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

			String str = req.getParameter("keywordID");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入員工編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/botqa/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			Integer keywordID = null;
			try {
				keywordID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("員工編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/botqa/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			/************************** 2.開始查詢資料 ****************************************/
			BotqaService botqaSvc = new BotqaService();
			BotqaVO botqaVO = botqaSvc.getOneBotqa(keywordID);
			if (botqaVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/botqa/select_page.jsp");
				failureView.forward(req, res);
				return;//
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("botqaVO", botqaVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/botqa/listOneBotqa.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer keywordID = Integer.valueOf(req.getParameter("keywordID"));
			/*************************** 2.開始查詢資料 ****************************************/
			BotqaService BotqaSvc = new BotqaService();
			BotqaVO botqaVO = BotqaSvc.getOneBotqa(keywordID);
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = "?keywordID=" + botqaVO.getKeywordID() + 
					"&keywordName=" +botqaVO.getKeywordName()+ 
					"&keywordContext=" + botqaVO.getKeywordContext();
			String url = "/back-end/botqa/update_Botqa_input.jsp" + param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			Map<String, String> errorMsgs = new LinkedHashMap<String, String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer keywordID = Integer.valueOf(req.getParameter("keywordID").trim());

			String keywordName = req.getParameter("keywordName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{0,10}$";
			if (keywordName == null || keywordName.trim().length() == 0) {
				errorMsgs.put("ename", "員工姓名: 請勿空白");
				System.out.println("菜名空白");
			} else if (!keywordName.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("ename", "員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				System.out.println("菜名自述");
			}

			String keywordContext = req.getParameter("keywordContext").trim();
			String mealsInfoReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9_)]{3,500}$"; // 此正則(規)表示式(regular-expression)- 用來比對JSR
																				// 303 的@Size
			if (keywordContext == null || keywordContext.trim().length() == 0) {
				errorMsgs.put("mealsInfo", "員工職位: 請勿空白");
				System.out.println("菜名說明");
			} else if (!keywordContext.trim().matches(mealsInfoReg)) {
				errorMsgs.put("mealsInfo", "員工職位: 長度必需在3到500之間");
				System.out.println("菜名空白自");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/botqa/update_Botqa_input.jsp");
				failureView.forward(req, res);
				System.out.println("errorMsgs.isEmpty()");
				return; // 程式中斷
			}
			/*************************** 2.開始修改資料 *****************************************/
			BotqaService botqaSvc = new BotqaService();
			BotqaVO botqaVO =botqaSvc.updateBotqa(keywordID, keywordName, keywordContext);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("botqaVO", botqaVO); // 資料庫update成功後,正確的的empVO物件,存入req
			System.out.println("/back-end/botqa/listOneBotqa.jsp");
			String url = "/back-end/botqa/listOneBotqa.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String keywordName = req.getParameter("keywordName");
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (keywordName == null || keywordName.trim().length() == 0) {
				errorMsgs.add("產品名:請勿空白");
			} else if (!keywordName.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("產品名:只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String keywordContext = req.getParameter("keywordContext");
			String keywordContextReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{3,500}$";
			if (keywordContext == null || keywordContext.trim().length() == 0) {
				errorMsgs.add("餐品介紹:請勿空白");
			} else if (!keywordContext.trim().matches(keywordContextReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("餐品介紹:只能是中、英文字母、數字和_ , 且長度必需在3到500之間");
			}


			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/botqa/addBotqa.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			BotqaService botqaSvc =new BotqaService();
			botqaSvc.addBotqa(keywordName, keywordContext);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("success", "- (新增成功)");
			String url = "/back-end/botqa/listAllBotqa.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1. ***************************************/
			Integer keywordID = Integer.valueOf(req.getParameter("keywordID"));

			/*************************** 2.開始新增資料 ***************************************/
			System.out.println(keywordID);
			BotqaService botqaSvc =new BotqaService();
			botqaSvc.deletDotqa(keywordID);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/botqa/listAllBotqa.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
