package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.login.model.EmpLoginDAO;
import com.login.model.EmpLoginVO;

@WebServlet("/EmpLogoutServlet.do")
public class EmpLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpLogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//把LoginSessionName 的Session 清空,以作為登出方式
		request.getSession().setAttribute("LoginSessionName", null);
		request.setAttribute("errorMessage", "登出成功");
		System.out.println("登出成功!");
		request.getRequestDispatcher("/BackLogin.jsp").forward(request, response);
//		response.sendRedirect("BackLogin.jsp");
		return;
	}
}
