package com.functions.controller;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.naming.java.javaURLContextFactory;

import com.functions.model.FunctionsDAO;
import com.functions.model.FunctionsService;
import com.functions.model.FunctionsVO;

@WebServlet("/functions/FunctionsServlet2")
public class FunctionsServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// ----- ----- ----- getAll start ----- ----- -----
		if ("getAll".equals(action)) {
			/*************************** 開始查詢資料 ****************************************/
		    FunctionsDAO dao = new FunctionsDAO();
			List<FunctionsVO> list = dao.getAll();

			/*************************** 查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("list", list); // 資料庫取出的list物件,存入session
			// Send the Success view
			String url = "/pages/functions/listAllEmp2_getFromSession.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交listAllEmp2_getFromSession.jsp
			successView.forward(req, res);
			return;
		}
		// ----- ----- ----- getAll end ----- ----- -----
		
		// ----- ----- ----- getOne_For_Display start ----- ----- -----
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
String str = req.getParameter("emp_id");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pages/functions/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer function_id = null;
				try {
					 function_id = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("員工編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/pages/functions/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				FunctionsService functionsSvc = new FunctionsService();
			    FunctionsVO functionsVO = functionsSvc.getOneFunctions(function_id);
				if (functionsVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pages/functions/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("functionsVO", functionsVO); // 資料庫取出的empVO物件,存入req
				String url = "/pages/functions/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		// ----- ----- ----- getOne_For_Display end ----- ----- -----
		
		// ----- ----- ----- insert start ----- ----- -----
		if ("insert".equals(action)) { // 來自addFunction.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			// emp_name
			String function_name = req.getParameter("function_name");
//			String emp_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
//			String function_nameReg = "";
			if (function_name == null || function_name.trim().length() == 0) {
				errorMsgs.add("功能名字: 請勿空白");
			}
//			else if (!function_name.trim().matches(function_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
//			}


			FunctionsVO functionsVO = new FunctionsVO();
			functionsVO.setFunction_name(function_name);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("functionsVO", functionsVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/pages/functions/addFunctions.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			FunctionsService functionsSvc = new FunctionsService();
			functionsVO = functionsSvc.addFunctions(function_name);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/pages/functions/listAllEmp1_byDAO.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- insert end ----- ----- -----
	}
}