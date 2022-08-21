package com.emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emp.model.EmpJDBCDAO;
import com.emp.model.EmpVO;

/**
 * Servlet implementation class modifyServlet
 */
public class EmpModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// TODO Auto-generated method stub
		String method=request.getMethod();
		System.out.println("瀏覽器訪問時採用的請求方式："+method);
		int emp_id = Integer .parseInt(request.getParameter("emp_id"));
		EmpJDBCDAO dao=new EmpJDBCDAO();
		EmpVO employee=dao.findByPrimaryKey(emp_id);
		request.setAttribute("emp",employee );
		request.getRequestDispatcher("back-end/employee/employee_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("Big5");
		response.setContentType("text/html; charset=Big5");
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String method=request.getMethod();
		System.out.println("瀏覽器訪問時採用的請求方式："+method);
		String Emp_name=request.getParameter("emp_name");
		String Emp_account=request.getParameter("emp_account");
		String Emp_password=request.getParameter("emp_password");
		String Emp_permission=request.getParameter("emp_permission");
		String Emp_phone=request.getParameter("emp_phone");
		String Emp_address=request.getParameter("emp_address");
		String Emp_job=request.getParameter("emp_job");
		String Emp_hiredate=request.getParameter("emp_hiredate");
		//
		System.out.println(Emp_job);
		System.out.println(request.getParameter("emp_hiredate"));
		//
	    String Emp_id=request.getParameter("emp_id");
		EmpVO employee=new EmpVO();
		employee.setEmp_name(Emp_name);
		employee.setEmp_account(Emp_account);
		employee.setEmp_password(Emp_password);
		employee.setEmp_permission(Integer.parseInt(Emp_permission));
		employee.setEmp_phone(Emp_phone);
		employee.setEmp_address(Emp_address);
		employee.setEmp_job(Emp_job);
		employee.setEmp_hiredate(Emp_hiredate);
		employee.setEmp_id(Integer.parseInt(Emp_id));
		EmpJDBCDAO dao=new EmpJDBCDAO();
		
		dao.update(employee);
		request.getRequestDispatcher("EmpShowServlet").forward(request, response);
//		boolean res=dao.update(employee);
//		if(res) {
//			request.getRequestDispatcher("showServlet").forward(request, response);
//		}else {
//			request.getRequestDispatcher("showServlet").forward(request, response);
//		}
	}

}
