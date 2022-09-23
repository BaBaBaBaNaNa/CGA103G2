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
	private static final String InsertInsideDetailStmt = "INSERT INTO Orddetails ( ordersID,mealsID,orddetailsMealsQuantity,orddetailsMealsAmount,orddetailsMealsStatus,orddetailsDeliverStatus) VALUES (?,?,?,?,?,?);";
	// ----- ----- ----- 購物車新增訂單 start ----- ----- -----
	//新增內用訂單
	@Override
	public void insertInsideOrders(ShopCartVO shopcartVO , ArrayList PriceArrayList, ArrayList NameArrayList, ArrayList CountArrayList ,ArrayList idArrayList) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			
			//關閉自動交易控制
			con.setAutoCommit(false);
			//儲存第一個點,以便回復
			Savepoint savepoint1 = con.setSavepoint("savepoint1");
			
			pstmt1 = con.prepareStatement(InsertInsideStmt,Statement.RETURN_GENERATED_KEYS);

			pstmt1.setInt(1, shopcartVO.getOrdersType());
			pstmt1.setInt(2, shopcartVO.getOrdersStatus());
			pstmt1.setTimestamp(3, shopcartVO.getOrdersBuildDate());

			pstmt1.executeUpdate();
			
			// ===== 取回訂單ID,要放進訂單明細 =====
			String nextOrdersID = null;
			rs = pstmt1.getGeneratedKeys();
			
			if (rs.next()) {
				nextOrdersID = rs.getString(1);
				System.out.println("自增主鍵值= " + nextOrdersID +"(剛新增成功的訂單編號)");
			} else {
				System.out.println("未取得自增主鍵值");
			}
			rs.close();
			
			for(int i=0;i<PriceArrayList.size();i++) {
				System.out.println("==========");
				System.out.println("DAO");
				System.out.println(PriceArrayList.get(i));
				System.out.println(NameArrayList.get(i));
				System.out.println(CountArrayList.get(i));
				System.out.println(idArrayList.get(i));
				System.out.println("==========");
				
				int P1 = (Integer)(PriceArrayList.get(i));
				int C1 = (Integer)(CountArrayList.get(i));
				int id1 = (Integer)(idArrayList.get(i));
				
				pstmt2 = con.prepareStatement(InsertInsideDetailStmt);
				//ordersID
				pstmt2.setInt(1,Integer.parseInt(nextOrdersID));
				//mealsID
				pstmt2.setInt(2,id1);
				//orddetailsMealsQuantity
				pstmt2.setInt(3,C1);
				//orddetailsMealsAmount
				pstmt2.setInt(4,P1 * C1);
				//orddetailsMealsStatus 0:已製作 , 1:未製作
				pstmt2.setInt(5,1); 
				//orddetailsDeliverStatus 0:已送餐 , 1:未送餐
				pstmt2.setInt(6,1);
				
				pstmt2.executeUpdate();
			}
			
			
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
	// ----- ----- ----- 購物車新增訂單 end ----- ----- -----
}