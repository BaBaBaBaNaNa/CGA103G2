package com.queuer.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueuerJDBCDAO implements QueuerDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "dbc:mysql://localhost:3306/CGA103G2?serverTimezone=Asia/Taipei";
	String userid = "dba";
	String passwd = "0911";
	
	private static final String INSERT_STMT =
			"INSERT INTO queuer (queuerID, queuerStatus, queuerName, queuerPhone, queuerNo) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE =
			"UPDATE queuer set queuerID=?, queuerStatus=?, queuerName=?, queuerPhone=?, queuerNo=? WHERE queuerID=?";
	private static final String GET_ALL =
			"SELECT queuerID, waitingID, queuerStatus, queuerName, queuerPhone, queuerNo FROM queuer FROM queuer order by queuerID";
	private static final String GET_ONE =
			"SELECT queuerID, waitingID, queuerStatus, queuerName, queuerPhone, queuerNo FROM queuer where queuerID = ?";
	private static final String DELETE =
			"DELETE FROM queuer WHERE queuerID = ?";
	
	@Override
	public void insert(QueuerVO queuerVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, queuerVO.getQueuerName());
			pstmt.setString(2, queuerVO.getQueuerPhone());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Counldn't load database driver." + e.getMessage());
		}catch (SQLException se) {
		throw new RuntimeException("A database error occured." + se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}
	@Override
	public void update(QueuerVO queuerVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, queuerVO.getQueuerStatus());
			pstmt.setString(2, queuerVO.getQueuerName());
			pstmt.setString(3, queuerVO.getQueuerPhone());
			pstmt.setInt(4, queuerVO.getQueuerNo());
			
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Counldn't load database driver." + e.getMessage());
		}catch (SQLException se) {
		throw new RuntimeException("A database error occured." + se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
		}
	}
	@Override
	public void delete(Integer queuerID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, queuerID);
			
			pstmt.executeQuery();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public QueuerVO findByPrimaryKey(Integer queuerID) {
		QueuerVO queuerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				queuerVO = new QueuerVO();
				queuerVO.setQueuerID(rs.getInt("queuerID"));
				queuerVO.setQueuerStatus(rs.getInt("queuerID"));
				queuerVO.setQueuerName(rs.getString("queuerName"));
				queuerVO.setQueuerPhone(rs.getString("queuerPhone"));
				queuerVO.setQueuerNo(rs.getInt("queuerNo"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
		return queuerVO;
	}
	@Override
	public List<QueuerVO> getAll() {
		List<QueuerVO> list = new ArrayList<QueuerVO>();
		QueuerVO queuerVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				queuerVO = new QueuerVO();
				queuerVO.setQueuerID(rs.getInt("queuerID"));
				queuerVO.setQueuerStatus(rs.getInt("queuerStatus"));
				queuerVO.setQueuerName(rs.getString("queuerName"));
				queuerVO.setQueuerPhone(rs.getString("queuerPhone"));
				queuerVO.setQueuerNo(rs.getInt("queuerNo"));
				
				list.add(queuerVO);
			}
			
			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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