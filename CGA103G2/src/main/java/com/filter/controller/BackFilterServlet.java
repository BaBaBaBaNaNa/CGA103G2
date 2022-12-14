package com.filter.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/****************************************
 * 限制 "/back-end/*" 底下的頁面
 ****************************************/
@WebFilter(	filterName = "BackFilterServlet",
			servletNames = {"/BackFilterServlet"},
			urlPatterns = {"/back-end/*"}
)
public class BackFilterServlet extends HttpFilter implements Filter {
	
//定義一個存放放行資源路徑的陣列
	private static String[] paths;

	public BackFilterServlet() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		//讀取的網頁路徑
		String uri = req.getRequestURI();
//		System.out.println(uri);
		//判斷是否有登入,用session有無存入LoginSessionName判斷
		String getSessionID =	((HttpServletRequest) request).getRequestedSessionId();
		String LoginSessionName = (String) req.getSession().getAttribute("LoginSessionName");
		String LoginSessionID = (String) req.getSession().getAttribute("LoginSessionID");
		
//		測試登入狀態
//		System.out.println("SessionID : " + getSessionID);
//		System.out.println("登入狀態Session : " + LoginSessionName);
		
		//以下判斷,當結尾不是"BackLogin.jsp" 或是 "EmpLoginServlet.do" 時 ,而且沒有取得Session登入狀態
		if( !(uri.endsWith("BackLogin.jsp") || uri.endsWith("EmpLoginServlet.do")) && (LoginSessionName == null || (LoginSessionName.trim()).length() == 0)){
//			req.getRequestDispatcher("../../BackLogin.jsp").forward(request, response);
			//跳轉頁面至後台登入頁面
			res.sendRedirect("../../BackLogin.jsp");
			return;
		}else{
			//回傳正常頁面
			chain.doFilter(request, response);
			return;
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
