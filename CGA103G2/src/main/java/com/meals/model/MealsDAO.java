package com.meals.model;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import java.sql.*;

public class MealsDAO implements MealsDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cga103g2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_STMT = "INSERT INTO meals (mealsCategoryID, mealsName, mealsPrice, mealsInfo,mealsPicture,mealsControl) VALUES (? , ?, ? ,? ,? ,?)";
	private static final String GET_ALL_STMT = "SELECT mealsID, mealsCategoryID, mealsName, mealsPrice, mealsInfo,mealsControl FROM meals order by mealsID";
	private static final String GET_ONE_STMT = "SELECT mealsID, mealsCategoryID, mealsName, mealsPrice, mealsInfo,mealsPicture,mealsControl  FROM meals where mealsID = ?";
	private static final String DELETE = "DELETE FROM meals where mealsID = ?";
	private static final String UPDATE = "UPDATE meals set  mealsCategoryID =?, mealsName =?, mealsPrice =?, mealsInfo =?,mealsPicture =?,mealsControl =? where mealsID = ?";

	@Override
	public void insert(MealsVO mealsVO) {
		

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, mealsVO.getMealsCategoryID());
			pstmt.setString(2, mealsVO.getMealsName());
			pstmt.setInt(3, mealsVO.getMealsPrice());
			pstmt.setString(4, mealsVO.getMealsInfo());
			pstmt.setBytes(5, mealsVO.getMealsPicture());
			pstmt.setInt(6, mealsVO.getMealsControl());

			pstmt.executeUpdate();

			// Handle any SQL errors
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
	public void update(MealsVO mealsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, mealsVO.getMealsCategoryID());
			pstmt.setString(2, mealsVO.getMealsName());
			pstmt.setInt(3, mealsVO.getMealsPrice());
			pstmt.setString(4, mealsVO.getMealsInfo());
			pstmt.setBytes(5, mealsVO.getMealsPicture());
			pstmt.setInt(6, mealsVO.getMealsControl());
			pstmt.setInt(7, mealsVO.getMealsID());

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
	public void delete(Integer mealsID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mealsID);

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
	public MealsVO findByPrimaryKey(Integer mealsID) {

		MealsVO mealsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mealsID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				mealsVO = new MealsVO();
				mealsVO.setMealsID(rs.getInt("mealsID"));
				mealsVO.setMealsCategoryID(rs.getInt("mealsCategoryID"));
				mealsVO.setMealsName(rs.getString("mealsName"));
				mealsVO.setMealsPrice(rs.getInt("mealsPrice"));
				mealsVO.setMealsInfo(rs.getString("mealsInfo"));
				mealsVO.setMealsPicture(rs.getBytes("mealsPicture"));
				mealsVO.setMealsControl(rs.getInt("mealsControl"));
			
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
		return mealsVO;
	}

	@Override
	public List<MealsVO> getAll() {
		List<MealsVO> list = new ArrayList<MealsVO>();
		MealsVO mealsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				mealsVO = new MealsVO();
				mealsVO.setMealsID(rs.getInt("mealsID"));
				mealsVO.setMealsCategoryID(rs.getInt("mealsCategoryID"));
				mealsVO.setMealsName(rs.getString("mealsName"));
				mealsVO.setMealsPrice(rs.getInt("mealsPrice"));
				mealsVO.setMealsInfo(rs.getString("mealsInfo"));
//				mealsVO.setMealsPicture(rs.getBytes("mealsPicture"));
				mealsVO.setMealsControl(rs.getInt("mealsControl"));
				
				list.add(mealsVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	 public List<MealsVO> getAll(Map<String, String[]> map){
		 List<MealsVO> list = new ArrayList<MealsVO>();
		 MealsVO mealsVO = null;
		
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			try {
				
				con = ds.getConnection();
				String finalSQL = "select * from meals "
			          + MealsCompositeQuery.get_WhereCondition(map)
			          + "order by mealsCategoryID";
				pstmt = con.prepareStatement(finalSQL);
				System.out.println("●●finalSQL(by DAO) = "+finalSQL);
				rs = pstmt.executeQuery();
		
				while (rs.next()) {
					mealsVO = new MealsVO();
					mealsVO.setMealsID(rs.getInt("mealsID"));
					mealsVO.setMealsCategoryID(rs.getInt("mealsCategoryID"));
					mealsVO.setMealsName(rs.getString("mealsName"));
					mealsVO.setMealsPrice(rs.getInt("mealsPrice"));
					mealsVO.setMealsInfo(rs.getString("mealsInfo"));
//					mealsVO.setMealsPicture(rs.getBytes("mealsPicture"));
					mealsVO.setMealsControl(rs.getInt("mealsControl"));
					list.add(mealsVO); // Store the row in the List
				}
		
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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

	@Override
	public List<MealsVO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
