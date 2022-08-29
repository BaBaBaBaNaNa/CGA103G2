package com.emp.model;

import java.util.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.login.model.EmpLoginVO;

import java.sql.*;

public class EmpDAO implements EmpDAO_interface {
//	共用DataSource
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cga103g2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String LOGIN_STMT = "SELECT empAccount,empPassword from Employee where empAccount = ? and empPassword = ?";
	private static final String INSERT_STMT = "INSERT INTO Employee ( empName, empAccount,empPassword,empPermission,empPhone,empAddress,jobID,empHiredate) VALUES (?,?,?,?,?,?,?,?);";
	private static final String GET_ALL_STMT = "SELECT empID, empName, empAccount,empPassword,empPermission,empPhone,empAddress,jobID,empHiredate FROM Employee order by empID";
	private static final String GET_ONE_STMT = "SELECT empID, empName, empAccount,empPassword,empPermission,empPhone,empAddress,jobID,empHiredate FROM Employee where empID = ?";
	private static final String DELETE = "DELETE FROM Employee where empID = ?";
	private static final String UPDATE = "UPDATE Employee set empName=?, empAccount=?, empPassword=?, empPermission=?, empPhone=?, empAddress=?, jobID=?,empHiredate=? where empID = ?";
	
	@Override
	public boolean loginAdmin(EmpLoginVO admin) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(LOGIN_STMT);
			
			pstmt.setString(1, admin.getEmpAccount());
			pstmt.setString(2, admin.getEmpPassword());

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				res = 1;
			}
			pstmt.close();
			rs.close();
			if (res == 1) {
				return true;
			}
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
//			pstmt.setInt(1,empVO.getEmp_id());
			pstmt.setString(1, empVO.getEmpName());
			pstmt.setString(2, empVO.getEmpAccount());
			pstmt.setString(3, empVO.getEmpPassword());
			pstmt.setInt(4, empVO.getEmpPermission());
			pstmt.setString(5, empVO.getEmpPhone());
			pstmt.setString(6, empVO.getEmpAddress());
			pstmt.setInt(7, empVO.getJobID());
			pstmt.setObject(8, empVO.getEmpHiredate());

			pstmt.executeUpdate();
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, empVO.getEmpName());
			pstmt.setString(2, empVO.getEmpAccount());
			pstmt.setString(3, empVO.getEmpPassword());
			pstmt.setInt(4, empVO.getEmpPermission());
			pstmt.setString(5, empVO.getEmpPhone());
			pstmt.setString(6, empVO.getEmpAddress());
			pstmt.setInt(7, empVO.getJobID());
			pstmt.setObject(8, empVO.getEmpHiredate());
			pstmt.setInt(9, empVO.getEmpID());

			pstmt.executeUpdate();
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
	public void delete(Integer empID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, empID);

			pstmt.executeUpdate();
			
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
	public EmpVO findByPrimaryKey(Integer empID) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, empID);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				empVO = new EmpVO();

				empVO.setEmpID(rs.getInt("empID"));
				empVO.setEmpName(rs.getString("empName"));
				empVO.setEmpAccount(rs.getString("empAccount"));
				empVO.setEmpPassword(rs.getString("empPassword"));
				empVO.setEmpPermission(rs.getInt("empPermission"));
				empVO.setEmpPhone(rs.getString("empPhone"));
				empVO.setEmpAddress(rs.getString("empAddress"));
				empVO.setJobID(rs.getInt("JobID"));
				empVO.setEmpHiredate( rs.getDate("empHiredate"));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				empVO = new EmpVO();

				empVO.setEmpID(rs.getInt("empID"));
				empVO.setEmpName(rs.getString("empName"));
				empVO.setEmpAccount(rs.getString("empAccount"));
				empVO.setEmpPassword(rs.getString("empPassword"));
				empVO.setEmpPermission(rs.getInt("empPermission"));
				empVO.setEmpPhone(rs.getString("empPhone"));
				empVO.setEmpAddress(rs.getString("empAddress"));
				empVO.setJobID(rs.getInt("JobID"));
				empVO.setEmpHiredate( rs.getDate("empHiredate"));
				list.add(empVO); 
			}
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

}