package com.login.model;

import java.util.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.login.model.EmpLoginVO;

import java.sql.*;

public class EmpLoginDAO implements EmpLoginDAO_interface {
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
	
	private static final String LOGIN_STMT = "SELECT empAccount,empPassword,empPermission from Employee where empAccount = ? and empPassword = ?";
	
	private static final String LOGIN_STMT2 = "SELECT empAccount,empPassword,empPermission from Employee where empAccount = ? and empPassword = ? and empPermission = 0";
	
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
	public boolean loginAdminPermission(EmpLoginVO admin) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(LOGIN_STMT2);
			
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
}