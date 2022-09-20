package com.news.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsJDBCDAO implements NewsDAO_interface{
	String driver = "";
	String url = "jdbc:mysql://localhost:3306/cga103g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1215";

	private static final String INSERT_STMT = "INSERT INTO news (newsID,empID,newsDate,newsTitle,"
			+ "newsInformation,newsControl,newsPictures" + ") VALUES (?, ?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = "SELECT newsID,empID,newsDate,newsTitle"
			+ "	,newsInformation,newsControl" + " FROM news order by newsID";

	private static final String GET_ONE_STMT = "SELECT newsID,empID,newsDate,newsTitle"
			+ ",newsInformation,newsControl,newsPictures" + " FROM news where newsID = ?";

	private static final String DELETE = "DELETE FROM news where newsID = ?";

	private static final String UPDATE = "UPDATE news set newsID=?, empID=?,"
			+ " newsDate=?, newsTitle=?, newsControl=? ,newsPictures=?," + "  where newsID = ?";

	@Override
	public Integer insert(NewsVO newsVO) {

//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(INSERT_STMT);
//
//			pstmt.setInt(1, newsVO.getNewsID());
//			pstmt.setInt(2, newsVO.getEmpID());
//			pstmt.setTimestamp(3, newsVO.getNewsDate());
//			pstmt.setString(4, newsVO.getNewsTitle());
//			pstmt.setString(5, newsVO.getNewsInformation());
//			pstmt.setInt(6, newsVO.getNewsControl());
//			pstmt.setBytes(7, newsVO.getNewsPictures());
//
//			pstmt.executeUpdate();
//
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//		} catch (SQLException se) {
//			throw new RuntimeException("Couldn't load database driver. " + se.getMessage());
//		} finally {
//			if (pstmt != null) {
//				try {
//					pstmt.close();
//				} catch (SQLException se) {
//					se.printStackTrace(System.err);
//				}
//			}
//			if (con != null) {
//				try {
//					con.close();
//				} catch (Exception e) {
//					e.printStackTrace(System.err);
//				}
//			}
//		}
		return null;
	}

	@Override
	public void update(NewsVO newsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, newsVO.getNewsID());
			pstmt.setInt(2, newsVO.getEmpID());
			pstmt.setTimestamp(3, newsVO.getNewsDate());
			pstmt.setString(4, newsVO.getNewsTitle());
			pstmt.setString(5, newsVO.getNewsInformation());
			pstmt.setInt(6, newsVO.getNewsControl());
			pstmt.setBytes(7, newsVO.getNewsPictures());

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void delete(Integer newsID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, newsID);

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public NewsVO findByPrimaryKey(Integer newsID) {

		NewsVO newsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, newsID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				newsVO = new NewsVO();
				newsVO.setNewsID(rs.getInt("newsID"));
				newsVO.setEmpID(rs.getInt("empID"));
				newsVO.setNewsDate(rs.getTimestamp("newsDate"));
				newsVO.setNewsTitle(rs.getString("newsTitle"));
				newsVO.setNewsInformation(rs.getString("newsInformation"));
				newsVO.setNewsControl(rs.getInt("newsControl"));
				newsVO.setNewsPictures(rs.getBytes("newsPictures"));
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
		return newsVO;
	}

	@Override
	public List<NewsVO> getAll() {
		List<NewsVO> list = new ArrayList<NewsVO>();
		NewsVO newsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				newsVO = new NewsVO();
				newsVO.setNewsID(rs.getInt("newsID"));
				newsVO.setEmpID(rs.getInt("empID"));
				newsVO.setNewsDate(rs.getTimestamp("newsDate"));
				newsVO.setNewsTitle(rs.getString("newsTitle"));
				newsVO.setNewsInformation(rs.getString("newsInformation"));
				newsVO.setNewsControl(rs.getInt("newsControl"));
				list.add(newsVO);
			}
			// Handle any driver errors
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
		return list;
	}
}
