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

	private static final String InsertStmt1 = "INSERT INTO Orders ( memID, empCounterID,empDeliveryID,seatID,ordersType,ordersAmount,ordersDestination,ordersBuildDate,ordersMakeDate) VALUES (?,?,?,?,?,?,?,?,?);";
	private static final String InsertStmt2 = "INSERT INTO Orddetails ( ordersID, mealsID,orddetailsMealsQuantity,orddetailsMealsAmount,orddetailsMealsStatus,orddetailsDeliverStatus) VALUES (?,?,?,?,?,?);";
	private static final String GetOrdersIDMAX = "SELECT max(ordersID) from orders;";

	// ----- ----- ----- 購物車新增訂單 start ----- ----- -----
	//新增訂單
	@Override
	public void insertOrders(ShopCartVO shopcartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(InsertStmt1);

			pstmt.setInt(1, shopcartVO.getMemID());
			pstmt.setInt(2, shopcartVO.getEmpCounterID());
			pstmt.setInt(3, shopcartVO.getEmpDeliveryID());
			pstmt.setInt(4, shopcartVO.getSeatID());
			pstmt.setInt(5, shopcartVO.getOrdersType());
			pstmt.setInt(6, shopcartVO.getOrdersAmount());
			pstmt.setString(7, shopcartVO.getOrdersDestination());
			pstmt.setObject(8, shopcartVO.getOrdersBuildDate());
			pstmt.setObject(9, shopcartVO.getOrdersMakeDate());

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