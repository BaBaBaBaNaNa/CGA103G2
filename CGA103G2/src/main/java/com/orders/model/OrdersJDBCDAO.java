package com.orders.model;

import java.util.*;

import javax.management.RuntimeErrorException;

import java.sql.*;
import java.sql.Date;
public class OrdersJDBCDAO implements OrdersDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cga103g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1215";

	private static final String INSERT_STMT = "INSERT INTO orders (ordersID,memID,empCounterID,empDeliveryID,seatID,ordersType"
		+ ",ordersAmount,ordersStatus,ordersDestination,ordersBuildDate,ordersMakeDate"
		+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT ordersID, memID, empCounterID, empDeliveryID, seatID, ordersType"
		+ "	, ordersAmount, ordersStatus, ordersDestination, ordersBuildDate, ordersMakeDate"
		+ " FROM orders order by ordersID";
	private static final String GET_ONE_STMT = "SELECT ordersID,memID,empCounterID,empDeliveryID,seatID,ordersType"
		+ ",ordersAmount,ordersStatus,ordersDestination,ordersBuildDate,ordersMakeDate"
		+ " FROM orders where ordersID = ?";

	private static final String DELETE = "DELETE FROM orders where ordersID = ?";

	private static final String UPDATE = 
			"UPDATE orders set ordersID=?, memID=?, empCounterID=?,"
		+ " empDeliveryID=?, seatID=?, ordersType=? ,ordersAmount=?,"
		+ " ordersStatus=?, ordersDestination=?,ordersBuildDate=?," 
		+ " ordersMakeDate=?  where ordersID = ?";

	@Override
	public void insert(OrdersVO ordersVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, ordersVO.getOrdersID());
			pstmt.setInt(2, ordersVO.getMemID());
			pstmt.setInt(3, ordersVO.getEmpCounterID());
			pstmt.setInt(4, ordersVO.getEmpDeliveryID());
			pstmt.setInt(5, ordersVO.getSeatID());
			pstmt.setInt(6, ordersVO.getOrdersType());
			pstmt.setInt(7, ordersVO.getOrdersAmount());
			pstmt.setInt(8, ordersVO.getOrdersStatus());
			pstmt.setString(9, ordersVO.getOrdersDestination());
			pstmt.setTimestamp(10, ordersVO.getOrdersBuildDate());
			pstmt.setTimestamp(11, ordersVO.getOrdersMakeDate());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("Couldn't load database driver. " + se.getMessage());
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
	public void update(OrdersVO ordersVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, ordersVO.getOrdersID());
			pstmt.setInt(2, ordersVO.getMemID());
			pstmt.setInt(3, ordersVO.getEmpCounterID());
			pstmt.setInt(4, ordersVO.getEmpDeliveryID());
			pstmt.setInt(5, ordersVO.getSeatID());
			pstmt.setInt(6, ordersVO.getOrdersType());
			pstmt.setInt(7, ordersVO.getOrdersAmount());
			pstmt.setInt(8, ordersVO.getOrdersStatus());
			pstmt.setString(9, ordersVO.getOrdersDestination());
			pstmt.setTimestamp(10, ordersVO.getOrdersBuildDate());
			pstmt.setTimestamp(11, ordersVO.getOrdersMakeDate());

			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer ordersID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(8, ordersID);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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
	public OrdersVO findByPrimaryKey(Integer ordersID) {

		OrdersVO ordersVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(8, ordersID);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ordersVO = new OrdersVO();
				ordersVO.setOrdersID(rs.getInt("ordersID"));
				ordersVO.setMemID(rs.getInt("memID"));
				ordersVO.setEmpCounterID(rs.getInt("empCounterID"));
				ordersVO.setEmpDeliveryID(rs.getInt("empDeliveryID"));
				ordersVO.setSeatID(rs.getInt("seatID"));
				ordersVO.setOrdersType(rs.getInt("ordersType"));
				ordersVO.setOrdersAmount(rs.getInt("ordersAmount"));
				ordersVO.setOrdersStatus(rs.getInt("ordersStatus"));
				ordersVO.setOrdersDestination(rs.getString("ordersDestination"));
				ordersVO.setOrdersBuildDate(rs.getTimestamp("ordersBuildDate"));
				ordersVO.setOrdersMakeDate(rs.getTimestamp("ordersMakeDate"));
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return ordersVO;
	}

	@Override
	public List<OrdersVO> getAll() {
		List<OrdersVO> list = new ArrayList<OrdersVO>();
		OrdersVO ordersVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ordersVO = new OrdersVO();
				ordersVO.setOrdersID(rs.getInt("ordersID"));
				ordersVO.setMemID(rs.getInt("memID"));
				ordersVO.setEmpCounterID(rs.getInt("empCounterID"));
				ordersVO.setEmpDeliveryID(rs.getInt("empDeliveryID"));
				ordersVO.setSeatID(rs.getInt("seatID"));
				ordersVO.setOrdersType(rs.getInt("ordersType"));
				ordersVO.setOrdersAmount(rs.getInt("ordersAmount"));
				ordersVO.setOrdersStatus(rs.getInt("ordersStatus"));
				ordersVO.setOrdersDestination(rs.getString("ordersDestination"));
				ordersVO.setOrdersBuildDate(rs.getTimestamp("ordersBuildDate"));
				ordersVO.setOrdersMakeDate(rs.getTimestamp("ordersMakeDate"));
				list.add(ordersVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		return null;
	}

	public static void main(String[] args) {
		OrdersJDBCDAO jdbcdao = new OrdersJDBCDAO();

//						新增
		OrdersVO ordersVO1 = new OrdersVO();
		ordersVO1.setOrdersID(9);
		ordersVO1.setMemID(2);
		ordersVO1.setEmpCounterID(2);
		ordersVO1.setEmpDeliveryID(3);
		ordersVO1.setSeatID(5);
		ordersVO1.setOrdersType(1);
		ordersVO1.setOrdersAmount(10000);
		ordersVO1.setOrdersStatus(1);
		ordersVO1.setOrdersDestination("桃園市");
		ordersVO1.setOrdersBuildDate(Timestamp.valueOf("2020-8-22 11:11:11"));
		ordersVO1.setOrdersMakeDate(Timestamp.valueOf("2020-8-22 12:11:11"));
		jdbcdao.insert(ordersVO1);

	//修改
//	OrdersVO ordersVO2 = new OrdersVO();
//	ordersVO2.setOrdersID(88);
//	ordersVO2.setMemID(88);
//	ordersVO2.setEmpCounterID(88);
//	ordersVO2.setEmpDeliveryID(88);
//	ordersVO2.setSeatID(88);
//	ordersVO2.setOrdersType(8);
//	ordersVO2.setOrdersAmount(8);
//	ordersVO2.setOrdersStatus(8);
//	ordersVO2.setOrdersDestination("桃園市");
//	ordersVO2.setOrdersBuildDate(java.sql.Date.valueOf("2020-8-22"));
//	ordersVO2.setOrdersMakeDate(java.sql.Date.valueOf("2020-8-22"));
//	jdbcdao.update(ordersVO2);
	
	//刪除
//	dao.delete(8);
	
	
//	查詢
	OrdersVO ordersVO3 = jdbcdao.findByPrimaryKey(9);
	System.out.println(ordersVO3.getOrdersID()+",");
	System.out.println(ordersVO3.getMemID()+",");
	System.out.println(ordersVO3.getEmpCounterID()+",");
	System.out.println(ordersVO3.getEmpDeliveryID()+",");
	System.out.println(ordersVO3.getSeatID()+",");
	System.out.println(ordersVO3.getOrdersType()+",");
	System.out.println(ordersVO3.getOrdersAmount()+",");
	System.out.println(ordersVO3.getOrdersStatus()+",");
	System.out.println(ordersVO3.getOrdersDestination()+",");
	System.out.println(ordersVO3.getOrdersBuildDate()+",");
	System.out.println(ordersVO3.getOrdersMakeDate()+",");
	System.out.println("================================================");
	
	
	
	
	
	
	
	}
	
}
