package com.rsvtCtrl.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rsvtCtrl.model.RsvtCtrlService;
import com.rsvtCtrl.model.RsvtCtrlVO;


@WebServlet("/back-end/reservation_ctrl/RsvtCtrlServlet")
public class RsvtCtrlServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer rsvtCtrlId = null;
			try {
				rsvtCtrlId = Integer.valueOf(req.getParameter("rsvtCtrlId").trim());
			} catch (Exception e) {
				errorMsgs.add("Id不可以為空");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/back-end/reservation_ctrl/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
			RsvtCtrlVO rsvtCtrlVO = rsvtCtrlSvc.getOneRsvtCtrl(rsvtCtrlId);
			if (rsvtCtrlVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/reservation/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("rsvtCtrlVO", rsvtCtrlVO); // 資料庫取出的rsvtCtrlVO物件,存入req

			String url = "/back-end/reservation_ctrl/listOneRsvtCtrl.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneRsvt.jsp
			successView.forward(req, res);
		}

		if ("getOne_For_Update".equals(action)) { // 來自listAllRsvtCtrl.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer rsvtCtrlId = Integer.valueOf(req.getParameter("rsvtCtrlId"));
			/*************************** 2.開始查詢資料 ****************************************/
			RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
			RsvtCtrlVO rsvtCtrlVO = rsvtCtrlSvc.getOneRsvtCtrl(rsvtCtrlId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("rsvtCtrlVO", rsvtCtrlVO); // 資料庫取出的rsvtCtrlVO物件,存入req
			String url = "/back-end/reservation_ctrl/reservationCtrl_edit.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_rsvtCtrl_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_rsvt_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			Integer rsvtCtrlId = Integer.valueOf(req.getParameter("rsvtCtrlId").trim());
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer tbtId = null;
			tbtId = Integer.valueOf(req.getParameter("tableTypeId").trim());
			if (tbtId == null) {
				errorMsgs.add("桌型: 請勿為空");
			}
			Integer rsvtCtrlOpen = Integer.valueOf(req.getParameter("rsvtCtrlOpen").trim());
			Integer rsvtCtrlMax = null;
			Integer rsvtCtrlPeriod = Integer.valueOf(req.getParameter("rsvtCtrlPeriod").trim());
			Date date = null;
			try {
				date = Date.valueOf(req.getParameter("rsvtCtrlDate"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				rsvtCtrlMax = Integer.valueOf(req.getParameter("rsvtCtrlMax").trim());

			} catch (Exception e) {
				errorMsgs.add("當日上限請勿為空或非數字字元！");
				
			}
			// 當預訂桌數達到上限 訂位設成不開放
			RsvtCtrlVO rsvtCtrlVO = new RsvtCtrlVO();
			rsvtCtrlVO.setRsvtCtrlDate(date);
			rsvtCtrlVO.setRsvtCtrlId(rsvtCtrlId);
			rsvtCtrlVO.setTableTypeId(tbtId);
			rsvtCtrlVO.setRsvtCtrlOpen(rsvtCtrlOpen);
			rsvtCtrlVO.setRsvtCtrlPeriod(rsvtCtrlPeriod);
			rsvtCtrlVO.setRsvtCtrlMax(rsvtCtrlMax);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("rsvtCtrlVO", rsvtCtrlVO); // 含有輸入格式錯誤的rsvtCtrlVO物件,也存入req
				RequestDispatcher failureView = req
						.getRequestDispatcher("/back-end/reservation_ctrl/reservationCtrl_edit.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
			rsvtCtrlVO = rsvtCtrlSvc.updateRsvtCtrl(tbtId, rsvtCtrlOpen, rsvtCtrlMax, rsvtCtrlId);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("rsvtCtrlVO", rsvtCtrlVO); // 資料庫update成功後,正確的的rsvtCtrlVO物件,存入req
			String url = "/back-end/reservation_ctrl/reservationCtrl_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneRsvt.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action))

		{ // 來自addRsvtCtrl.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer rsvtCtrlOpen = Integer.valueOf(req.getParameter("rsvtCtrlOpen").trim());

			java.sql.Date rsvtCtrlDate = null;
			try {
				rsvtCtrlDate = java.sql.Date.valueOf(req.getParameter("rsvtCtrlDate").trim());
			} catch (IllegalArgumentException e) {
				rsvtCtrlDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			Integer rsvtCtrlPeriod = null;
			try {
				rsvtCtrlPeriod = Integer.valueOf(req.getParameter("rsvtCtrlPeriod").trim());
				if (rsvtCtrlPeriod > 1 || rsvtCtrlPeriod < 0) {
					errorMsgs.add("請設定時段！");
				}
			} catch (Exception e) {
				errorMsgs.add("請設定時段！");
			}
			Integer rsvtCtrlMax = null;
			try {
				rsvtCtrlMax = Integer.valueOf(req.getParameter("rsvtCtrlMax").trim());
				if (rsvtCtrlMax == 0) {
					errorMsgs.add("請設定上限！");
				}
			} catch (Exception e) {
				errorMsgs.add("請設定上限！");
			}

			RsvtCtrlVO rsvtCtrlVO = new RsvtCtrlVO();
			rsvtCtrlVO.setRsvtCtrlOpen(rsvtCtrlOpen);
			rsvtCtrlVO.setRsvtCtrlPeriod(rsvtCtrlPeriod);
			rsvtCtrlVO.setRsvtCtrlDate(rsvtCtrlDate);
			rsvtCtrlVO.setRsvtCtrlMax(rsvtCtrlMax);
			RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
//			try {
//				if (rsvtCtrlPeriod == rsvtCtrlSvc.getOneDate(rsvtCtrlDate.toString()).getRsvtCtrlPeriod()) {
//					errorMsgs.add("此時段已被設定");
//				}
//			} catch (Exception ignore) {
//			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("rsvtCtrlVO", rsvtCtrlVO); // 含有輸入格式錯誤的rsvtCtrlVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/reservation_ctrl/addRsvtCtrl.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			/*************************** 2.開始新增資料 *****************************************/
			rsvtCtrlVO = rsvtCtrlSvc.addRsvtCtrl(rsvtCtrlOpen, rsvtCtrlDate, rsvtCtrlPeriod, rsvtCtrlMax);

			/*************************** 3.新增完成,準備轉交(Send the Success view) *************/
			req.setAttribute("rsvtCtrlVO", rsvtCtrlVO); // 資料庫update成功後,正確的的rsvtCtrlVO物件,存入req
			String url = "/back-end/reservation_ctrl/listOneRsvtCtrl.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneRsvt.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllRsvtCtrl.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer rsvtCtrlId = Integer.valueOf(req.getParameter("rsvtCtrlId"));

			/*************************** 2.開始刪除資料 ***************************************/
			RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
			rsvtCtrlSvc.deleteRsvtCtrl(rsvtCtrlId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/reservation_ctrl/reservationCtrl_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
	}
}
