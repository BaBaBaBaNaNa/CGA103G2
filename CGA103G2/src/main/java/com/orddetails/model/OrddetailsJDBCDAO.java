package com.orddetails.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrddetailsJDBCDAO implements OrddetailsDAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cga103g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1215";
	
	private static final String INSERT_STMT = 
		"INSERT INTO orddetails (orddetailsID, ordersID, mealsID, orddetailsMealsQuantity,"
		+ "orddetailsMealsAmount, orddetailsMealsStatus, orddetailsDeliverStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String GET_ALL_STMT = 
		"SELECT orddetailsID, ordersID, mealsID, orddetailsMealsQuantity,"
		+ "orddetailsMealsAmount, orddetailsMealsStatus, orddetailsDeliverStatus"
		+ " FROM orddetails";
	private static final String GET_ONE_STMT = 
			"SELECT orddetailsID, ordersID, mealsID, orddetailsMealsQuantity,"
			+ "orddetailsMealsAmount, orddetailsMealsStatus, orddetailsDeliverStatus "
			+ "FROM orddetails where orddetailsID = ?";
	
	private static final String GET_ONES_STMT = 
		"SELECT orddetailsID, ordersID, mealsID, orddetailsMealsQuantity,"
		+ "orddetailsMealsAmount, orddetailsMealsStatus, orddetailsDeliverStatus "
		+ "FROM orddetails where orddetailsID = ?";
		
	private static final String DELETE = 
		"DELETE FROM orddetails where orddetailsID = ?";
		
	private static final String UPDATE = 
			"UPDATE orders set  ordersID=?, mealsID=?,"
		+ " orddetailsMealsQuantity=?, orddetailsMealsAmount=?, "
		+ "orddetailsMealsStatus=? ,orddetailsDeliverStatus=?,"
		+ "where orddetailsID = ?";

	@Override
	public void insert(OrddetailsVO orddetailsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, orddetailsVO.getOrddetailsID());
			pstmt.setInt(2, orddetailsVO.getOrdersID());
			pstmt.setInt(3, orddetailsVO.getMealsID());
			pstmt.setInt(4, orddetailsVO.getOrddetailsMealsQuantity());
			pstmt.setInt(5, orddetailsVO.getOrddetailsMealsAmount());
			pstmt.setInt(6, orddetailsVO.getOrddetailsMealsStatus());
			pstmt.setInt(7, orddetailsVO.getOrddetailsDeliverStatus());
			
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
	public void update(OrddetailsVO orddetailsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, orddetailsVO.getOrddetailsID());
			pstmt.setInt(2, orddetailsVO.getOrdersID());
			pstmt.setInt(3, orddetailsVO.getMealsID());
			pstmt.setInt(4, orddetailsVO.getOrddetailsMealsQuantity());
			pstmt.setInt(5, orddetailsVO.getOrddetailsMealsAmount());
			pstmt.setInt(6, orddetailsVO.getOrddetailsMealsStatus());
			pstmt.setInt(7, orddetailsVO.getOrddetailsDeliverStatus());
			
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

			pstmt.setInt(1, ordersID);

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
	public OrddetailsVO findByPrimaryKey1(Integer orddetailsID) {

		OrddetailsVO orddetailsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, orddetailsID);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				orddetailsVO = new OrddetailsVO();
				orddetailsVO.setOrddetailsID(rs.getInt("orddetailsID"));
				orddetailsVO.setOrdersID(rs.getInt("ordersID"));
				orddetailsVO.setMealsID(rs.getInt("mealsID"));
				orddetailsVO.setOrddetailsMealsQuantity(rs.getInt("orddetailsMealsQuantity"));
				orddetailsVO.setOrddetailsMealsAmount(rs.getInt("orddetailsMealsAmount"));
				orddetailsVO.setOrddetailsMealsStatus(rs.getInt("orddetailsMealsStatus"));
				orddetailsVO.setOrddetailsDeliverStatus(rs.getInt("orddetailsDeliverStatus"));
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
		return orddetailsVO;
	}
	
	@Override
	public List<OrddetailsVO> findByPrimaryKey(Integer orddetailsID) {

		OrddetailsVO orddetailsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONES_STMT);

			pstmt.setInt(1, orddetailsID);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				orddetailsVO = new OrddetailsVO();
				orddetailsVO.setOrddetailsID(rs.getInt("orddetailsID"));
				orddetailsVO.setOrdersID(rs.getInt("ordersID"));
				orddetailsVO.setMealsID(rs.getInt("mealsID"));
				orddetailsVO.setOrddetailsMealsQuantity(rs.getInt("orddetailsMealsQuantity"));
				orddetailsVO.setOrddetailsMealsAmount(rs.getInt("orddetailsMealsAmount"));
				orddetailsVO.setOrddetailsMealsStatus(rs.getInt("orddetailsMealsStatus"));
				orddetailsVO.setOrddetailsDeliverStatus(rs.getInt("orddetailsDeliverStatus"));
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
		return (List<OrddetailsVO>) orddetailsVO;
	}

	@Override
	public List<OrddetailsVO> getAll() {
		List<OrddetailsVO> list = new ArrayList<OrddetailsVO>();
		OrddetailsVO orddetailsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orddetailsVO = new OrddetailsVO();
				orddetailsVO.setOrddetailsID(rs.getInt("orddetailsID"));
				orddetailsVO.setOrdersID(rs.getInt("ordersID"));
				orddetailsVO.setMealsID(rs.getInt("mealsID"));
				orddetailsVO.setOrddetailsMealsQuantity(rs.getInt("orddetailsMealsQuantity"));
				orddetailsVO.setOrddetailsMealsAmount(rs.getInt("orddetailsMealsAmount"));
				orddetailsVO.setOrddetailsMealsStatus(rs.getInt("orddetailsMealsStatus"));
				orddetailsVO.setOrddetailsDeliverStatus(rs.getInt("orddetailsDeliverStatus"));				list.add(orddetailsVO);
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

}
