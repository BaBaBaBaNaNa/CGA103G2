package com.mealscategory.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import com.mealscateory.model.*;



public class MealsCategoryServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("MealsCategoryId");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/mealscategory/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				Integer MealsCategoryId = null;
				try {
					MealsCategoryId = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("員工編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/mealscategory/select_page.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/**************************2.開始查詢資料****************************************/
				MealsCategoryService MealsCategorySvc = new MealsCategoryService();
				MealsCategoryVO mealsCategoryVO = MealsCategorySvc.getOneMealsCategory(MealsCategoryId);
				if (mealsCategoryVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/mealscategory/select_page.jsp");
					failureView.forward(req, res);
					return;//
				}
				
				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				req.setAttribute("mealsCategoryVO", mealsCategoryVO); //資料庫取出的empVO物件,存入req
				String url = "/mealscategory/listOneMealsCategory.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數 ****************************************/
				Integer MealsCategoryId = Integer.valueOf(req.getParameter("mealsCategoryId"));
				/***************************2.開始查詢資料****************************************/
				MealsCategoryService MealsCategorySvc = new MealsCategoryService();
				MealsCategoryVO mealsCategoryVO = MealsCategorySvc.getOneMealsCategory(MealsCategoryId);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				String param = "?MealsCategoryId="  +mealsCategoryVO.getMealsCategoryId()+
							 "&MealsCategory="  +mealsCategoryVO.getMealsCategory();
				String url = "/mealscategory/update_mealsCategory_input.jsp"+param;
	
				
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			System.out.println(1234);
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer MealsCategoryId = Integer.valueOf(req.getParameter("MealsCategoryId").trim());
			String MealsCategory = req.getParameter("MealsCategory");
			
			System.out.println(MealsCategory.getClass().getSimpleName());
			
			String enameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{0,10}$";
			if (MealsCategory == null || MealsCategory.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if (!MealsCategory.trim().matches(enameReg)) { //以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在0到10之間");
			}


			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/mealscategory/update_mealsCategory_input.jsp");
				failureView.forward(req, res);
				return; //程式中斷
			}
			/***************************2.開始修改資料 *****************************************/
			MealsCategoryService MealsCategorySvc = new MealsCategoryService();
			MealsCategoryVO mealsCategoryVO = MealsCategorySvc.updateMealsCategory(MealsCategoryId, MealsCategory);

			/*************************** 3.修改完成,準備轉交(Send the Success view)*************/
			req.setAttribute("mealsCategoryVO", mealsCategoryVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/mealscategory/listOneMealsCategory.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer MealsCategoryId = Integer.valueOf(req.getParameter("MealsCategoryId").trim());
			
			String MealsCategory = req.getParameter("MealsCategory");
			String enameReg = "^[(\u4e00-\u9fa5)]{0,10}$";
			if (MealsCategory == null || MealsCategory.trim().length() == 0) {
				errorMsgs.add("xxxx");
			} else if (!MealsCategory.trim().matches(enameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("yyyyy");
			}
			System.out.println(MealsCategoryId);
			System.out.println(MealsCategory);
			MealsCategoryVO mealsCategoryVO = new MealsCategoryVO();
			mealsCategoryVO.setMealsCategoryId(MealsCategoryId);
			mealsCategoryVO.setMealsCategory(MealsCategory);



			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("mealsCategoryVO", mealsCategoryVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/mealscategory/addMealsCategory.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料***************************************/
			MealsCategoryService MealsCategorySvc = new MealsCategoryService();
			MealsCategorySvc.addMealsCategory(MealsCategoryId, MealsCategory);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/mealscategory/listAllMC.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.***************************************/
			Integer MealsCategoryId = Integer.valueOf(req.getParameter("MealsCategoryId"));

			/*************************** 2.開始新增資料***************************************/
			System.out.println(MealsCategoryId);
			MealsCategoryService MealsCategorySvc = new MealsCategoryService();
			MealsCategorySvc.deleteMealsCategory(MealsCategoryId);
			
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/mealscategory/listAllMC.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);//  刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
		
	}
}
