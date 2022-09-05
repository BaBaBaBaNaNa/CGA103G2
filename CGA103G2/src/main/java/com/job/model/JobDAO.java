package com.job.model;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.*;

public class JobDAO implements JobDAO_interface {
	
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
	
	private static final String INSERT_STMT = "INSERT INTO Job ( jobName) VALUES (?);";
	private static final String GET_ALL_STMT = "SELECT jobID,jobName FROM Job order by jobID";
	private static final String GET_ONE_STMT = "SELECT jobID,jobName FROM Job where jobID = ?";
	private static final String DELETE = "DELETE FROM Job where jobID = ?";
	private static final String UPDATE = "UPDATE job set jobName=? where jobID = ?";
	
	private static final String CheckRepeatJobName= "SELECT jobName FROM Job where jobName = ?";
	
	//----- ----- ----- 新增db Job單筆資料 start ----- ----- -----
	@Override
	public void insert(JobVO jobVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, jobVO.getJobName());

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
	//----- ----- ----- 新增db Job單筆資料 end ----- ----- -----
	
	//----- ----- ----- 修改db Job單筆資料用jobID start ----- ----- -----
	@Override
	public void update(JobVO jobVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, jobVO.getJobName());
			pstmt.setInt(2, jobVO.getJobID());
			
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
	//----- ----- ----- 修改db Job單筆資料用jobID end ----- ----- -----
	
	//----- ----- ----- 刪除db Job單筆資料用jobID start ----- ----- -----
	@Override
	public void delete(Integer jobID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, jobID);

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
	//----- ----- ----- 刪除db Job單筆資料用jobID end ----- ----- -----

	//----- ----- ----- 查詢db Job單筆資料用jobID start ----- ----- -----
	@Override
	public JobVO findByPrimaryKey(Integer jobID) {

		JobVO jobVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, jobID);
			
			rs = pstmt.executeQuery();
//			System.out.println(rs);
			while (rs.next()) {
				// empVo 也稱為 Domain objects
				jobVO = new JobVO();

				jobVO.setJobID(rs.getInt("jobID"));
				jobVO.setJobName(rs.getString("jobName"));

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
		return jobVO;
	}
	//----- ----- ----- 查詢db Job單筆資料用jobID end ----- ----- -----
	
	//----- ----- ----- 查詢db 全部資料 start ----- ----- -----
	@Override
	public List<JobVO> getAll() {
		List<JobVO> list = new ArrayList<JobVO>();
		JobVO jobVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				jobVO = new JobVO();

				jobVO.setJobID(rs.getInt("jobID"));
				jobVO.setJobName(rs.getString("jobName"));
				
				list.add(jobVO); // Store the row in the list
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
	//----- ----- ----- 查詢db 全部資料 end ----- ----- -----
	
	//----- ----- ----- 查詢db Job 的JobName start ----- ----- -----
	@Override
	public JobVO checkRepeatJobName(String jobName) {

		JobVO jobVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(CheckRepeatJobName);
			
			pstmt.setString(1, jobName);
			
			rs = pstmt.executeQuery();
//			System.out.println(rs);
			while (rs.next()) {
				// empVo 也稱為 Domain objects
				jobVO = new JobVO();

				jobVO.setJobName(rs.getString("jobName"));

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
		return jobVO;
	}
	//----- ----- ----- 查詢db Job 的JobName end ----- ----- -----
}