package com.rsvt.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsvt.model.RsvtService;
import com.rsvt.model.RsvtVO;


@WebServlet("/back-end/reservation/RsvtServlet")
public class RsvtServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_CustomerName".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";
			String customerName = req.getParameter("customerName");
			if (customerName == null || (customerName.trim()).length() == 0) {
				errorMsgs.add("顧客姓名: 請勿空白");
			} else if (!customerName.trim().matches(nameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("顧客姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到20之間");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/back-end/reservation/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			RsvtService rsvtSvc = new RsvtService();
			RsvtVO rsvtVO = rsvtSvc.getOneName(customerName);
			if (rsvtVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/reservation/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("rsvtVO", rsvtVO); // 資料庫取出的rsvtVO物件,存入req
			String url = "/back-end/reservation/listOneRsvt.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneRsvt.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

//			String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";
//			String customerName = req.getParameter("customerName");
//			if (customerName == null || (customerName.trim()).length() == 0) {
//				errorMsgs.add("顧客姓名: 請勿空白");
//			} else if(!customerName.trim().matches(nameReg)) { //以下練習正則(規)表示式(regular-expression)
//				errorMsgs.add("顧客姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到20之間");
//            }
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("rsvtId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訂位編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/reservation/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer rsvtId = null;
			try {
				rsvtId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("訂位編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/reservation/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			RsvtService rsvtSvc = new RsvtService();
			RsvtVO rsvtVO = rsvtSvc.getOneRsvt(rsvtId);
			if (rsvtVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/reservation/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("rsvtVO", rsvtVO); // 資料庫取出的rsvtVO物件,存入req
			String url = "/back-end/reservation/listOneRsvt.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneRsvt.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllRsvt.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer rsvtId = Integer.valueOf(req.getParameter("rsvtId"));

			/*************************** 2.開始查詢資料 ****************************************/
			RsvtService rsvtSvc = new RsvtService();
			RsvtVO rsvtVO = rsvtSvc.getOneRsvt(rsvtId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("rsvtVO", rsvtVO); // 資料庫取出的rsvtVO物件,存入req
			String url = "/back-end/reservation/update_rsvt_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_rsvt_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_rsvt_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			Integer rsvtId = Integer.valueOf(req.getParameter("rsvtId").trim());
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/

			String cName = req.getParameter("customerName");
			String cNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";
			if (cName == null || cName.trim().length() == 0) {
				errorMsgs.add("顧客姓名: 請勿空白");
			} else if (!cName.trim().matches(cNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("顧客姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到20之間");
			}

			String phoneReg = "^[0]{1}[9]{1}[0-9]{8}$";
			String cPhone = req.getParameter("customerPhone");
			if (cPhone == null || cPhone.trim().length() == 0) {
				errorMsgs.add("顧客手機: 請勿空白");
			} else if (!cPhone.trim().matches(phoneReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("手機請符合格式");
			}
			Integer rsvtNum = Integer.valueOf(req.getParameter("rsvtNum").trim());
			if (rsvtNum == null || rsvtNum == 0) {
				errorMsgs.add("訂位人數請勿空白");
			}

			Integer rsvtPeriod = null;
			rsvtPeriod = Integer.valueOf(req.getParameter("rsvtPeriod"));
			if (rsvtPeriod == null) {
				errorMsgs.add("請選擇時段！");
			}
			Integer rsvtToSeat = null;
			rsvtToSeat = Integer.valueOf(req.getParameter("rsvtToSeat"));
			java.sql.Date rsvtDate = null;
			try {
				rsvtDate = java.sql.Date.valueOf(req.getParameter("rsvtDate").trim());
			} catch (IllegalArgumentException e) {
				rsvtDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
			Timestamp rsvtMealDate = null;
			// 如果已入座 用餐日期時間自動導入
			if (rsvtToSeat == 0 && rsvtMealDate == null) {
				rsvtMealDate = new Timestamp(System.currentTimeMillis());
			} else if (rsvtToSeat == 1) {
				rsvtMealDate = null;
			}
			RsvtVO rsvtVO = new RsvtVO();
			rsvtVO.setCustomerName(cName);
			rsvtVO.setCustomerPhone(cPhone);
			rsvtVO.setRsvtNum(rsvtNum);
			rsvtVO.setRsvtPeriod(rsvtPeriod);
			rsvtVO.setRsvtToSeat(rsvtToSeat);
			rsvtVO.setRsvtDate(rsvtDate);
			rsvtVO.setRsvtMealDate(rsvtMealDate);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("rsvtVO", rsvtVO); // 含有輸入格式錯誤的rsvtVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/reservation/update_rsvt_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			RsvtService rsvtSvc = new RsvtService();
			rsvtVO = rsvtSvc.updateRsvt(cName, cPhone, rsvtNum, rsvtPeriod, rsvtToSeat, rsvtDate, rsvtMealDate, rsvtId);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("rsvtVO", rsvtVO); // 資料庫update成功後,正確的的rsvtVO物件,存入req
			String url = "/back-end/reservation/listOneRsvt.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneRsvt.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action))

		{ // 來自addRsvt.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String cName = req.getParameter("customerName");
			String rsvtIdReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";

			if (cName == null || cName.trim().length() == 0) {
				errorMsgs.add("顧客姓名: 請勿空白");
			} else if (!cName.trim().matches(rsvtIdReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("顧客姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到20之間");
			}

			String phoneReg = "^[0]{1}[9]{1}[0-9]{8}$";
			String cPhone = req.getParameter("customerPhone");
			if (cPhone == null || cPhone.trim().length() == 0) {
				errorMsgs.add("顧客手機: 請勿空白");
			} else if (!cPhone.trim().matches(phoneReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("手機請符合格式");
			}

			Integer rsvtNum = null;
			try {
				rsvtNum = Integer.valueOf(req.getParameter("rsvtNum").trim());
			} catch (NumberFormatException e) {
				rsvtNum = 0;
				errorMsgs.add("請填寫人數");
			}

			Integer rsvtPeriod = null;
			rsvtPeriod = Integer.valueOf(req.getParameter("rsvtPeriod").trim());
			if(rsvtPeriod == null) {
				errorMsgs.add("請選擇時段");				
			}

			java.sql.Date rsvtDate = null;
			try {
				rsvtDate = java.sql.Date.valueOf(req.getParameter("rsvtDate").trim());
			} catch (IllegalArgumentException e) {
				rsvtDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}
			RsvtVO rsvtVO = new RsvtVO();

			rsvtVO.setCustomerName(cName);
			rsvtVO.setCustomerPhone(cPhone);
			rsvtVO.setRsvtNum(rsvtNum);
			rsvtVO.setRsvtPeriod(rsvtPeriod);
			rsvtVO.setRsvtDate(rsvtDate);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("rsvtVO", rsvtVO); // 含有輸入格式錯誤的rsvtVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/reservation/addRsvt.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			RsvtService rsvtSvc = new RsvtService();
			rsvtVO = rsvtSvc.addRsvt(cName, cPhone, rsvtNum, rsvtPeriod, rsvtDate);
			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/reservation/listAllRsvt.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllRsvt.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllRsvt.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer rsvtId = Integer.valueOf(req.getParameter("rsvtId"));

			/*************************** 2.開始刪除資料 ***************************************/
			RsvtService rsvtSvc = new RsvtService();
			rsvtSvc.deleteRsvt(rsvtId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/reservation/listAllRsvt.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
