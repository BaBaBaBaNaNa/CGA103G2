package com.emp.controller;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.naming.java.javaURLContextFactory;

import com.emp.model.*;
import com.emp.controller.*;

@WebServlet("/back-end/employee/EmpServlet2")
public class EmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// ----- ----- ----- getAll start ----- ----- -----
//		if ("getAll".equals(action)) {
//			/*************************** 開始查詢資料 ****************************************/
//			EmpDAO dao = new EmpDAO();
//			List<EmpVO> list = dao.getAll();
//
//			/*************************** 查詢完成,準備轉交(Send the Success view) *************/
//			HttpSession session = req.getSession();
//			session.setAttribute("list", list); // 資料庫取出的list物件,存入session
//			// Send the Success view
//			String url = "/back-end/employee/employee_detail.jsp";
//			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交listAllEmp2_getFromSession.jsp
//			successView.forward(req, res);
//			return;
//		}
		// ----- ----- ----- getAll end ----- ----- -----

		// ----- ----- ----- getOne_For_Display start ----- ----- -----
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("emp_id");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("emp_id","請輸入員工編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/employee_detail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer emp_id = null;
			try {
				emp_id = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("emp_id","員工編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/employee_detail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(emp_id);
			if (empVO == null) {
				errorMsgs.put("emp_id","查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/employee_detail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/employee/employee_detail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
			successView.forward(req, res);
		}

		// ----- ----- ----- getOne_For_Display end ----- ----- -----

		// ----- ----- ----- insert start ----- ----- -----

		if ("insert".equals(action)) { 
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String emp_name = req.getParameter("emp_name");
			String emp_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (emp_name == null || emp_name.trim().length() == 0) {
				errorMsgs.put("emp_name","員工姓名請勿空白");
			} else if (!emp_name.trim().matches(emp_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("emp_name","員工姓名只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String emp_account = req.getParameter("emp_account").trim();
			if (emp_account == null || emp_account.trim().length() == 0) {
				errorMsgs.put("emp_account","  帳號請勿空白");
			}

			String emp_password = req.getParameter("emp_password").trim();
			if (emp_password == null || emp_password.trim().length() == 0) {
				errorMsgs.put("emp_password","  密碼請勿空白");
			}
			
			Integer emp_permission = null;
			try {
				emp_permission = Integer.valueOf(req.getParameter("emp_permission").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("emp_permission","  權限請勿空白");
			}

			String emp_phone = req.getParameter("emp_phone").trim();
			if (emp_phone == null || emp_phone.trim().length() == 0) {
				errorMsgs.put("emp_phone","  電話請勿空白");
			}

			String emp_address = req.getParameter("emp_address").trim();
			if (emp_address == null || emp_address.trim().length() == 0) {
				errorMsgs.put("emp_address","  地址請勿空白");
			}
			
			Integer emp_job = null;
			try {
				emp_job = Integer.valueOf(req.getParameter("emp_job").trim());
			} catch (NumberFormatException e) {
				errorMsgs.put("emp_job","  職位請勿空白");
			}
			
			java.sql.Date emp_hiredate = null;
			try {
				emp_hiredate = java.sql.Date.valueOf(req.getParameter("emp_hiredate").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("emp_hiredate","  請輸入日期");
			}

			EmpVO empVO = new EmpVO();
			empVO.setEmp_name(emp_name);
			empVO.setEmp_account(emp_account);
			empVO.setEmp_password(emp_password);
			empVO.setEmp_permission(emp_permission);
			empVO.setEmp_phone(emp_phone);
			empVO.setEmp_address(emp_address);
			empVO.setEmp_job(emp_job);
			empVO.setEmp_hiredate(emp_hiredate);
//			empVO.setEmp_hiredate(LocalDateTime.parse(emp_hiredate));

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/employee_add.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			EmpService empSvc = new EmpService();
			empSvc.addEmp(emp_name, emp_account, emp_password, emp_permission, emp_phone, emp_address, emp_job, emp_hiredate);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("empVO", empVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/employee/employee_addsuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- insert end ----- ----- -----

		// ----- ----- ----- getOne_For_Update start ----- ----- -----
		if ("getOne_For_Update".equals(action)) { // 來自employee_detail.jsp的請求
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 ****************************************/
			Integer emp_id = Integer.valueOf(req.getParameter("emp_id"));

			/*************************** 2.開始查詢資料 ****************************************/
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(emp_id);
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			String param = 	"?emp_id="  +empVO.getEmp_id()+
				       						"&emp_name="  +empVO.getEmp_name()+
				       						"&emp_account="  +empVO.getEmp_account()+
				     				        "&emp_password="  +empVO.getEmp_password()+
				    				        "&emp_permission="  +empVO.getEmp_permission()+
				    				        "&emp_phone="  +empVO.getEmp_phone()+
				    				        "&emp_address="  +empVO.getEmp_address()+
				    				        "&emp_job="  +empVO.getEmp_job()+
				    				        "&emp_hiredate="  +empVO.getEmp_hiredate();
			String url = "/back-end/employee/employee_edit.jsp"+param;
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- getOne_For_Update end ----- ----- -----

		// ----- ----- ----- update start ----- ----- -----
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer emp_id = Integer.valueOf(req.getParameter("emp_id").trim());

			String emp_name = req.getParameter("emp_name");
			String emp_nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (emp_name == null || emp_name.trim().length() == 0) {
				errorMsgs.put("emp_name","員工姓名請勿空白");
			} else if (!emp_name.trim().matches(emp_nameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("emp_name","員工姓名只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}

			String emp_account = req.getParameter("emp_account").trim();
			if (emp_account == null || emp_account.trim().length() == 0) {
				errorMsgs.put("emp_account","  帳號請勿空白");
			}

			String emp_password = req.getParameter("emp_password").trim();
			if (emp_password == null || emp_password.trim().length() == 0 ) {
				errorMsgs.put("emp_password","  密碼請勿空白");
			}

			String emp_permission = req.getParameter("emp_permission").trim();
			if (emp_permission == null || emp_permission.trim().length() == 0 ) {
				errorMsgs.put("emp_permission","  權限請勿空白");
			}

			String emp_phone = req.getParameter("emp_phone").trim();
			if (emp_phone == null || emp_phone.trim().length() == 0 ) {
				errorMsgs.put("emp_phone","  電話請勿空白");
			}

			String emp_address = req.getParameter("emp_address").trim();
			if (emp_address == null || emp_address.trim().length() == 0) {
				errorMsgs.put("emp_address","  地址請勿空白");
			}

			String emp_job = req.getParameter("emp_job").trim();
			if (emp_job == null || emp_job.trim().length() == 0 ) {
				errorMsgs.put("emp_job","  職位請勿空白");
			}

			java.sql.Date emp_hiredate = null;
			try {
				emp_hiredate = java.sql.Date.valueOf(req.getParameter("emp_hiredate").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("emp_hiredate","  請輸入日期");
			}

			EmpVO empVO = new EmpVO();
			empVO.setEmp_id(emp_id);
			empVO.setEmp_name(emp_name);
			empVO.setEmp_account(emp_account);
			empVO.setEmp_password(emp_password);
			empVO.setEmp_permission(Integer.parseInt(emp_permission));
			empVO.setEmp_phone(emp_phone);
			empVO.setEmp_address(emp_address);
			empVO.setEmp_job(Integer.parseInt(emp_job));
			empVO.setEmp_hiredate(emp_hiredate);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/employee_edit.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			EmpService empSvc = new EmpService();
			empVO = empSvc.updateEmp(emp_id, emp_name, emp_account, emp_password, Integer.parseInt(emp_permission), emp_phone, emp_address, Integer.parseInt(emp_job), emp_hiredate);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("empVO", empVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/employee/employee_editsuccess.jsp";
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
			Integer emp_id = Integer.valueOf(req.getParameter("emp_id"));

			/*************************** 2.開始刪除資料 ***************************************/
			EmpService empSvc = new EmpService();
			empSvc.deleteEmp(emp_id);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/employee/employee_deletesuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
		// ----- ----- ----- delete end ----- ----- -----
	}
}