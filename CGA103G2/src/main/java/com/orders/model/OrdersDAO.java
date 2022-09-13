package com.orders.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrdersDAO implements OrdersDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/cga103g2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO orders (ordersID,memID,empCounterID,empDeliveryID,seatID,ordersType"
			+ ",ordersAmount,ordersStatus,ordersDestination,ordersBuildDate,ordersMakeDate"
			+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT ordersID,memID,empCounterID,empDeliveryID,seatID,ordersType"
			+ "	,ordersAmount,ordersStatus,ordersDestination,ordersBuildDate,ordersMakeDate"
			+ " FROM orders order by ordersID";

	private static final String GET_ONE_STMT = "SELECT ordersID,memID,empCounterID,empDeliveryID,seatID,ordersType"
			+ ",ordersAmount,ordersStatus,ordersDestination,ordersBuildDate,ordersMakeDate"
			+ " FROM orders where ordersID = ?";

	private static final String DELETE = "DELETE FROM orders where ordersID = ?";

	private static final String UPDATE = "UPDATE orders set memID=?, empCounterID=?,"
			+ " empDeliveryID=?, seatID=?, ordersType=? ,ordersAmount=?,"
			+ " ordersStatus=?, ordersDestination=?,ordersBuildDate=?," + " ordersMakeDate=?  where ordersID = ?";

//	@Override
	public void insert(OrdersVO ordersVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
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

	@Override
	public void update(OrdersVO ordersVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, ordersVO.getMemID());
			pstmt.setInt(2, ordersVO.getEmpCounterID());
			pstmt.setInt(3, ordersVO.getEmpDeliveryID());
			pstmt.setInt(4, ordersVO.getSeatID());
			pstmt.setInt(5, ordersVO.getOrdersType());
			pstmt.setInt(6, ordersVO.getOrdersAmount());
			pstmt.setInt(7, ordersVO.getOrdersStatus());
			pstmt.setString(8, ordersVO.getOrdersDestination());
			pstmt.setTimestamp(9, ordersVO.getOrdersBuildDate());
			pstmt.setTimestamp(10, ordersVO.getOrdersMakeDate());
			pstmt.setInt(11, ordersVO.getOrdersID());

			pstmt.executeUpdate();

			// Handle any driver errors
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

	@Override
	public void delete(Integer ordersID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, ordersID);

			pstmt.executeUpdate();

			// Handle any driver errors
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

	@Override
	public OrdersVO findByPrimaryKey(Integer ordersID) {

		OrdersVO ordersVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, ordersID);

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

			// Handle any driver errors
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
			con = ds.getConnection();
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
			// Handle any driver errors
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
		return list;
	}

}
