package com.filter.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(filterName = "letgo",
//						urlPatterns = {"/back-end/*","/front-end/*"}
//)
public class BackFilterServlet implements Filter {	
//定義一個存放放行資源路徑的陣列
	private static String[] paths;

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 獲取資源URI路徑
		String path = request.getServletPath();
		for (int i = 0; i < paths.length; i++) {
			// 如果當前請求的URI路徑是要放行的資源中的一個，放行
			if (path.startsWith(paths[i])) {
				chain.doFilter(request, response);
				return;// 放行之後返回，避免程式繼續執行，往下面執行是攔截的程式碼
			}
		}
		System.out.println("1");
		// 判斷使用者是否已經登入，如果登入則放行資源，否則重定向到登入介面
		String name = (String) request.getSession().getAttribute("name");
		// 如果name為空，則證明使用者沒有登入過，跳轉到登入介面
		if (name == null) {
			request.getSession().setAttribute("error", "尚未登入，請登入");
			response.sendRedirect("../../BackLogin.jsp");
			return;
		}
		// 剩下的情況為已登入，放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

		String initParameter = fConfig.getInitParameter("letgo");
		paths = initParameter.split(";");
	}
}
