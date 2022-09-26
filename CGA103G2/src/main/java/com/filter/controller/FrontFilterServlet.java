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
 * 限制 
 * "/front-end/shopcart/*",
 * "/front-end/order/*"
 * 底下的頁面
 ****************************************/
@WebFilter(filterName = "FrontFilterServlet",
			servletNames = {"/FrontFilterServlet"},
			urlPatterns = {	"/front-end/shopcart/*",
							"/front-end/order/*"
						  }
)
public class FrontFilterServlet extends HttpFilter implements Filter {

	public FrontFilterServlet() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//設定編碼
		req.setCharacterEncoding("UTF-8");
		//讀取的網頁路徑
		String uri = req.getRequestURI();
//		System.out.println(uri);
		//判斷是否有登入,用session有無存入LoginSessionName判斷
		String getSessionID =	((HttpServletRequest) request).getRequestedSessionId();
		String LoginSessionName = (String) req.getSession().getAttribute("LoginSessionName");
		String LoginSessionID = (String) req.getSession().getAttribute("LoginSessionID");
		
//		測試登入狀態
		System.out.println("SessionID : " + getSessionID);
		System.out.println("登入狀態Session : " + LoginSessionName);
		
		//以下判斷,當結尾不是"members.jsp" 或是 "MemLoginServlet.do" 時 ,而且沒有取得Session登入狀態
		if( !(uri.endsWith("members.jsp") || uri.endsWith("MemLoginServlet.do")) && (LoginSessionName == null || (LoginSessionName.trim()).length() == 0)){
//			req.getRequestDispatcher("../../BackLogin.jsp").forward(request, response);
			//跳轉頁面至首頁
			
			//編碼設置
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;UTF-8");
			res.getWriter().println("<script>");
			res.getWriter().println("alert('請登入會員');");
			res.getWriter().println("window.location.href='../../front-end/member/members2.jsp'");
			res.getWriter().println("</script>");
//			write("<script>alert('添加成功！');location.href='Jump.aspx';</script>");
//			res.sendRedirect("../../front-end/member/members.jsp");
			return;
		}else{
			//回傳正常頁面
			chain.doFilter(request, response);
			return;
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	
	
//	====test====
	
	public static String getString(String LoginSessionName, String defaultValue) {
		defaultValue="";
		if(LoginSessionName == null || LoginSessionName.trim().equals("")) {
			return defaultValue;
		}
		else {
			return LoginSessionName;
		}
			
		}
	}




