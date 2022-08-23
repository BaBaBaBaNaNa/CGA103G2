package com.mem.model;

import java.util.*;

import com.emp.model.EmpJDBCDAO;
import com.emp.model.EmpVO;
import com.mem.model.MemVO;

import java.sql.*;
import java.sql.Date;

//進入DB ->五種功能:INSERT_STMT /  GET_ALL_STMT / GET_ONE_STMT / DELETE / UPDATE
public class MemJDBCDAO implements MemDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/restaurant?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "root";
	private static final String INSERT_STMT = "INSERT INTO members (mem_id,mem_name,mem_account,mem_password,mem_gender,mem_phone,mem_email,mem_address,mem_birthday,mem_permission) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	private static final String GET_ALL_STMT = "SELECT mem_id, mem_name, mem_account, mem_password, mem_gender, mem_phone, mem_email, mem_address, mem_birthday, mem_permission FROM members order by mem_id";
	private static final String GET_ONE_STMT = "SELECT mem_id, mem_name, mem_account, mem_password, mem_gender, mem_phone, mem_email, mem_address, mem_birthday, mem_permission FROM members  where mem_id";
	private static final String DELETE = "DELETE FROM members where mem_id = ?";
	private static final String UPDATE = "Update membersUpdate set mem_name=?, mem_account=?, mem_password=?, mem_gender=?, mem_phone=?, mem_email=?, mem_address=?, mem_birthday=?, mem_permission=? where mem_id = ?";

	@Override
	public void insert(MemVO memVO) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt =  conn.prepareStatement(INSERT_STMT)){
//			
//			設定: 設立下一段需使用的參數
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(INSERT_STMT);

//			pstmt.setString(1,memVO,getMem_id());
			pstmt.setInt(1, memVO.getMem_id());
			pstmt.setString(2, memVO.getMem_name());
			pstmt.setString(3, memVO.getMem_account());
			pstmt.setString(4, memVO.getMem_password());
			pstmt.setInt(5, memVO.getMem_gender());
			pstmt.setInt(6, memVO.getMem_phone());
			pstmt.setString(7, memVO.getMem_email());
			pstmt.setString(8, memVO.getMem_address());
			pstmt.setDate(9, memVO.getMem_birthday());
			pstmt.setInt(10, memVO.getMem_permission());

			pstmt.executeUpdate();
			System.out.println("insert done!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
			// Handle any driver errors
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
//			// Handle any SQL errors
//		} catch (SQLException se) {
//			throw new RuntimeException("A database error occured. " + se.getMessage());
//			// Clean up JDBC resources
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

	}

	@Override
	public void update(MemVO memVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, memVO.getMem_id());
			pstmt.setString(2, memVO.getMem_name());
			pstmt.setString(3, memVO.getMem_account());
			pstmt.setString(4, memVO.getMem_password());
			pstmt.setInt(5, memVO.getMem_gender());
			pstmt.setInt(6, memVO.getMem_phone());
			pstmt.setString(7, memVO.getMem_email());
			pstmt.setString(8, memVO.getMem_address());
			pstmt.setDate(9, memVO.getMem_birthday());
			pstmt.setInt(10, memVO.getMem_permission());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public void delete(Integer mem_id) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, userid, passwd);
		pstmt = con.prepareStatement(DELETE);
		
		pstmt.setInt(1, mem_id);
		
		pstmt.executeUpdate();
		
		// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
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
	public MemVO findByPrimaryKey(Integer mem_id) {

		MemVO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mem_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memVO = new MemVO();
				
				pstmt.setInt(1, memVO.getMem_id());
				pstmt.setString(2, memVO.getMem_name());
				pstmt.setString(3, memVO.getMem_account());
				pstmt.setString(4, memVO.getMem_password());
				pstmt.setInt(5, memVO.getMem_gender());
				pstmt.setInt(6, memVO.getMem_phone());
				pstmt.setString(7, memVO.getMem_email());
				pstmt.setString(8, memVO.getMem_address());
				pstmt.setDate(9, memVO.getMem_birthday());
				pstmt.setInt(10, memVO.getMem_permission());
				
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
					return memVO;
				}
	
	@Override
	public List<MemVO> getAll() {
		List<MemVO> list = new ArrayList<MemVO>();
		MemVO memVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				memVO = new MemVO();
				
				memVO.setMem_id(rs.getInt("mem_id"));
				memVO.setMem_name(rs.getString("mem_name"));
				memVO.setMem_account(rs.getString("mem_account"));
				memVO.setMem_password(rs.getString("mem_password"));
				memVO.setMem_gender(rs.getInt("mem_gender"));
				memVO.setMem_phone(rs.getInt("mem_phone"));
				memVO.setMem_email(rs.getString("mem_email"));
				memVO.setMem_address(rs.getString("msm_address"));
				memVO.setMem_birthday(rs.getDate("mem_birthday"));
				memVO.setMem_permission(rs.getInt("mem_permission"));
				list.add(memVO); // Store the row in the list
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
	
	public static void main(String[] args) {

		MemJDBCDAO dao = new MemJDBCDAO();
		
		// 新增
		MemVO memVO1 = new MemVO();
		memVO1.setMem_id(11);
		memVO1.setMem_name("LEO");
		memVO1.setMem_account ("1qwewqewqe");
		memVO1.setMem_password("qwewqewqe");
		memVO1.setMem_gender(0);
		memVO1.setMem_phone(987654321);
		memVO1.setMem_email("as@as.com");
		memVO1.setMem_address("市區路巷弄");
		memVO1.setMem_birthday(new Date(System.currentTimeMillis()));
		memVO1.setMem_permission(1);
		dao.insert(memVO1);
}
	
}

