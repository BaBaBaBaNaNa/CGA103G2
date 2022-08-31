package com.queuer.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class QueuerDAO implements QueuerDAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/CGA103G2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT =
			"INSERT INTO queuer (queuerID, queuerStatus, queuerName, queuerPhone, queuerNo) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE =
			"UPDATE queuer set queuerStatus=? WHERE queuerID=?";
	private static final String GET_ALL =
			"SELECT queuerID, waitingID, queuerStatus, queuerName, queuerPhone, queuerNo FROM queuer order by queuerID";
	private static final String GET_ONE =
			"SELECT queuerID, waitingID, queuerStatus, queuerName, queuerPhone, queuerNo FROM queuer where queuerID = ?";
	private static final String DELETE =
			"DELETE FROM queuer WHERE queuerID = ?";
	@Override
	public void insert(QueuerVO queuerVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, queuerVO.getQueuerName());
			pstmt.setString(2, queuerVO.getQueuerPhone());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(QueuerVO queuerVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, queuerVO.getQueuerStatus());
			pstmt.setInt(2, queuerVO.getQueuerID());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer queuerID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, queuerID);

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public QueuerVO findByPrimaryKey(Integer queuerID) {
		
		QueuerVO queuerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);
			
			pstmt.setInt(1, queuerID);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				queuerVO = new QueuerVO();
				queuerVO.setQueuerID(rs.getInt("queuerID"));
				queuerVO.setWaitingID(rs.getInt("waitingID"));
				queuerVO.setQueuerStatus(rs.getInt("queuerStatus"));
				queuerVO.setQueuerName(rs.getString("queuerName"));
				queuerVO.setQueuerPhone(rs.getString("queuerPhone"));
				queuerVO.setQueuerNo(rs.getInt("queuerNo"));
			} 
			
		}catch (SQLException se) {
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
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				queuerVO = new QueuerVO();
				queuerVO.setQueuerID(rs.getInt("queuerID"));
				queuerVO.setWaitingID(rs.getInt("waitingID"));
				queuerVO.setQueuerStatus(rs.getInt("queuerStatus"));
				queuerVO.setQueuerName(rs.getString("queuerName"));
				queuerVO.setQueuerPhone(rs.getString("queuerPhone"));
				queuerVO.setQueuerNo(rs.getInt("queuerNo"));
				
				list.add(queuerVO);
			}

			// Handle any driver errors
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
	