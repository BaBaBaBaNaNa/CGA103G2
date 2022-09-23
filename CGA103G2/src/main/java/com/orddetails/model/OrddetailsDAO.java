package com.orddetails.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrddetailsDAO implements OrddetailsDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/cga103g2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO orddetails (orddetailsID, ordersID, mealsID, orddetailsMealsQuantity,"
			+ "orddetailsMealsAmount, orddetailsMealsStatus, orddetailsDeliverStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT orddetailsID, ordersID, mealsID, orddetailsMealsQuantity,"
			+ "orddetailsMealsAmount, orddetailsMealsStatus, orddetailsDeliverStatus"
			+ " FROM orddetails";

	private static final String GET_ONE_STMT = "SELECT orddetailsID, ordersID, mealsID, orddetailsMealsQuantity,"
			+ "orddetailsMealsAmount, orddetailsMealsStatus, orddetailsDeliverStatus "
			+ "FROM orddetails where orddetailsID = ?";
	
	private static final String GET_ONES_STMT = "SELECT orddetailsID, ordersID, mealsID, orddetailsMealsQuantity,"
			+ "orddetailsMealsAmount, orddetailsMealsStatus, orddetailsDeliverStatus "
			+ "FROM orddetails where ordersID = ?";

	private static final String DELETE = "DELETE FROM orddetails where orddetailsID = ?";

	private static final String UPDATE = "UPDATE orddetails set ordersID=?, mealsID=?,"
			+ " orddetailsMealsQuantity=?, orddetailsMealsAmount=?, "
			+ "orddetailsMealsStatus=? ,orddetailsDeliverStatus=?  where orddetailsID = ?";

//	@Override
	public void insert(OrddetailsVO orddetailsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, orddetailsVO.getOrddetailsID());
			pstmt.setInt(2, orddetailsVO.getOrdersID());
			pstmt.setInt(3, orddetailsVO.getMealsID());
			pstmt.setInt(4, orddetailsVO.getOrddetailsMealsQuantity());
			pstmt.setInt(5, orddetailsVO.getOrddetailsMealsAmount());
			pstmt.setInt(6, orddetailsVO.getOrddetailsMealsStatus());
			pstmt.setInt(7, orddetailsVO.getOrddetailsDeliverStatus());

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
	public void update(OrddetailsVO orddetailsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, orddetailsVO.getOrdersID())	;
			pstmt.setInt(2, orddetailsVO.getMealsID());
			pstmt.setInt(3, orddetailsVO.getOrddetailsMealsQuantity());
			pstmt.setInt(4, orddetailsVO.getOrddetailsMealsAmount());
			pstmt.setInt(5, orddetailsVO.getOrddetailsMealsStatus());
			pstmt.setInt(6, orddetailsVO.getOrddetailsDeliverStatus());
			pstmt.setInt(7, orddetailsVO.getOrddetailsID());

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
	public void delete(Integer orddetailsID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, orddetailsID);

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
	public OrddetailsVO findByPrimaryKey1(Integer orddetailsID) {

		OrddetailsVO orddetailsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
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
		return orddetailsVO;
	}
	
	@Override
	public List<OrddetailsVO> findByPrimaryKey(Integer ordersID) {

		OrddetailsVO orddetailsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONES_STMT);

			pstmt.setInt(1, ordersID);

			rs = pstmt.executeQuery();
			List<OrddetailsVO> list = new ArrayList<>();
			while (rs.next()) {
				orddetailsVO = new OrddetailsVO();
				orddetailsVO.setOrddetailsID(rs.getInt("orddetailsID"));
				orddetailsVO.setOrdersID(rs.getInt("ordersID"));
				orddetailsVO.setMealsID(rs.getInt("mealsID"));
				orddetailsVO.setOrddetailsMealsQuantity(rs.getInt("orddetailsMealsQuantity"));
				orddetailsVO.setOrddetailsMealsAmount(rs.getInt("orddetailsMealsAmount"));
				orddetailsVO.setOrddetailsMealsStatus(rs.getInt("orddetailsMealsStatus"));
				orddetailsVO.setOrddetailsDeliverStatus(rs.getInt("orddetailsDeliverStatus"));
				list.add(orddetailsVO);
			}
			return list;
			// Handle any driver errors
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

	}

	@Override
	public List<OrddetailsVO> getAll() {
		List<OrddetailsVO> list = new ArrayList<OrddetailsVO>();
		OrddetailsVO orddetailsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
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
				orddetailsVO.setOrddetailsDeliverStatus(rs.getInt("orddetailsDeliverStatus"));
				list.add(orddetailsVO);
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
