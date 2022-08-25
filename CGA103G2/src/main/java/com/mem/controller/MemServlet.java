package com.mem.controller;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.naming.java.javaURLContextFactory;

import com.emp.model.*;
import com.mem.model.MemDAO;
import com.mem.model.MemService;
import com.mem.model.MemVO;
import com.emp.controller.*;

public class MemServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=utf-8");
		String action = req.getParameter("action");

		// ----- ----- ----- getAll start ----- ----- -----
		if ("getAll".equals(action)) {
			/*************************** 開始查詢資料 ****************************************/
			MemDAO dao = new MemDAO();
			List<MemVO> list = dao.getAll();
			/*************************** 查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("list", list); // 資料庫取出的list物件,存入session
			// Send the Success view
			String url = "/back-end/member/member_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交listAllEmp2GetFromSession.jsp
			successView.forward(req, res);
			return;
		}
		// ----- ----- ----- getAll end ----- ----- -----

		// ----- ----- ----- getOne_For_Display start ----- ----- -----
		if ("getOne_For_Display".equals(action)) { // 來自selectPage.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("memId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入member編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/member/member_detail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			Integer memId = null;
			try {
				memId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("member編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end//member_detail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 2.開始查詢資料 *****************************************/
			MemService memSvc = new MemService();
			MemVO memVO = memSvc.getOneMem(memId);
			if (memVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/member/member_detail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("memVO", memVO); // 資料庫取出的memVO物件,存入req
			String url = "/front-end/member/listOneMem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- getOne_For_Display end ----- ----- -----

		// ----- ----- ----- insert start ----- ----- -----
		if ("insert".equals(action)) { // 來自memberAdd.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			// memName
			String memName = req.getParameter("memName");
			String memNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (memName == null || memName.trim().length() == 0) {
				errorMsgs.add("member姓名: 請勿空白");
			} else if (!memName.trim().matches(memNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("member姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String memAccount = req.getParameter("memAccount").trim();
			if (memAccount == null || memAccount.trim().length() == 0) {
				errorMsgs.add("帳號請勿空白");
			}
			String memPassword = req.getParameter("memPassword").trim();
			if (memPassword == null || memPassword.trim().length() == 0) {
				errorMsgs.add("密碼請勿空白");
			}

			String memGender = req.getParameter("memGender").trim();
			if (memGender == null || memGender.trim().length() == 0) {
				errorMsgs.add("權限請勿空白");
			}

			String memPermission = req.getParameter("memPermission").trim();
			if (memPermission == null || memPermission.trim().length() == 0) {
				errorMsgs.add("權限請勿空白");
			}

			String memPhone = req.getParameter("memPhone").trim();
			if (memPhone == null || memPhone.trim().length() == 0) {
				errorMsgs.add("電話請勿空白");
			}

			String memEmail = req.getParameter("memEmail").trim();
			if (memEmail == null || memEmail.trim().length() == 0) {
				errorMsgs.add("信箱請勿空白");
			}

			String memAddress = req.getParameter("memAddress").trim();
			if (memAddress == null || memAddress.trim().length() == 0) {
				errorMsgs.add("地址請勿空白");
			}

			java.sql.Date memBirthday = null;
			try {
				memBirthday = java.sql.Date.valueOf(req.getParameter("memBirthday").trim());
			} catch (IllegalArgumentException e) {
				memBirthday = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			MemVO memVO = new MemVO();

			memVO.setMemName(memName);
			memVO.setMemAccount(memAccount);
			memVO.setMemPassword(memPassword);
			memVO.setMemGender(Integer.parseInt(memGender));
			memVO.setMemPhone(memPhone);
			memVO.setMemEmail(memEmail);
			memVO.setMemAddress(memAddress);
			memVO.setMemBirthday(memBirthday);
			memVO.setMemPermission(Integer.parseInt(memPermission));
//					memVO.setMemBirthday(LocalDateTime.parse(memBirthdat));	

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/member/memberAdd.jsp");
				failureView.forward(req, res);
				return;
			}
			/*************************** 2.開始新增資料 ***************************************/
			MemService memSvc = new MemService();
			memVO = memSvc.addMem(memName, memAccount, memPassword, Integer.parseInt(memPermission),
					Integer.parseInt(memGender), memPhone, memAddress, memEmail, memBirthday);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/front-end/member/listAllMem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- insert end ----- ----- -----

		// ----- ----- ----- getOne_For_Update start ----- ----- -----
		if ("getOne_For_Update".equals(action)) { // 來自listAllMem.jsp的請求
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer memId = Integer.valueOf(req.getParameter("memId"));

			/*************************** 2.開始查詢資料 ****************************************/
			MemService memSvc = new MemService();
			MemVO memVO = memSvc.getOneMem(memId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
			String url = "/front-end/member/member_edit.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_mem_input.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- getOne_For_Update end ----- ----- -----

		// ----- ----- ----- update start ----- ----- -----
		if ("update".equals(action)) { // 來自update_mem_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer memId = Integer.valueOf(req.getParameter("memId").trim());

			// mem_name
			String memName = req.getParameter("memName");
			String memNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (memName == null || memName.trim().length() == 0) {
				errorMsgs.add("員工姓名: 請勿空白");
			} else if (!memName.trim().matches(memNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String memAccount = req.getParameter("memAccount").trim();
			if (memAccount == null || memAccount.trim().length() == 0) {
				errorMsgs.add("帳號請勿空白");
			}
			String memPassword = req.getParameter("memPassword").trim();
			if (memPassword == null || memPassword.trim().length() == 0) {
				errorMsgs.add("密碼請勿空白");
			}



			String memPermission = req.getParameter("memPermission").trim();
			if (memPermission == null || memPermission.trim().length() == 0) {
				errorMsgs.add("權限請勿空白");
			}

			String memPhone = req.getParameter("memPhone").trim();
			if (memPhone == null || memPhone.trim().length() == 0) {
				errorMsgs.add("電話請勿空白");
			}

			String memEmail = req.getParameter("memEmail").trim();
			if (memEmail == null || memEmail.trim().length() == 0) {
				errorMsgs.add("信箱請勿空白");
			}

			String memAddress = req.getParameter("memAddress").trim();
			if (memAddress == null || memAddress.trim().length() == 0) {
				errorMsgs.add("地址請勿空白");
			}

			java.sql.Date memBirthday = null;
			try {
				memBirthday = java.sql.Date.valueOf(req.getParameter("memBirthday").trim());
			} catch (IllegalArgumentException e) {
				memBirthday = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入日期!");
			}

			MemVO memVO = new MemVO();

			memVO.setMemId(memId);
			memVO.setMemName(memName);
			memVO.setMemAccount(memAccount);
			memVO.setMemPassword(memPassword);
			
			memVO.setMemPhone(memPhone);
			memVO.setMemEmail(memEmail);
			memVO.setMemAddress(memAddress);
			memVO.setMemBirthday(memBirthday);
			memVO.setMemPermission(Integer.parseInt(memPermission));

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("memVO", memVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/member/memberEdit.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}
			/*************************** 2.開始修改資料 *****************************************/
			MemService memSvc = new MemService();
			memVO = memSvc.updateMem(memId, memName, memAccount, memPassword, Integer.parseInt(memPermission),
					 memPhone, memAddress, memEmail, memBirthday);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("memVO", memVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/front-end/member/update_member_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- update end ----- ----- -----
		// ----- ----- ----- delete start ----- ----- -----
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer memID = Integer.valueOf(req.getParameter("memId"));

			/*************************** 2.開始刪除資料 ***************************************/
			MemService memSvc = new MemService();
			memSvc.deleteMem(memID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/front-end/member/listAllMem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
		// ----- ----- ----- delete end ----- ----- -----

	}
}