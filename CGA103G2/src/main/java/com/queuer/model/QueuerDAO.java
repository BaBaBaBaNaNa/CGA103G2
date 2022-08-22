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
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/resaurant");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT =
			"INSERT INTO queuer (queuer_id, queuer_status, queuer_name, queuer_phone, queuer_no) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE =
			"UPDATE queuer set queuer_id=?, queuer_status=?, queuer_name=?, queuer_phone=?, queuer_no=? WHERE waiting_id=?";
	private static final String GET_ALL =
			"SELECT queued_id, waiting_id, queuer_status, queuer_name, queuer_phone, queuer_no FROM queuer order by queued_id";
	private static final String GET_ONE =
			"SELECT queued_id, waiting_id, queuer_status, queuer_name, queuer_phone, queuer_no FROM queuer where queued_id = ?";
	private static final String DELETE =
			"DELETE FROM queuer WHERE queuer_id = ?";
	@Override
	public void insert(QueuerVO queuerVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, queuerVO.getqueuer_id());
			pstmt.setInt(2, queuerVO.getqueuer_status());
			pstmt.setString(3, queuerVO.getqueuer_name());
			pstmt.setString(4, queuerVO.getqueuer_phone());
			pstmt.setInt(5, queuerVO.getqueuer_no());
			
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
			
			pstmt.setInt(1, queuerVO.getqueuer_id());
			pstmt.setInt(2, queuerVO.getqueuer_status());
			pstmt.setString(3, queuerVO.getqueuer_name());
			pstmt.setString(4, queuerVO.getqueuer_phone());
			pstmt.setInt(5, queuerVO.getqueuer_no());
			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer quequer_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, quequer_id);

			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public QueuerVO findByPrimaryKey(Integer queuer_id) {
		
		QueuerVO queuerVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);
			
			pstmt.setInt(1, queuer_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				queuerVO = new QueuerVO();
				queuerVO.setqueuer_id(rs.getInt("queuer_id"));
				queuerVO.setwaiting_id(rs.getInt("waiting_id"));
				queuerVO.setqueuer_status(rs.getInt("queuer_id"));
				queuerVO.setqueuer_name(rs.getString("queuer_name"));
				queuerVO.setqueuer_phone(rs.getString("queuer_phone"));
				queuerVO.setqueuer_no(rs.getInt("queuer_no"));
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
				queuerVO.setqueuer_id(rs.getInt("queuer_id"));
				queuerVO.setwaiting_id(rs.getInt("waiting_id"));
				queuerVO.setqueuer_status(rs.getInt("queuer_id"));
				queuerVO.setqueuer_name(rs.getString("queuer_name"));
				queuerVO.setqueuer_phone(rs.getString("queuer_phone"));
				queuerVO.setqueuer_no(rs.getInt("queuer_no"));
				
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
	