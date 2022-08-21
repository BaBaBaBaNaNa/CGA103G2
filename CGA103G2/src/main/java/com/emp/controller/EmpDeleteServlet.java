package com.emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.EmpJDBCDAO;
/* */
/**
 * Servlet implementation class deleteServlet
 */
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int emp_id=Integer.parseInt(request.getParameter("emp_id"));
		System.out.println("編號 : "+ emp_id);
		EmpJDBCDAO dao=new EmpJDBCDAO();
		
		dao.delete(emp_id);
		request.getRequestDispatcher("EmpShowServlet").forward(request, response);
		
//		boolean res=dao.deleteEmpolyeeById(emp_id);
//		if(res) {
//			request.getRequestDispatcher("showServlet").forward(request, response);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
