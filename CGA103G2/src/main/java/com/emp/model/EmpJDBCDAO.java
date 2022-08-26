 package com.emp.model;

import java.util.*;

import com.emp.model.EmpVO;

import java.sql.*;

public class EmpJDBCDAO implements EmpDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/CGA103G2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	private static final String LOGINSTMT = "SELECT empaccount,emppassword from employee where empaccount = ? and emppassword = ?";
	private static final String INSERTSTMT = "INSERT INTO employee ( empname, empaccount,emppassword,emppermission,empphone,empaddress,emphiredate) VALUES (?,?,?,?,?,?,?);";
	private static final String GETALLSTMT = "SELECT empid, empname, empaccount,emppassword,emppermission,empphone,empaddress,emphiredate FROM employee order by empid";
	private static final String GETONESTMT = "SELECT empid, empname, empaccount,emppassword,emppermission,empphone,empaddress,emphiredate FROM employee where empid = ?";
	private static final String DELETE = "DELETE FROM employee where empid = ?";
	private static final String UPDATE = "UPDATE employee set empname=?, empaccount=?, emppassword=?, emppermission=?, empphone=?, empaddress=?, empjob=?,emphiredate=? where empid = ?";

	@Override
	public boolean loginAdmin(EmpLoginVO admin) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
//		Connection conn = EmpDb.getConnection();
//		String sql = "select empaccount,emppassword from employee where empaccount = ? and emppassword = ?;";
		
		int res = 0;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(LOGINSTMT );
			
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
			pstmt = con.prepareStatement(INSERTSTMT);

//			pstmt.setInt(1,empVO.getEmpid());
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
	public void delete(Integer empid) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, empid);

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
	public EmpVO findByPrimaryKey(Integer empid) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GETONESTMT);

			pstmt.setInt(1, empid);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				empVO = new EmpVO();

				empVO.setEmp_id(rs.getInt("empid"));
				empVO.setEmp_name(rs.getString("empname"));
				empVO.setEmp_account(rs.getString("empaccount"));
				empVO.setEmp_password(rs.getString("emppassword"));
				empVO.setEmp_permission(rs.getInt("emppermission"));
				empVO.setEmp_phone(rs.getString("empphone"));
				empVO.setEmp_address(rs.getString("empaddress"));
				empVO.setEmp_job(rs.getString("empjob"));
				empVO.setEmp_hiredate(rs.getString("emphiredate"));
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
			pstmt = con.prepareStatement(GETALLSTMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				empVO = new EmpVO();

				empVO.setEmp_id(rs.getInt("empid"));
				empVO.setEmp_name(rs.getString("empname"));
				empVO.setEmp_account(rs.getString("empaccount"));
				empVO.setEmp_password(rs.getString("emppassword"));
				empVO.setEmp_permission(rs.getInt("emppermission"));
				empVO.setEmp_phone(rs.getString("empphone"));
				empVO.setEmp_address(rs.getString("empaddress"));
				empVO.setEmp_job(rs.getString("empjob"));
				empVO.setEmp_hiredate(rs.getString("emphiredate"));
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
//		empVO1.setEmpname("楊嘉倫");
//		empVO1.setEmpaccount ("admin01");
//		empVO1.setEmppassword("123456");
//		empVO1.setEmppermission(0);
//		empVO1.setEmpphone("0987654321");
//		empVO1.setEmpaddress("桃園市中壢區復興路46號9樓");
//		empVO1.setEmpjob("管理者");
//		empVO1.setEmphiredate("2018-06-11");
//		dao.insert(empVO1);

		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpid(1);
//		empVO2.setEmpname("楊嘉倫");
//		empVO2.setEmpaccount ("admin01");
//		empVO2.setEmppassword("123456");
//		empVO2.setEmppermission(0);
//		empVO2.setEmpphone("0987654321");
//		empVO2.setEmpaddress("桃園市中壢區復興路46號9樓");
//		empVO2.setEmpjob("管理者");
//		empVO2.setEmphiredate("2018-06-09");
//		dao.update(empVO2);

		// 刪除
//		dao.delete(2);

		// 單筆查詢
//		EmpVO empVO3 = dao.findByPrimaryKey(1);
//		System.out.print(empVO3.getEmpid() + ",");
//		System.out.print(empVO3.getEmpname() + ",");
//		System.out.print(empVO3.getEmpaccount() + ",");
//		System.out.print(empVO3.getEmppassword() + ",");
//		System.out.print(empVO3.getEmppermission() + ",");
//		System.out.print(empVO3.getEmpphone() + ",");
//		System.out.println(empVO3.getEmpaddress() + ",");
//		System.out.println(empVO3.getEmpjob() + ",");
//		System.out.println(empVO3.getEmphiredate());
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