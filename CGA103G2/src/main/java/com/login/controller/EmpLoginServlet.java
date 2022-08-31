package com.login.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.model.EmpLoginDAO;
import com.login.model.EmpLoginVO;

@WebServlet("/EmpLoginServlet.do")
public class EmpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		StringBuffer url = request.getRequestURL();
//		System.out.println("瀏覽器訪問的資源地址 : " + url);
		String method = request.getMethod();
//		System.out.println("瀏覽器訪問時採用的請求方式 : " + method);

		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
//			System.out.println("攜帶的請求參數 : " + paramName);
		}

		String empAccount = request.getParameter("empAccount");
		String empPassword = request.getParameter("empPassword");
		EmpLoginVO admin = new EmpLoginVO();
		admin.setEmpAccount(empAccount);
		admin.setEmpPassword(empPassword);
		EmpLoginDAO dao = new EmpLoginDAO();
		boolean res = dao.loginAdmin(admin);
		// 登入驗證，如果驗證成功，則設定一個屬性名為“LoginSessionName”值為使用者名稱的session，用於BackFilterServlet驗證是否登入過
		if (res) {
			request.getSession().setAttribute("LoginSessionName", empAccount);
			request.getRequestDispatcher("/back-end/index/BackIndex.jsp").forward(request, response);
//			System.out.println("執行1");
		} else {
			request.setAttribute("errorMessage", "wrong");
			request.getRequestDispatcher("/BackLogin.jsp").forward(request, response);
			request.getSession().setAttribute("error", "賬號或者密碼錯誤");
//			response.sendRedirect("login.jsp");
//			System.out.println("執行2");
		}
	}
}
