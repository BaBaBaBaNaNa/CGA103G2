package com.meals.modle;

import java.util.*;
import java.sql.*;


public class MealsJDBCDAO implements MealsDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/restaurant?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "0000";

	
	private static final String INSERT_STMT = 
		"INSERT INTO meals (meals_id, meals_category_id, meals_name, meals_price, meals_info,meals_control) VALUES (? , ?, ? ,? ,? ,?)";
	private static final String GET_ALL_STMT = 
		"SELECT meals_id, meals_category_id, meals_name, meals_price, meals_info,meals_control FROM meals order by meals_id";
	private static final String GET_ONE_STMT = 
		"SELECT meals_id, meals_category_id, meals_name, meals_price, meals_info,meals_control  FROM meals where meals_id = ?";
	private static final String DELETE = 
		"DELETE FROM meals where meals_id = ?";
	private static final String UPDATE = 
		"UPDATE meals set  meals_category_id=?, meals_name = ? ,meals_price = ? , meals_info = ? ,meals_control = ?  where meals_id = ?";
	@Override
	public void insert(MealsVO mealsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, mealsVO.getMealsId());
			pstmt.setInt(2, mealsVO.getMealsCategoryId());
			pstmt.setString(3, mealsVO.getMealsName());
			pstmt.setInt(4, mealsVO.getMealsPrice());
			pstmt.setString(5, mealsVO.getMealsInfo());
			pstmt.setInt(6, mealsVO.getMealsControl());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, mealsVO.getMealsId());
			pstmt.setInt(2, mealsVO.getMealsCategoryId());
			pstmt.setString(3, mealsVO.getMealsName());
			pstmt.setInt(4, mealsVO.getMealsPrice());
			pstmt.setString(5, mealsVO.getMealsInfo());
			pstmt.setInt(6, mealsVO.getMealsControl());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public void delete(Integer meals_id) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, meals_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
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
	public MealsVO findByPrimaryKey(Integer meals_id) {

		MealsVO mealsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, meals_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				mealsVO = new MealsVO();
				mealsVO.setMealsId(rs.getInt("Meals_id"));
				mealsVO.setMealsCategoryId(rs.getInt("Meals_category_id"));
				mealsVO.setMealsName(rs.getString("Meals_name"));
				mealsVO.setMealsPrice(rs.getInt("Meals_price"));
				mealsVO.setMealsInfo(rs.getNString("Meals_info"));;
				mealsVO.setMealsControl(rs.getInt("Meals_control"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				mealsVO = new MealsVO();
				mealsVO.setMealsId(rs.getInt("Meals_id"));
				mealsVO.setMealsCategoryId(rs.getInt("Meals_category_id"));
				mealsVO.setMealsName(rs.getString("Meals_name"));
				mealsVO.setMealsPrice(rs.getInt("Meals_price"));
				mealsVO.setMealsInfo(rs.getNString("Meals_info"));;
				mealsVO.setMealsControl(rs.getInt("Meals_control"));
				
				list.add(mealsVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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
	public static void main(String[] args) {

		MealsJDBCDAO dao = new MealsJDBCDAO();

		// 新增
		MealsVO mealsVO1 = new MealsVO();
		mealsVO1.setMealsId(100);
		mealsVO1.setMealsCategoryId(1);
		mealsVO1.setMealsName("123");
		mealsVO1.setMealsPrice(1);
		mealsVO1.setMealsInfo("123");
		mealsVO1.setMealsControl(0);
		dao.insert(mealsVO1);

		// 修改
		MealsVO mealsVO2 = new MealsVO();
	
		mealsVO2.setMealsId(100);
		mealsVO2.setMealsCategoryId(1);
		mealsVO2.setMealsName("1234");
		mealsVO2.setMealsPrice(1);
		mealsVO2.setMealsInfo("12");
		mealsVO2.setMealsControl(0);
		dao.update(mealsVO2);

		// 刪除
		dao.delete(100);

		// 查詢
		MealsVO mealsVO3 = dao.findByPrimaryKey(1);
		System.out.print(mealsVO3.getMealsId() + ",");
		System.out.print(mealsVO3.getMealsCategoryId() + ",");
		System.out.print(mealsVO3.getMealsName() + ",");
		System.out.print(mealsVO3.getMealsPrice() + ",");
		System.out.print(mealsVO3.getMealsInfo() + ",");
		System.out.print(mealsVO3.getMealsControl() + ",");
		System.out.println("---------------------");

		// 查詢
		List<MealsVO> list = dao.getAll();
		for (MealsVO aEmp : list) {
			System.out.print(aEmp.getMealsId() + ",");
			System.out.print(aEmp.getMealsCategoryId() + ",");
			System.out.print(aEmp.getMealsName() + ",");
			System.out.print(aEmp.getMealsPrice() + ",");
			System.out.print(aEmp.getMealsInfo() + ",");
			System.out.print(aEmp.getMealsControl() + ",");
			System.out.println();
		}
	}

	
}
