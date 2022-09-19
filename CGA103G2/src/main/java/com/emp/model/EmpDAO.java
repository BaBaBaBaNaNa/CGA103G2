package com.emp.model;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.login.model.EmpLoginVO;

import java.sql.*;

public class EmpDAO implements EmpDAOInterface {
	
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
	
	private static final String INSERT_STMT = "INSERT INTO Employee ( empName, empAccount,empPassword,empPermission,empPhone,empAddress,jobID,empHiredate) VALUES (?,?,?,?,?,?,?,?);";
	private static final String GET_ALL_STMT = "SELECT empID, empName, empAccount,empPassword,empPermission,empPhone,empAddress,jobID,empHiredate FROM Employee order by empID";
	private static final String GET_ONE_STMT = "SELECT empID, empName, empAccount,empPassword,empPermission,empPhone,empAddress,jobID,empHiredate FROM Employee where empID = ?";
	private static final String DELETE = "DELETE FROM Employee where empID = ?";
	private static final String UPDATE = "UPDATE Employee set empName=?, empAccount=?, empPassword=?, empPermission=?, empPhone=?, empAddress=?, jobID=?,empHiredate=? where empID = ?";
	
	private static final String CheckRepeatEmpAccount= "SELECT empAccount FROM Employee where empAccount = ?";
	
	private static final String GetOwnSTMT= "SELECT * FROM Employee where empAccount = ?";
	
	//----- ----- ----- 新增db Employee單筆資料 start ----- ----- -----
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
	//----- ----- ----- 新增db Employee單筆資料 end ----- ----- -----
	
	//----- ----- ----- 修改db Employee單筆資料 start ----- ----- -----
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
	//----- ----- ----- 修改db Employee單筆資料 end ----- ----- -----
	
	//----- ----- ----- 刪除db Employee單筆資料 start ----- ----- -----
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
	//----- ----- ----- 刪除db Employee單筆資料 end ----- ----- -----
	
	//----- ----- ----- 查詢db Employee單筆資料 使用empID start ----- ----- -----
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
	//----- ----- ----- 查詢db Employee單筆資料 使用empID end ----- ----- -----
	
	//----- ----- ----- 查詢db Employee全部資料 start ----- ----- -----
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
	//----- ----- ----- 查詢db Employee全部資料 end ----- ----- -----
	
	//----- ----- ----- 查詢db Employee 的empAccount start ----- ----- -----
	@Override
	public EmpVO checkRepeatEmpAccount(String empAccount) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(CheckRepeatEmpAccount);
			
			pstmt.setString(1, empAccount);
			
			rs = pstmt.executeQuery();
//			System.out.println(rs);
			while (rs.next()) {
				// empVo 也稱為 Domain objects
				empVO = new EmpVO();

				empVO.setEmpName(rs.getString("empAccount"));

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
		return empVO;
	}
	//----- ----- ----- 查詢db Employee 的empAccount end ----- ----- -----
	
	//----- ----- ----- 複合查詢db Employee Start ----- ----- -----
	@Override
	public List<EmpVO> getAll(Map<String, String[]> map) {
		List<EmpVO> list = new ArrayList<EmpVO>();
		EmpVO empVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = ds.getConnection();
			String finalSQL = "select * from employee "
		          + EmpCompositeQuery.getWhereCondition(map)
		          + "order by empID";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
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
				
				list.add(empVO); // Store the row in the List
			}
	
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	//----- ----- ----- 複合查詢db Employee end ----- ----- -----
	
	//----- ----- ----- 查找 db Employee 個人資料 start ----- ----- -----
	@Override
	public EmpVO findByEmpAccount(String empAccount) {

		EmpVO empVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GetOwnSTMT);
			
			pstmt.setString(1, empAccount);
			
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
	//----- ----- ----- 查找 db Employee 個人資料 end ----- ----- -----
}