package com.rsvt.controller;

import java.io.IOException;
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
@WebServlet("/RsvtFEServlet")
public class RsvtForwardEndServlet extends HttpServlet{
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			doPost(req, res);
		}

		public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			req.setCharacterEncoding("UTF-8");
			String action = req.getParameter("action");
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
					RequestDispatcher failureView = req.getRequestDispatcher("/FrontIndex.jsp");
					failureView.forward(req, res);
					return;
				}

				/*************************** 2.開始新增資料 ***************************************/
				RsvtService rsvtSvc = new RsvtService();
				rsvtVO = rsvtSvc.addRsvt(cName, cPhone, rsvtNum, rsvtPeriod, rsvtDate);
				/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
				String url = "/back-end/reservation/listAllRsvt.jsp";
				RequestDispatcher successView = req.getRequestDispatcher("/FrontIndex.jsp"); // 新增成功後轉交listAllRsvt.jsp
				successView.forward(req, res);
			}

		}
}