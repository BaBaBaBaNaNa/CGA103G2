package com.meals.modle;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.MealsCategory.model.MealsCategoryVO;

import java.sql.*;

public class MealsDAO implements MealsDAO_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/restaurant2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_STMT = "INSERT INTO meals (meals_id, meals_category_id, meals_name, meals_price, meals_info,meals_control) VALUES (? , ?, ? ,? ,? ,?)";
	private static final String GET_ALL_STMT = "SELECT meals_id, meals_category_id, meals_name, meals_price, meals_info,meals_control FROM meals order by meals_id";
	private static final String GET_ONE_STMT = "SELECT meals_id, meals_category_id, meals_name, meals_price, meals_info,meals_control  FROM meals where meals_id = ?";
	private static final String DELETE = "DELETE FROM meals where meals_id = ?";

	@Override
	public void insert(MealsVO mealsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, mealsVO.getMealsId());
			pstmt.setInt(2, mealsVO.getMealsCategoryId());
			pstmt.setString(3, mealsVO.getMealsName());
			pstmt.setInt(4, mealsVO.getMealsPrice());
			pstmt.setString(5, mealsVO.getMealsInfo());
//			pstmt.setBlob(6, mealsVO.getmeals_picture());
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
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mealsVO.getMealsId());
			pstmt.setInt(2, mealsVO.getMealsCategoryId());
			pstmt.setString(3, mealsVO.getMealsName());
			pstmt.setInt(4, mealsVO.getMealsPrice());
			pstmt.setString(5, mealsVO.getMealsInfo());
//			pstmt.setBlob(6, mealsVO.getmeals_picture());
			pstmt.setInt(6, mealsVO.getMealsControl());

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
	public void delete(Integer mealsId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mealsId);

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
	public MealsVO findByPrimaryKey(Integer mealsId) {

		MealsVO mealsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mealsId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				mealsVO = new MealsVO();
				mealsVO.setMealsId(rs.getInt("meals_id"));
				mealsVO.setMealsCategoryId(rs.getInt("meals_category_id"));
				mealsVO.setMealsName(rs.getString("meals_name"));
				mealsVO.setMealsPrice(rs.getInt("meals_price"));
				mealsVO.setMealsInfo(rs.getString("meals_info"));
//				mealsVO.setmeals_picture(null);
				mealsVO.setMealsControl(rs.getInt("meals_control"));
			
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
				// empVO ¤]ºÙ¬° Domain objects
				mealsVO = new MealsVO();
				mealsVO.setMealsId(rs.getInt("meals_id"));
				mealsVO.setMealsCategoryId(rs.getInt("meals_category_id"));
				mealsVO.setMealsName(rs.getString("meals_name"));
				mealsVO.setMealsPrice(rs.getInt("meals_price"));
				mealsVO.setMealsInfo(rs.getString("meals_info"));
//				mealsVO.setmeals_picture(null);
				mealsVO.setMealsControl(rs.getInt("meals_control"));
				
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

}
