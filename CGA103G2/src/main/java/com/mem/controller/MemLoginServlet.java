package com.mem.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.MemDAO;
import com.mem.model.MemLoginVO;



@WebServlet("/MemLoginServlet.do")
public class MemLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		request.setCharacterEncoding("utf-8");
		StringBuffer url = request.getRequestURL();
		System.out.println("瀏覽器訪問的資源地址 : " + url);
		String method = request.getMethod();
		System.out.println("瀏覽器訪問時採用的請求方式 : " + method);

		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			System.out.println("攜帶的請求參數 : " + paramName);
		}

		String memAccount = request.getParameter("memAccount");
		String memPassword = request.getParameter("memPassword");
		MemLoginVO logger = new MemLoginVO();
		logger.setMemAccount(memAccount);
		logger.setMemPassword(memPassword);
		MemDAO dao = new MemDAO();
		boolean res = dao.loginAdmin(logger);

		if (res) {
			// ValidateLogin為登入驗證方法，如果驗證成功，則設定一個屬性名為“name”值為使用者名稱的session，用於Myfilter驗證是否登入過
			request.getSession().setAttribute("name", memAccount);
			request.getRequestDispatcher("/FrontIndex.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "wrong");
			request.getRequestDispatcher("/members.jsp").forward(request, response);
//				request.getSession().setAttribute("error", "賬號或者密碼錯誤");
//				response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
