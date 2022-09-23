package com.emp.controller;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.naming.java.javaURLContextFactory;

import com.emp.model.*;
import com.job.model.JobDAO;
import com.job.model.JobService;
import com.job.model.JobVO;
import com.emp.controller.*;

@WebServlet("/back-end/employee/EmpServlet.do")
public class EmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		// ----- ----- ----- getAll start ----- ----- -----
		if ("getAll".equals(action)) {
			/*************************** 開始查詢資料 ****************************************/
		    EmpDAO dao = new EmpDAO();
			List<EmpVO> list = dao.getAll();
			/*************************** 查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			session.setAttribute("list", list); // 資料庫取出的list物件,存入session
			// Send the Success view
			String url = "/back-end/employee/empDetail.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
			return;
		}
		// ----- ----- ----- getAll end ----- ----- -----

		// ----- ----- ----- getOne_For_Display start ----- ----- -----
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("empID");
			//--- 判斷輸入是否是空值 ---
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("empID","請輸入員工編號");  
			}
			
			//--- 當有錯誤資訊時 ---
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/empDetail.jsp");
				failureView.forward(req, res);
				return;
			}

			Integer empID = null;
			try {
				empID = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.put("empID","員工編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/empDetail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(empID);
			if (empVO == null) {
				errorMsgs.put("empID","查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/empDetail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/employee/empDetailOne.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}

		// ----- ----- ----- getOne_For_Display end ----- ----- -----

		// ----- ----- ----- insert start ----- ----- -----

		if ("insert".equals(action)) { 
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
 
			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			//--- 員工姓名 ---
			String empName = req.getParameter("empName");
//			String empNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";
			String empNameReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9)]{2,20}$";
			if (empName == null || empName.trim().length() == 0) {
				errorMsgs.put("empName","員工姓名請勿空白");
			} else if (!empName.trim().matches(empNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("empName","員工姓名只能是中、英文字母、數字 , 且長度必需在2到20之間");
			}

			//--- 帳號 ---
			String empAccount = req.getParameter("empAccount").trim();
			String empAccountReg = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
			//----- 此段去查詢資料庫是否有重複的empAccount員工帳號資料 start-----
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getEmpAccountCheck(empAccount); 
			//----- 此段去查詢資料庫是否有重複的empAccount員工帳號資料 end -----
			if (empAccount == null || empAccount.trim().length() == 0) {
				errorMsgs.put("empAccount","  帳號請勿空白");
			} else if (!empAccount.trim().matches(empAccountReg)) {
				errorMsgs.put("empAccount","  帳號只能是 examle@gmail.com 信箱形式");
			}else if(empVO != null) {
				errorMsgs.put("empAccount","  帳號重複,請重新輸入");
			}

			//--- 密碼 ---
			String empPassword = req.getParameter("empPassword").trim();
			String empPasswordReg = "^[(a-zA-Z0-9)]{6,30}$";
			if (empPassword == null || empPassword.trim().length() == 0) {
				errorMsgs.put("empPassword","  密碼請勿空白");
			} else if (!empPassword.trim().matches(empPasswordReg)) {
			errorMsgs.put("empPassword","  帳號只能是英文字母、數字 , 且長度必需在6到30之間");
			}

			//權限:0 正常 1 停權
			Integer empPermission = Integer.valueOf(req.getParameter("empPermission").trim());
			
			//員工電話
			String empPhone = req.getParameter("empPhone").trim();
			String empPhoneReg = "^[(0-9)]{9,20}$";
			if (empPhone == null || empPhone.trim().length() == 0) {
				errorMsgs.put("empPhone","  電話請勿空白");
			} else if (!empPhone.trim().matches(empPhoneReg)) {
			errorMsgs.put("empPhone","  電話只能是數字 , 且長度必需在9到20之間");
			}
			
			//地址
			String empAddress = req.getParameter("empAddress").trim();
			String empAddressReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9)]{1,100}$";
			if (empAddress == null || empAddress.trim().length() == 0) {
				errorMsgs.put("empAddress","  地址請勿空白");
			}else if (!empAddress.trim().matches(empAddressReg)) {
			errorMsgs.put("empAddress","  地址只能是中、英文字母、數字 , 且長度必需在1到100之間");
			}
			
			//職位
			Integer jobID = Integer.valueOf(req.getParameter("jobID").trim());
			
			//入職日
			java.sql.Date empHiredate = null;
			try {
				empHiredate = java.sql.Date.valueOf(req.getParameter("empHiredate").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("empHiredate","  請輸入日期");
			}

			empVO = new EmpVO();
			empVO.setEmpName(empName);
			empVO.setEmpAccount(empAccount);
			empVO.setEmpPassword(empPassword);
			empVO.setEmpPermission(empPermission);
			empVO.setEmpPhone(empPhone);
			empVO.setEmpAddress(empAddress);
			empVO.setJobID(jobID);
			empVO.setEmpHiredate(empHiredate);
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/empAdd.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			empSvc = new EmpService();
			empSvc.addEmp(empName, empAccount, empPassword, empPermission, empPhone, empAddress, jobID, empHiredate);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			req.setAttribute("empVO", empVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/employee/empAddSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- insert end ----- ----- -----

		// ----- ----- ----- getOne_For_Update start ----- ----- -----
		if ("getOne_For_Update".equals(action)) { // 來自employee_detail.jsp的請求
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);
			/*************************** 1.接收請求參數 ****************************************/
			Integer empID = Integer.valueOf(req.getParameter("empID"));
			/*************************** 2.開始查詢資料 ****************************************/
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOneEmp(empID);
			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			HttpSession session = req.getSession();
			String param = 	"?empID="  +empVO.getEmpID()+
				       						"&empName="  +empVO.getEmpName()+
				       						"&empAccount="  +empVO.getEmpAccount()+
				     				        "&empPassword="  +empVO.getEmpPassword()+
				    				        "&empPermission="  +empVO.getEmpPermission()+
				    				        "&empPhone="  +empVO.getEmpPhone()+
				    				        "&empAddress="  +empVO.getEmpAddress()+
				    				        "&jobID="  +empVO.getJobID()+
				    				        "&empHiredate="  +empVO.getEmpHiredate();
			String url = "/back-end/employee/empEdit.jsp"+param;
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
		// ----- ----- ----- getOne_For_Update end ----- ----- -----

		// ----- ----- ----- update start ----- ----- -----
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer empID = Integer.valueOf(req.getParameter("empID").trim());

			//--- 員工姓名 ---
			String empName = req.getParameter("empName");
//			String empNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,20}$";
			String empNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9)]{2,20}$";
			if (empName == null || empName.trim().length() == 0) {
				errorMsgs.put("empName","員工姓名請勿空白");
			} else if (!empName.trim().matches(empNameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.put("empName","員工姓名只能是中、英文字母、數字 , 且長度必需在2到20之間");
			}

			//--- 帳號 ---
			String empAccount = req.getParameter("empAccount").trim();

			//--- 密碼 ---
			String empPassword = req.getParameter("empPassword").trim();
			String empPasswordReg = "^[(a-zA-Z0-9)]{6,30}$";
			if (empPassword == null || empPassword.trim().length() == 0) {
				errorMsgs.put("empPassword","  密碼請勿空白");
			} else if (!empPassword.trim().matches(empPasswordReg)) {
			errorMsgs.put("empPassword","  帳號只能是英文字母、數字 , 且長度必需在6到30之間");
			}

			//--- 權限:0 正常 1 停權 ---
			Integer empPermission = Integer.valueOf(req.getParameter("empPermission").trim());

			//--- 員工電話 ---
			String empPhone = req.getParameter("empPhone").trim();
			String empPhoneReg = "^[(0-9)]{9,20}$";
			if (empPhone == null || empPhone.trim().length() == 0) {
				errorMsgs.put("empPhone","  電話請勿空白");
			} else if (!empPhone.trim().matches(empPhoneReg)) {
			errorMsgs.put("empPhone","  電話只能是數字 , 且長度必需在9到20之間");
			}
			
			//--- 地址 ---
			String empAddress = req.getParameter("empAddress").trim();
			String empAddressReg = "^[(\\u4e00-\\u9fa5)(a-zA-Z0-9)]{1,100}$";
			if (empAddress == null || empAddress.trim().length() == 0) {
				errorMsgs.put("empAddress","  地址請勿空白");
			}else if (!empAddress.trim().matches(empAddressReg)) {
			errorMsgs.put("empAddress","  地址只能是中、英文字母、數字 , 且長度必需在1到100之間");
			}
			
			//--- 職位 ---
			Integer jobID = Integer.valueOf(req.getParameter("jobID").trim());
			
			//--- 入職日 ---
			java.sql.Date empHiredate = null;
			try {
				empHiredate = java.sql.Date.valueOf(req.getParameter("empHiredate").trim());
			} catch (IllegalArgumentException e) {
				errorMsgs.put("empHiredate","  請輸入日期");
			}

			EmpVO empVO = new EmpVO();
			empVO.setEmpID(empID);
			empVO.setEmpName(empName);
			empVO.setEmpAccount(empAccount);
			empVO.setEmpPassword(empPassword);
			empVO.setEmpPermission(empPermission);
			empVO.setEmpPhone(empPhone);
			empVO.setEmpAddress(empAddress);
			empVO.setJobID(jobID);
			empVO.setEmpHiredate(empHiredate);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("empVO", empVO); // 含有輸入格式錯誤的empVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/empEdit.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			EmpService empSvc = new EmpService();
			empVO = empSvc.updateEmp(empID, empName, empAccount, empPassword, empPermission, empPhone, empAddress, jobID, empHiredate);
			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			req.setAttribute("empVO", empVO); // 資料庫update成功後,正確的的empVO物件,存入req
			String url = "/back-end/employee/empEditSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
			successView.forward(req, res);
		}
		// ----- ----- ----- update end ----- ----- -----

		// ----- ----- ----- delete start ----- ----- -----
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer empID = Integer.valueOf(req.getParameter("empID"));

			/*************************** 2.開始刪除資料 ***************************************/
			EmpService empSvc = new EmpService();
			empSvc.deleteEmp(empID);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/back-end/employee/empDeleteSuccess.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}
		// ----- ----- ----- delete end ----- ----- -----
		
		// ----- ----- ----- getEmpCompositeQuery start ----- ----- -----
		if ("getEmpListCompositeQuery".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				
				/***************************1.將輸入資料轉為Map**********************************/ 
				//採用Map<String,String[]> getParameterMap()的方法 
				//注意:an immutable java.util.Map 
			HttpSession session = req.getSession();
			Map<String, String[]> map = (Map<String, String[]>)session.getAttribute("map");
			
			// 以下的 if 區塊只對第一次執行時有效
			if (req.getParameter("whichPage") == null){
				Map<String, String[]> map1 = new HashMap<String, String[]>(req.getParameterMap());
				session.setAttribute("map",map1);
				map = map1;
			} 
				
				/***************************2.開始複合查詢***************************************/
				EmpService empSvc = new EmpService();
				List<EmpVO> list  = empSvc.getAll(map);
				
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("getEmpListCompositeQuery", list); // 資料庫取出的list物件,存入request
				RequestDispatcher successView = req.getRequestDispatcher("/back-end/employee/empDetailCQ.jsp"); // 成功轉交listEmps_ByCompositeQuery.jsp
				successView.forward(req, res);
		}
		// ----- ----- ----- getEmpListCompositeQuery end ----- ----- -----
		
		// ----- ----- ----- getEmpPersonalData start ----- ----- -----
		if ("getEmpPersonalData".equals(action)) { // 來自select_page.jsp的請求

			Map<String,String> errorMsgs = new LinkedHashMap<String,String>();
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str =  (String) req.getSession().getAttribute("LoginSessionName");
			
			System.out.println(req.getSession().getAttribute("LoginSessionName"));
			
			//--- 判斷輸入是否是空值 ---
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.put("empID","請輸入員工編號");  
			}
			
			//--- 當有錯誤資訊時 ---
			if (!errorMsgs.isEmpty()) {
				System.out.println("0");
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/empDetail.jsp");
				failureView.forward(req, res);
				return;
			}

			String empAccount = null;
			try {
				empAccount = str;
			} catch (Exception e) {
				errorMsgs.put("empAccount","帳號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				System.out.println("1");
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/empDetail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			EmpService empSvc = new EmpService();
			EmpVO empVO = empSvc.getOwnEmp(empAccount);
			if (empVO == null) {
				errorMsgs.put("empID","查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				System.out.println("2");
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/employee/empDetail.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}
			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			HttpSession session = req.getSession();
			req.setAttribute("empVO", empVO); // 資料庫取出的empVO物件,存入req
			String url = "/back-end/employee/empDetailOwn.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); 
			successView.forward(req, res);
		}
		// ----- ----- ----- getEmpPersonalData end ----- ----- -----
	}
}