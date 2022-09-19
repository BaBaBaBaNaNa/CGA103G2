package com.shopcart.model;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.emp.model.EmpVO;

import java.sql.*;

public class ShopCartDAO implements ShopCartDAOInterface {
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
	private static final String InsertStmt1 = "INSERT INTO Orders ( memID, empCounterID,empDeliveryID,seatID,ordersType,ordersAmount,ordersStatus,ordersDestination,ordersBuildDate,ordersMakeDate) VALUES (?,?,?,?,?,?,?,?,?,?);";
	private static final String InsertStmt2 = "INSERT INTO Orddetails ( ordersID, mealsID,orddetailsMealsQuantity,orddetailsMealsAmount,orddetailsMealsStatus,orddetailsDeliverStatus) VALUES (?,?,?,?,?,?);";
	private static final String GetOrdersIDMAX = "SELECT max(ordersID) from orders;";

	private static final String InsertInsideStmt = "INSERT INTO Orders ( ordersType,ordersStatus,ordersBuildDate) VALUES (?,?,?);";
	
	// ----- ----- ----- 購物車新增訂單 start ----- ----- -----
	//新增訂單
	@Override
	public void insertOrders(ShopCartVO shopcartVO) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		
		PreparedStatement pstmt2 = null;
		
		PreparedStatement pstmtGetBackID = null;
		
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt1 = con.prepareStatement(InsertStmt1);
			
			//關閉自動交易控制
			con.setAutoCommit(false);
			//儲存第一個點,以便回復
			Savepoint savepoint1 = con.setSavepoint("savepoint1");
			
			pstmt1.setInt(1, shopcartVO.getMemID());
			pstmt1.setInt(2, shopcartVO.getEmpCounterID());
			pstmt1.setInt(3, shopcartVO.getEmpDeliveryID());
			pstmt1.setInt(4, shopcartVO.getSeatID());
			pstmt1.setInt(5, shopcartVO.getOrdersType());
			pstmt1.setInt(6, shopcartVO.getOrdersAmount());
			pstmt1.setInt(7, shopcartVO.getOrdersStatus());
			pstmt1.setString(8, shopcartVO.getOrdersDestination());
			pstmt1.setTimestamp(9, shopcartVO.getOrdersBuildDate());
			pstmt1.setTimestamp(10, shopcartVO.getOrdersMakeDate());
			
			pstmt1.executeUpdate();
			
			// ===== 取回訂單ID,要放進訂單明細 =====
			pstmtGetBackID = con.prepareStatement(GetOrdersIDMAX);
			rs = pstmtGetBackID.executeQuery();
			int GetBackOrdersID = rs.getInt("ordersID");
			
			pstmt2 = con.prepareStatement(InsertStmt2);
			
			pstmt2.setInt(1, shopcartVO.getMemID());
			pstmt2.setInt(2, shopcartVO.getEmpCounterID());
			pstmt2.setInt(3, shopcartVO.getEmpDeliveryID());
			pstmt2.setInt(4, shopcartVO.getSeatID());
			pstmt2.setInt(5, shopcartVO.getOrdersType());
			pstmt2.setInt(6, shopcartVO.getOrdersAmount());
			pstmt2.setInt(7, shopcartVO.getOrdersStatus());
			pstmt2.setString(8, shopcartVO.getOrdersDestination());
			pstmt2.setTimestamp(9, shopcartVO.getOrdersBuildDate());
			pstmt2.setTimestamp(10, shopcartVO.getOrdersMakeDate());
			
			//儲存第二個點,以便回復
			Savepoint savepoint2 = con.setSavepoint("savepoint2");
			
			// 遇到有問題,rollback回savepoint1
//			con.rollback(savepoint1);
			// 遇到有問題,rollback回savepoint2
//			con.rollback(savepoint2);

			//commit
			con.commit();
			//開啟自動交易控制
			con.setAutoCommit(true);
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt1 != null) {
				try {
					pstmt1.close();
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
	//新增內用訂單
	@Override
	public void insertInsideOrders(ShopCartVO shopcartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(InsertInsideStmt);


			pstmt.setInt(1, shopcartVO.getOrdersType());
			pstmt.setInt(2, shopcartVO.getOrdersStatus());
			pstmt.setTimestamp(3, shopcartVO.getOrdersBuildDate());

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
	
	// 查詢ordersID最新一筆
	@Override
	public ShopCartVO findByPrimaryKey(Integer ordersID) {

		ShopCartVO shopcartVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GetOrdersIDMAX);
			
			pstmt.setInt(1, ordersID);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				shopcartVO = new ShopCartVO();

				shopcartVO.setOrdersID(rs.getInt("ordersID"));
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
		return shopcartVO;
	}
	
	//新增訂單詳情
	@Override
	public void insertOrdersDetail(ShopCartVO shopcartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(InsertStmt2);

			pstmt.setInt(1, shopcartVO.getOrdersID());
			pstmt.setInt(2, shopcartVO.getMealsID());
			pstmt.setInt(3, shopcartVO.getOrddetailsMealsQuantity());
			pstmt.setInt(4, shopcartVO.getOrddetailsMealsAmount());
			pstmt.setInt(5, shopcartVO.getOrddetailsMealsStatus());
			pstmt.setInt(6, shopcartVO.getOrddetailsDeliverStatus());

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
	};
	// ----- ----- ----- 購物車新增訂單 end ----- ----- -----
}