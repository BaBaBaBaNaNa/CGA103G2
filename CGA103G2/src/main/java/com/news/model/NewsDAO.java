package com.news.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class NewsDAO implements NewsDAO_interface{
	private static DataSource ds = null;
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/cga103g2");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	private static final String INSERT_STMT = 
			"INSERT INTO news (empID,newsDate,newsTitle,newsInformation,newsControl,newsPictures"
			+ ") VALUES (?, ?, ?, ?, ?, ?)";

	private static final String GET_ALL_STMT = 
			"SELECT newsID,empID,newsDate,newsTitle, newsInformation,newsControl, newsPictures"
			+ " FROM news order by newsID";

	private static final String GET_ONE_STMT = 
			"SELECT newsID,empID,newsDate,newsTitle, newsInformation,newsControl, newsPictures"
			+ " FROM news where newsID = ?";

	private static final String DELETE = "DELETE FROM news where newsID = ?";

	private static final String UPDATE = 
			"UPDATE news set empID=?, newsDate=?, newsTitle=?, newsInformation=?, newsControl=?, newsPictures=? "
			+ "where newsID = ?";

	@Override
	public Integer insert(NewsVO newsVO) {
		try (
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_STMT, new String[] {"newsID"});
		) {
			pstmt.setInt(1, newsVO.getEmpID());
			pstmt.setTimestamp(2, newsVO.getNewsDate());
			pstmt.setString(3, newsVO.getNewsTitle());
			pstmt.setString(4, newsVO.getNewsInformation());
			pstmt.setInt(5, newsVO.getNewsControl());
			pstmt.setBytes(6, newsVO.getNewsPictures());
			pstmt.executeUpdate();
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				if (rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(NewsVO newsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, newsVO.getEmpID());
			pstmt.setTimestamp(2, newsVO.getNewsDate());
			pstmt.setString(3, newsVO.getNewsTitle());
			pstmt.setString(4, newsVO.getNewsInformation());
			pstmt.setInt(5, newsVO.getNewsControl());
			pstmt.setBytes(6, newsVO.getNewsPictures());
			pstmt.setInt(7, newsVO.getNewsID());
			
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
	public void delete(Integer newsID) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, newsID);

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
	public NewsVO findByPrimaryKey(Integer newsID) {

		NewsVO newsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
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
			con = ds.getConnection();
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
				newsVO.setNewsPictures(rs.getBytes("newsPictures"));
				list.add(newsVO);
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
