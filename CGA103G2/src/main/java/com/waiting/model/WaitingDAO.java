package com.waiting.model;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class WaitingDAO implements WaitingDAO_interface{
	
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
		"INSERT INTO waiting (waiting_id, waiting_date, waiting_time, current_no, current_queued_no) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE =
		"UPDATE waiting SET waiting_id=?, waiting_date=?, waiting_time=?, current_no=?, current_queued_no=?";
	private static final String DELETE =
		"DELETE FROM waiting WHERE waiting_id = ?";
	private static final String GET_ALL =
		"SELECT waiting_id, waiting_date, waiting_time, current_no, current_queued_no FROM waiting ORDER BY waiting_id";
	private static final String GET_ONE =
			"SELECT waiting_id, waiting_date, waiting_time, current_no, current_queued_no FROM waiting WHERE waiting_id = ?";
	
	public void insert(WaitingVO waitingVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, waitingVO.getwaiting_id());
			pstmt.setDate(2, waitingVO.getwaiting_date());
			pstmt.setInt(3, waitingVO.getwaiting_time());
			pstmt.setInt(4, waitingVO.getcurrent_no());
			pstmt.setInt(5, waitingVO.getcurrent_queued_no());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public void update(WaitingVO waitingVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, waitingVO.getwaiting_id());
			pstmt.setDate(2, waitingVO.getwaiting_date());
			pstmt.setInt(3, waitingVO.getwaiting_time());
			pstmt.setInt(4, waitingVO.getcurrent_no());
			pstmt.setInt(5, waitingVO.getcurrent_queued_no());
			
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A databade error occured." + se.getMessage());
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	

	@Override
	public void delete(Integer waiting_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, waiting_id);
			
		}catch (SQLException se) {
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
	public WaitingVO findByPrimaryKey(Integer waiting_id) {
		
		WaitingVO waitingVO = new WaitingVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE);
			
			pstmt.setInt(1, waiting_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				waitingVO = new WaitingVO();
				waitingVO.setwaiting_id(rs.getInt("waiting_id"));
				waitingVO.setwaiting_date(rs.getDate("wainting_date"));
				waitingVO.setwaiting_time(rs.getInt("waiting_time"));
				waitingVO.setcurrent_no(rs.getInt("current_no"));
				waitingVO.setcurrent_queued_no(rs.getInt("current_queued_no"));
			}
			
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
        return waitingVO;
    }
	@Override
	public List<WaitingVO> getAll() {
		List<WaitingVO> list = new ArrayList<WaitingVO>();
		WaitingVO waitingVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				waitingVO = new WaitingVO();
				waitingVO.setwaiting_id(rs.getInt("waiting_id"));
				waitingVO.setwaiting_date(rs.getDate("wainting_date"));
				waitingVO.setwaiting_time(rs.getInt("waiting_time"));
				waitingVO.setcurrent_no(rs.getInt("current_no"));
				waitingVO.setcurrent_queued_no(rs.getInt("current_queued_no"));
				list.add(waitingVO);
			}
			
			
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