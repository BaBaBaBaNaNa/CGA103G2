package com.meals.model;

import java.util.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;


public class MealsJDBCDAO implements MealsDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cga103g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "0000";

	
	private static final String INSERT_STMT = "INSERT INTO meals (mealsID, mealsCategoryID, mealsName, mealsPrice, mealsInfo,mealsPicture,mealsControl) VALUES (? , ?, ? ,? ,? ,?,?)";
	private static final String GET_ALL_STMT = "SELECT mealsID, mealsCategoryID, mealsName, mealsPrice, mealsInfo,mealsPicture,mealsControl FROM meals order by mealsID";
	private static final String GET_ONE_STMT = "SELECT mealsID, mealsCategoryID, mealsName, mealsPrice, mealsInfo,mealsPicture,mealsControl  FROM meals where mealsID = ?";
	private static final String DELETE = "DELETE FROM meals where mealsID = ?";
	private static final String UPDATE = "UPDATE meals set mealsID, mealsCategoryID =?, mealsName =?, mealsPrice =?, mealsInfo =?,mealsPicture =?,mealsControl =? where mealsID = ?";

	@Override
	public void insert(MealsVO mealsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		
		InputStream fin = null;
         
		
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			

			pstmt.setInt(1, mealsVO.getMealsID());
			pstmt.setInt(2, mealsVO.getMealsCategoryID());
			pstmt.setString(3, mealsVO.getMealsName());
			pstmt.setInt(4, mealsVO.getMealsPrice());
			pstmt.setString(5, mealsVO.getMealsInfo());
			pstmt.setBytes(6, mealsVO.getMealsPicture());
			pstmt.setInt(7, mealsVO.getMealsControl());
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

			pstmt.setInt(1, mealsVO.getMealsID());
			pstmt.setInt(2, mealsVO.getMealsCategoryID());
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
				// empVo �]�٬� Domain objects
				mealsVO = new MealsVO();
				mealsVO.setMealsID(rs.getInt("Meals_id"));
				mealsVO.setMealsCategoryID(rs.getInt("Meals_category_id"));
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
				// empVO �]�٬� Domain objects
				mealsVO = new MealsVO();
				mealsVO.setMealsID(rs.getInt("Meals_id"));
				mealsVO.setMealsCategoryID(rs.getInt("Meals_category_id"));
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
	  
    static byte[] bytes;
	public static void main(String[] args)throws Exception {
		
        File file1 = new File("page1.file");

        File img = new File("tomcat.png");
        fileToByte(img);
        ByteToFile(bytes);

        
//		MealsJDBCDAO dao = new MealsJDBCDAO();
//		MealsVO mealsVO1 = new MealsVO();
//		mealsVO1.setMealsID(100);
//		mealsVO1.setMealsCategoryID(1);
//		mealsVO1.setMealsName("123");
//		mealsVO1.setMealsPrice(1);
//		mealsVO1.setMealsInfo("123");
//	mealsVO1.setMealsPicture(file.getName());
//		mealsVO1.setMealsControl(0);
//		dao.insert(mealsVO1);

	}
	 public static void fileToByte(File img) throws Exception {
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        try {
	            BufferedImage bi;
	            bi = ImageIO.read(img);
	            ImageIO.write(bi, "jpg", baos);
	            bytes = baos.toByteArray();
	            System.err.println(bytes.length);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            baos.close();
	        }
	    }
	     
	    static void ByteToFile(byte[] bytes)throws Exception{
	        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);  
	        BufferedImage bi1 =ImageIO.read(bais);
	        try {  
	            File w2 = new File("W:\\img\\00000000003.jpg");//可以是jpg,png,gif格式  
	            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }finally{
	            bais.close();
	        }
	    }
		@Override
		public List<MealsVO> getAll(Map<String, String[]> map) {
			// TODO Auto-generated method stub
			return null;
		} 
	  
	}

