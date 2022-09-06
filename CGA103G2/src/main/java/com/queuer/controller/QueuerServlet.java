package com.queuer.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.queuer.model.QueuerService;
import com.queuer.model.QueuerVO;


public class QueuerServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("queuerNo");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入候位號碼");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/queuer/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer queuerNo = null;
				try {
					queuerNo = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("候位號碼格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/queuer/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				 QueuerService queuerSvc = new QueuerService();
				 QueuerVO queuerVO = queuerSvc.getOneQueuer(queuerNo);
				if (queuerVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/queuer/select_page.jsp");
					failureView.forward(req, res);
			return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("queuerVO", queuerVO); // 資料庫取出的queuerVO物件,存入req
				String url = "/queuer/listOneQueuer.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneQueuer.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllQueuer.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer queuerID = Integer.valueOf(req.getParameter("queuerID"));
				System.out.println(queuerID);			

				/***************************2.開始查詢資料****************************************/
				QueuerService queuerSvc = new QueuerService();
				QueuerVO queuerVO = queuerSvc.getOneQueuer(queuerID);
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("queuerVO", queuerVO);         // 資料庫取出的empVO物件,存入req
				String url = "/queuer/update_queuer_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_queuer_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				Integer queuerID = Integer.valueOf(req.getParameter("queuerID").trim());
				
				String queuerName = req.getParameter("queuerName");
				String queuerNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (queuerName == null || queuerName.trim().length() == 0) {
					errorMsgs.add("候位姓名: 請勿空白");
				} else if(!queuerName.trim().matches(queuerNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("候位姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				String queuerPhone = req.getParameter("queuerPhone").trim();
				if (queuerPhone == null || queuerPhone.trim().length() == 0) {
					errorMsgs.add("電話請勿空白");
				}	
				

				Integer queuerStatus = Integer.valueOf(req.getParameter("queuerStatus").trim());




				QueuerVO queuerVO = new QueuerVO();
				queuerVO.setQueuerID(queuerID);
				queuerVO.setQueuerName(queuerName);
				queuerVO.setQueuerStatus(queuerStatus);
				queuerVO.setQueuerPhone(queuerPhone);
//				queuerVO.setQueuerNo(queuerID);
				
				
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("queuerVO", queuerVO); // 含有輸入格式錯誤的queuerVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/queuer/update_queuer_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				QueuerService queuerSvc = new QueuerService();
				queuerSvc.updateQueuer(queuerStatus, queuerID);
				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("queuerVO", queuerVO); // 資料庫update成功後,正確的的queuerVO物件,存入req
				String url = "/queuer/listOneQueuer.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneQueuer.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addQueuer.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/
			
			Integer queuerID = Integer.valueOf(req.getParameter("queuerID").trim());
			
			String queuerName = req.getParameter("queuerName");
							String queuerNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
							if (queuerName == null || queuerName.trim().length() == 0) {
								errorMsgs.add("候位姓名: 請勿空白");
							} else if(!queuerName.trim().matches(queuerNameReg)) { //以下練習正則(規)表示式(regular-expression)
								errorMsgs.add("候位姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				            }
							
			String queuerPhone = req.getParameter("queuerPhone").trim();
							if (queuerPhone == null || queuerPhone.trim().length() == 0) {
								errorMsgs.add("電話請勿空白");
							}	
							

			Integer queuerStatus = Integer.valueOf(req.getParameter("queuerStatus").trim());


			Integer waitingID = Integer.valueOf(req.getParameter("waitingID").trim());


			Integer queuerNo = Integer.valueOf(req.getParameter("queuerNo").trim());
							QueuerVO queuerVO = new QueuerVO();
							queuerVO.setQueuerID(queuerID);
							queuerVO.setWaitingID(waitingID);
							queuerVO.setQueuerStatus(queuerStatus);
							queuerVO.setQueuerPhone(queuerPhone);
							queuerVO.setQueuerNo(queuerNo);
							
							
							// Send the use back to the form, if there were errors
							if (!errorMsgs.isEmpty()) {
			req.setAttribute("queuerVO", queuerVO); // 含有輸入格式錯誤的queuerVO物件,也存入req
								RequestDispatcher failureView = req
										.getRequestDispatcher("/queuer/update_queuer_input.jsp");
								failureView.forward(req, res);
								return; //程式中斷
							}


				
				/***************************2.開始新增資料***************************************/
							QueuerService queuerSvc = new QueuerService();
							queuerVO = queuerSvc.addQueuer(queuerNameReg, queuerPhone);
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/emp/listAllQueuer.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		}
		
		
		
	}
}
