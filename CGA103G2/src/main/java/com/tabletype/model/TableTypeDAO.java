package com.tabletype.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.emp.model.EmpVO;

public class TableTypeDAO implements TableTypeDAOInterface {

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
	
	private static final String InsertTableTypeSTMT = "INSERT INTO TableType (tableType,tableTypeNumber) VALUES (?,?);";
	
	private static final String GetAllTableSTMT = "SELECT tableTypeID,tableType,tableTypeNumber FROM TableType order by tableTypeID";
	private static final String GetOneTableSTMT = "SELECT tableTypeID,tableType,tableTypeNumber FROM TableType where tableTypeID = ?";
	private static final String Delete = "DELETE FROM TableType where tableTypeID = ?";
	private static final String Update = "UPDATE TableType set tableType=?, tableTypeNumber=? where tableTypeID = ?";
	
	
	//----- ----- ----- 新增db TableType單筆資料 start ----- ----- -----
		@Override
		public void insertTableType(TableTypeVO tableTypeVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(InsertTableTypeSTMT);
				

				pstmt.setInt(1, tableTypeVO.getTableType());
				pstmt.setInt(2, tableTypeVO.getTableTypeNumber());

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
		//----- ----- ----- 新增db TableType單筆資料 end ----- ----- -----
		
		//----- ----- ----- 修改db TableType單筆資料 start ----- ----- -----
		@Override
		public void update(TableTypeVO tabletypeVO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(Update);

				pstmt.setInt(1, tabletypeVO.getTableType());
				pstmt.setInt(2, tabletypeVO.getTableTypeNumber());

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
		//----- ----- ----- 修改db TableType單筆資料 end ----- ----- -----
		
		//----- ----- ----- 刪除db TableType單筆資料 start ----- ----- -----
		@Override
		public void delete(Integer tableTypeID) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(Delete);

				pstmt.setInt(1, tableTypeID);

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
		//----- ----- ----- 刪除db TableType單筆資料 end ----- ----- -----
}
