package com.permission.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.naming.java.javaURLContextFactory;

import com.permission.model1.PermissionDAO;
import com.permission.model1.PermissionService;
import com.permission.model1.PermissionVO;

@WebServlet("/permission/PermissionServlet2")
public class permissionServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		// ----- ----- ----- getAll start ----- ----- -----
		if ("getAll".equals(action)) {
			/*************************** 開始查詢資料 ****************************************/
			PermissionDAO dao = new PermissionDAO();
			List<PermissionVO> list = dao.getAll();

			/*************************** 查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("list", list); // 資料庫取出的list物件,存入session
			// Send the Success view
			String url = "/pages/permission/listAllEmp2_getFromSession.jsp";
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
							.getRequestDispatcher("/pages/permission/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer emp_id = null;
				try {
					 emp_id = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("員工編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pages/permission/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				PermissionService permissionSvc = new PermissionService();
				PermissionVO permissionVO = permissionSvc.getOnePermission(emp_id);
				if (permissionVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/pages/permission/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("permissionVO", permissionVO); // 資料庫取出的empVO物件,存入req
				String url = "/pages/permission/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		// ----- ----- ----- insert start ----- ----- -----
		
		if ("insert".equals(action)) { // 來自addEmp.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/

			String emp_id = req.getParameter("emp_id").trim();
			if (emp_id == null || emp_id.trim().length() == 0) {
				errorMsgs.add("emp_id請勿空白");
			}
			
			String function_id = req.getParameter("function_id").trim();
			if (function_id == null || function_id.trim().length() == 0) {
				errorMsgs.add("function_id請勿空白");
			}

			PermissionVO permissionVO = new PermissionVO();
			permissionVO.setEmp_id(Integer.parseInt(emp_id));
			permissionVO.setFunction_id(Integer.parseInt(function_id));

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("permissionVO", permissionVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/pages/permission/addPermission.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			PermissionService permissionSvc = new PermissionService();
			permissionVO = permissionSvc.addPermission(Integer.parseInt(emp_id),Integer.parseInt(function_id));

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/pages/permission/listAllPermission1_byDAO.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- insert end ----- ----- -----
	}
}