package com.emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.EmpJDBCDAO;
import com.emp.model.EmpVO;
/* */
/**
 * Servlet implementation class addServlet
 */
public class EmpAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpAddServlet() {
        super();
        System.out.println("有執行emp2_1");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("有執行emp1_1");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
	    
		String Emp_name=request.getParameter("emp_name");
		String Emp_account=request.getParameter("emp_account");
		String Emp_password=request.getParameter("emp_password");
		String Emp_permission=request.getParameter("emp_permission");
		String Emp_phone=request.getParameter("emp_phone");
		String Emp_address=request.getParameter("emp_address");
		String Emp_job=request.getParameter("emp_job");
		String Emp_hiredate=request.getParameter("emp_hiredate");
		
		EmpVO employee=new EmpVO();
		employee.setEmp_name(Emp_name);
		employee.setEmp_account(Emp_account);
		employee.setEmp_password(Emp_password);
		employee.setEmp_permission(Integer.parseInt(Emp_permission));
		employee.setEmp_phone(Emp_phone);
		employee.setEmp_address(Emp_address);
		employee.setEmp_job(Emp_job);
		employee.setEmp_hiredate(Emp_hiredate);
		System.out.println(employee.toString());
		System.out.println("有執行emp2");
		EmpJDBCDAO dao=new EmpJDBCDAO();
		dao.insert(employee);
		request.getRequestDispatcher("EmpShowServlet").forward(request, response);
//		boolean res =dao.insert(employee);
//		if(res) {
//			request.getRequestDispatcher("EmpShowServlet").forward(request, response);
//		}else {
//			request.getRequestDispatcher("pages/employee/employee_add.jsp").forward(request, response);
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
