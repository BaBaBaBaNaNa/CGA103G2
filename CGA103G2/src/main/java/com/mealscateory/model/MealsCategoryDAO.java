package com.mealscateory.model;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.emp.model.EmpCompositeQuery;
import com.emp.model.EmpVO;
import com.job.model.JobVO;
import com.meals.model.MealsVO;

import java.sql.*;

public class MealsCategoryDAO implements MealsCategory_interface {
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cga103g2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	private static final String INSERT_STMT = "INSERT INTO mealscategory (mealsCategory) VALUES (?)";
	private static final String GET_ALL_STMT = "SELECT  mealsCategoryID,mealsCategory FROM mealscategory order by mealsCategoryID";
	private static final String GET_ONE_STMT = "SELECT mealsCategoryID,mealsCategory FROM mealscategory where mealsCategoryID = ?";
	private static final String DELETE = "DELETE FROM mealscategory where mealsCategoryID = ?";
	private static final String UPDATE = "UPDATE mealscategory set mealsCategory=? where mealsCategoryID = ?";
	
	private static final String GET_Meals_ByMealsCategoryID_STMT = "SELECT mealsID,mealsCategoryID,mealsName,mealsPrice,mealsInfo,mealsPicture,mealsControl FROM meals where mealsCategoryID = ? order by mealsID";
	
	private static final String MealsCategoryCheck= "SELECT mealscategory FROM mealscategory where mealscategory = ?";
	@Override
	public void insert(MealsCategoryVO mealsCategoryVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, mealsCategoryVO.getMealsCategory());

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
	public void update(MealsCategoryVO mealsCategoryVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, mealsCategoryVO.getMealsCategory());
			pstmt.setInt(2, mealsCategoryVO.getMealsCategoryId());

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
	public void delete(Integer mealsCategoryID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mealsCategoryID);

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
	public MealsCategoryVO findByPrimaryKey(Integer mealsCategoryID) {

		MealsCategoryVO mealsCategoryVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mealsCategoryID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				mealsCategoryVO = new MealsCategoryVO();
				mealsCategoryVO.setMealsCategoryId(rs.getInt("mealsCategoryID"));
				mealsCategoryVO.setMealsCategory(rs.getString("mealsCategory"));
			
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
		return mealsCategoryVO;
	}

	@Override
	public List<MealsCategoryVO> getAll() {
		List<MealsCategoryVO> list = new ArrayList<MealsCategoryVO>();
		MealsCategoryVO mealsCategoryVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				mealsCategoryVO = new MealsCategoryVO();
				mealsCategoryVO.setMealsCategoryId(rs.getInt("mealsCategoryID"));
				mealsCategoryVO.setMealsCategory(rs.getString("mealsCategory"));
				
				list.add(mealsCategoryVO); // Store the row in the list
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

	@Override
	public List<MealsCategoryVO> getAll(Map<String, String[]> map) {
		List<MealsCategoryVO> list = new ArrayList<MealsCategoryVO>();
		MealsCategoryVO mealsCategoryVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = ds.getConnection();
			String finalSQL = "select * from MealsCategory "
		          + EmpCompositeQuery.getWhereCondition(map)
		          + "order by mealsCategoryID";
			pstmt = con.prepareStatement(finalSQL);
			System.out.println("●●finalSQL(by DAO) = "+finalSQL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				mealsCategoryVO = new MealsCategoryVO();
				
				
				mealsCategoryVO.setMealsCategoryId(rs.getInt("mealsCategoryID"));
				mealsCategoryVO.setMealsCategory(rs.getString("mealsCategory"));

				
				list.add(mealsCategoryVO); // Store the row in the List
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
	   public Set<MealsVO> getMealsByMealsCategoryID(Integer mealsCategoryID){
		   Set<MealsVO> set = new LinkedHashSet<MealsVO>();
		   MealsVO mealsVO = null;
		
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			try {
		
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_Meals_ByMealsCategoryID_STMT);
				pstmt.setInt(1, mealsCategoryID);
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
				
					set.add(mealsVO); // Store the row in the vector
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
			return set;
	   }

	@Override
	public MealsCategoryVO checkRepeatMealsCategoryName(String mealsCategory) {
		MealsCategoryVO mealsCategoryVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(MealsCategoryCheck);
			
			pstmt.setString(1, mealsCategory);
			
			rs = pstmt.executeQuery();
//			System.out.println(rs);
			while (rs.next()) {
				// empVo 也稱為 Domain objects
				mealsCategoryVO = new MealsCategoryVO();

				mealsCategoryVO.setMealsCategory(rs.getString("mealsCategory"));
				
			}
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
		return mealsCategoryVO;
	
	}

}
