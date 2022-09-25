package com.mem.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mem.model.MemDAO;
import com.mem.model.MemService;
import com.mem.model.MemVO;
import com.mysql.cj.Session;

//@WebServlet("/MemLoginServlet.do")
public class MemLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();

		StringBuffer url = request.getRequestURL();
		System.out.println("瀏覽器訪問的資源地址 : " + url);
		String method = request.getMethod();
		System.out.println("瀏覽器訪問時採用的請求方式 : " + method);

		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			System.out.println("攜帶的請求參數 : " + paramName);
		}
//		MemService memberSvc = new MemService();

		String memAccount = request.getParameter("memAccount");
//		MemVO user1 = memberSvc.getOwnMem(memAccount);
		String memId = request.getParameter("memId");
		String memPassword = request.getParameter("memPassword");
		MemVO admin = new MemVO();
		admin.setMemAccount(memAccount);
		admin.setMemPassword(memPassword);
		MemDAO dao = new MemDAO();
		boolean res = dao.loginAdmin(admin);
		boolean resPer = dao.loginAdminPermission(admin);
		MemVO test = dao.findByMemAccount(memAccount);
		// 登入驗證，如果驗證成功，則設定一個屬性名為“LoginSessionName”值為使用者名稱的session，用於FrontBackFilterServlet驗證是否登入過
		// 驗證的話還是會用SessionId去做驗證
		if ((res) && (resPer)) {
			request.getSession().setAttribute("LoginSessionName", memAccount);
			request.getSession().setAttribute("LoginSessionName1", memId);
			request.getRequestDispatcher("../../FrontIndex.jsp").forward(request, response);
			session.setAttribute("memID",test.getMemID()); 
			//測試登入狀態
			System.out.println("SessionId : "+request.getRequestedSessionId());
			System.out.println("登入成功!");
			System.out.println(request.getSession().getAttribute("memID"));

			return;
		}
		else if(!(res)){
			request.setAttribute("errorMessage", "帳號或者密碼錯誤");
			request.getRequestDispatcher("/front-end/member/members2.jsp").forward(request, response);
			
			return;

		}
		else if(!(resPer)) {
			request.setAttribute("errorMessage", "帳號已停權,詳情請洽管理員");
			request.getRequestDispatcher("/front-end/member/members2.jsp").forward(request, response);
			return;
		}
	}
}











//=======================OLD_version start ===========================



//package com.mem.controller;
//
//import java.io.IOException;
//import java.util.Enumeration;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.mem.model.MemDAO;
//import com.mem.model.MemLoginVO;
//
//
//
//@WebServlet("/MemLoginServlet.do")
//public class MemLoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public MemLoginServlet() {
//		super();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html; charset=utf-8");
//
//		request.setCharacterEncoding("utf-8");
//		StringBuffer url = request.getRequestURL();
//		System.out.println("瀏覽器訪問的資源地址 : " + url);
//		String method = request.getMethod();
//		System.out.println("瀏覽器訪問時採用的請求方式 : " + method);
//
//		Enumeration paramNames = request.getParameterNames();
//		while (paramNames.hasMoreElements()) {
//			String paramName = (String) paramNames.nextElement();
//			System.out.println("攜帶的請求參數 : " + paramName);
//		}
//
//		String memAccount = request.getParameter("memAccount");
//		String memPassword = request.getParameter("memPassword");
//		MemLoginVO logger = new MemLoginVO();
//		logger.setMemAccount(memAccount);
//		logger.setMemPassword(memPassword);
//		MemDAO dao = new MemDAO();
//		boolean res = dao.loginAdmin(logger);
//
//		if (res) {
//			// ValidateLogin為登入驗證方法，如果驗證成功，則設定一個屬性名為“name”值為使用者名稱的session，用於Myfilter驗證是否登入過
//			request.getSession().setAttribute("name", memAccount);
//			request.getRequestDispatcher("/FrontIndex.jsp").forward(request, response);
//		} else {
//			request.setAttribute("errorMessage", "wrong");
//			request.getRequestDispatcher("/front-end/member/members.jsp").forward(request, response);
////				request.getSession().setAttribute("error", "賬號或者密碼錯誤");
////				response.sendRedirect("login.jsp");
//		}
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}

//=======================OLD_version stop===========================
