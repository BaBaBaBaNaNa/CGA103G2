package com.seat.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SeatDAO implements SeatDAOInterface{
	
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
	
	private static final String InsertSeatSTMT = "INSERT INTO Seat ( , ) VALUES ( , );";
	
	@Override
	public void insert(SeatVO seatVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(InsertSeatSTMT);
			
//			pstmt.setString(1, empVO.getEmpName());
//			pstmt.setString(2, empVO.getEmpAccount());
//			pstmt.setString(3, empVO.getEmpPassword());
//			pstmt.setInt(4, empVO.getEmpPermission());
//			pstmt.setString(5, empVO.getEmpPhone());
//			pstmt.setString(6, empVO.getEmpAddress());
//			pstmt.setInt(7, empVO.getJobID());
//			pstmt.setObject(8, empVO.getEmpHiredate());

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
}
