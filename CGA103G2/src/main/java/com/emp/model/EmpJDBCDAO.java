 package com.emp.model;

import java.util.*;

import com.emp.model.EmpVO;

import java.sql.*;

public class EmpJDBCDAO implements EmpDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/restaurant?serverTimezone=Asia/Taipei";
	String userid = "adminmanager01";
	String passwd = "aaa123";
	private static final String LOGIN_STMT = "SELECT emp_account,emp_password from employee where emp_account = ? and emp_password = ?";
	private static final String INSERT_STMT = "INSERT INTO employee ( emp_name, emp_account,emp_password,emp_permission,emp_phone,emp_address,emp_job,emp_hiredate) VALUES (?,?,?,?,?,?,?,?);";
	private static final String GET_ALL_STMT = "SELECT emp_id, emp_name, emp_account,emp_password,emp_permission,emp_phone,emp_address,emp_job,emp_hiredate FROM employee order by emp_id";
	private static final String GET_ONE_STMT = "SELECT emp_id, emp_name, emp_account,emp_password,emp_permission,emp_phone,emp_address,emp_job,emp_hiredate FROM employee where emp_id = ?";
	private static final String DELETE = "DELETE FROM employee where emp_id = ?";
	private static final String UPDATE = "UPDATE employee set emp_name=?, emp_account=?, emp_password=?, emp_permission=?, emp_phone=?, emp_address=?, emp_job=?,emp_hiredate=? where emp_id = ?";

	@Override
	public boolean loginAdmin(EmpLoginVO admin) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
//		Connection conn = EmpDb.getConnection();
//		String sql = "select emp_account,emp_password from employee where emp_account = ? and emp_password = ?;";
		
		int res = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(LOGIN_STMT );
			
			pstmt.setString(1, admin.getEmp_account());
			pstmt.setString(2, admin.getEmp_password());
			System.out.println(admin.getEmp_account());
			System.out.println(admin.getEmp_password());
			System.out.println(pstmt.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				res = 1;
			}
			pstmt.close();
			rs.close();
			if (res == 1) {
				return true;
			}
		}catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		}
		return false;
	}
	
	@Override
	public void insert(EmpVO empVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

//			pstmt.setInt(1,empVO.getEmp_id());
			pstmt.setString(1, empVO.getEmp_name());
			pstmt.setString(2, empVO.getEmp_account());
			pstmt.setString(3, empVO.getEmp_password());
			pstmt.setInt(4, empVO.getEmp_permission());
			pstmt.setString(5, empVO.getEmp_phone());
			pstmt.setString(6, empVO.getEmp_address());
			pstmt.setString(7, empVO.getEmp_job());
			pstmt.setString(8, empVO.getEmp_hiredate());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(EmpVO empVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, empVO.getEmp_name());
			pstmt.setString(2, empVO.getEmp_account());
			pstmt.setString(3, empVO.getEmp_password());
			pstmt.setInt(4, empVO.getEmp_permission());
			pstmt.setString(5, empVO.getEmp_phone());
			pstmt.setString(6, empVO.getEmp_address());
			pstmt.setString(7, empVO.getEmp_job());
			pstmt.setString(8, empVO.getEmp_hiredate());
			pstmt.setInt(9, empVO.getEmp_id());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer emp_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, emp_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public EmpVO findByPrimaryKey(Integer emp_id) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, emp_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				empVO = new EmpVO();

				empVO.setEmp_id(rs.getInt("emp_id"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_account(rs.getString("emp_account"));
				empVO.setEmp_password(rs.getString("emp_password"));
				empVO.setEmp_permission(rs.getInt("emp_permission"));
				empVO.setEmp_phone(rs.getString("emp_phone"));
				empVO.setEmp_address(rs.getString("emp_address"));
				empVO.setEmp_job(rs.getString("emp_job"));
				empVO.setEmp_hiredate(rs.getString("emp_hiredate"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				empVO = new EmpVO();

				empVO.setEmp_id(rs.getInt("emp_id"));
				empVO.setEmp_name(rs.getString("emp_name"));
				empVO.setEmp_account(rs.getString("emp_account"));
				empVO.setEmp_password(rs.getString("emp_password"));
				empVO.setEmp_permission(rs.getInt("emp_permission"));
				empVO.setEmp_phone(rs.getString("emp_phone"));
				empVO.setEmp_address(rs.getString("emp_address"));
				empVO.setEmp_job(rs.getString("emp_job"));
				empVO.setEmp_hiredate(rs.getString("emp_hiredate"));
				list.add(empVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		EmpJDBCDAO dao = new EmpJDBCDAO();

//		// 新增
//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEmp_name("楊嘉倫");
//		empVO1.setEmp_account ("admin01");
//		empVO1.setEmp_password("123456");
//		empVO1.setEmp_permission(0);
//		empVO1.setEmp_phone("0987654321");
//		empVO1.setEmp_address("桃園市中壢區復興路46號9樓");
//		empVO1.setEmp_job("管理者");
//		empVO1.setEmp_hiredate("2018-06-11");
//		dao.insert(empVO1);

		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmp_id(1);
//		empVO2.setEmp_name("楊嘉倫");
//		empVO2.setEmp_account ("admin01");
//		empVO2.setEmp_password("123456");
//		empVO2.setEmp_permission(0);
//		empVO2.setEmp_phone("0987654321");
//		empVO2.setEmp_address("桃園市中壢區復興路46號9樓");
//		empVO2.setEmp_job("管理者");
//		empVO2.setEmp_hiredate("2018-06-09");
//		dao.update(empVO2);

		// 刪除
//		dao.delete(2);

		// 單筆查詢
//		EmpVO empVO3 = dao.findByPrimaryKey(1);
//		System.out.print(empVO3.getEmp_id() + ",");
//		System.out.print(empVO3.getEmp_name() + ",");
//		System.out.print(empVO3.getEmp_account() + ",");
//		System.out.print(empVO3.getEmp_password() + ",");
//		System.out.print(empVO3.getEmp_permission() + ",");
//		System.out.print(empVO3.getEmp_phone() + ",");
//		System.out.println(empVO3.getEmp_address() + ",");
//		System.out.println(empVO3.getEmp_job() + ",");
//		System.out.println(empVO3.getEmp_hiredate());
//		System.out.println("---------------------");

		// 多筆查詢
		List<EmpVO> list = dao.getAll();
		for (EmpVO aEmp : list) {
			System.out.print(aEmp.getEmp_id() + ",");
			System.out.print(aEmp.getEmp_name() + ",");
			System.out.print(aEmp.getEmp_account() + ",");
			System.out.print(aEmp.getEmp_password() + ",");
			System.out.print(aEmp.getEmp_permission() + ",");
			System.out.print(aEmp.getEmp_phone() + ",");
			System.out.println(aEmp.getEmp_address() + ",");
			System.out.println(aEmp.getEmp_job() + ",");
			System.out.println(aEmp.getEmp_hiredate());
			System.out.println();
		}
	}
}
/* */