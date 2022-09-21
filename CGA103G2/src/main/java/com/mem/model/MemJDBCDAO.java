package com.mem.model;

import java.util.*;

import com.emp.model.EmpDAO;
import com.emp.model.EmpVO;
import com.mem.model.MemVO;

import java.sql.*;
import java.sql.Date;

//進入DB ->五種功能:INSERTSTMT /  GETALLSTMT / GETONESTMT / DELETE / UPDATE
public class MemJDBCDAO implements MemDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cga103g2?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "password";
	private static final String INSERTSTMT = "INSERT INTO members (memname,memaccount,mempassword,memgender,memphone,mememail,memaddress,membirthday,mempermission) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	private static final String GETALLSTMT = "SELECT MemID, memname, memaccount, mempassword, memgender, memphone, mememail, memaddress, membirthday, mempermission FROM members order by MemID";
	private static final String GETONESTMT = "SELECT MemID, memname, memaccount, mempassword, memgender, memphone, mememail, memaddress, membirthday, mempermission FROM members  where MemID = ?";
	private static final String DELETE = "DELETE FROM members where MemID = ?";
	private static final String UPDATE = "UPDATE members set memname=?, memaccount=?, mempassword=?,  memphone=?, mememail=?, memaddress=?, membirthday=?, mempermission=? where MemID = ?";

	@Override
	public void insert(MemVO memVO) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
		try (Connection conn = DriverManager.getConnection(url, userid, passwd);
				PreparedStatement pstmt =  conn.prepareStatement(INSERTSTMT)){
//			
//			設定: 設立下一段需使用的參數
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, userid, passwd);
//			pstmt = con.prepareStatement(INSERTSTMT);

//			pstmt.setString(1,memVO,getMemID());
//			pstmt.setInt(1, memVO.getMemID());
			pstmt.setString(1, memVO.getMemName());
			pstmt.setString(2, memVO.getMemAccount());
			pstmt.setString(3, memVO.getMemPassword());
			pstmt.setInt(4, memVO.getMemGender());
			pstmt.setString(5, memVO.getMemPhone());
			pstmt.setString(6, memVO.getMemEmail());
			pstmt.setString(7, memVO.getMemAddress());
			pstmt.setDate(8, memVO.getMemBirthday());
			pstmt.setInt(9, memVO.getMemPermission());

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

//			pstmt.setInt(1, memVO.getMemID());
			pstmt.setString(1, memVO.getMemName());
			pstmt.setString(2, memVO.getMemAccount());
			pstmt.setString(3, memVO.getMemPassword());
			
			pstmt.setString(4, memVO.getMemPhone());
			pstmt.setString(5, memVO.getMemEmail());
			pstmt.setString(6, memVO.getMemAddress());
			pstmt.setDate(7, memVO.getMemBirthday());
			pstmt.setInt(8, memVO.getMemPermission());
			pstmt.setInt(9, memVO.getMemID());
			pstmt.executeUpdate();
			System.out.println("update done!");

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
	public void delete(Integer MemID) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, userid, passwd);
		pstmt = con.prepareStatement(DELETE);
		
		pstmt.setInt(1, MemID);
		
		pstmt.executeUpdate();
		System.out.println("Delete done!");
		
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
	public MemVO findByPrimaryKey(Integer MemID) {

		MemVO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = EmpDb.getConnection();
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GETONESTMT);

			pstmt.setInt(1, MemID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				memVO = new MemVO();
				
//				pstmt.setInt(1, memVO.getMemID());
				memVO.setMemID(rs.getInt("MemID"));
//				pstmt.setString(2, memVO.getMemname());
				memVO.setMemName(rs.getString("memname"));
//				pstmt.setString(3, memVO.getMemaccount());
				memVO.setMemAccount(rs.getString("memaccount"));
//				pstmt.setString(4, memVO.getMempassword());
				memVO.setMemPassword(rs.getString("mempassword"));
//				pstmt.setInt(5, memVO.getMemgender());
				memVO.setMemGender(rs.getInt("memgender"));
//				pstmt.setInt(6, memVO.getMemphone());
				memVO.setMemPhone(rs.getString("memphone"));
//				pstmt.setString(7, memVO.getMememail());
				memVO.setMemEmail(rs.getString("mememail"));
//				pstmt.setString(8, memVO.getMemaddress());
				memVO.setMemAddress(rs.getString("memaddress"));
//				pstmt.setDate(9, memVO.getMembirthday());
				memVO.setMemBirthday(rs.getDate("membirthday"));
//				pstmt.setInt(10, memVO.getMempermission());
				memVO.setMemPermission(rs.getInt("mempermission"));
				
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
			pstmt = con.prepareStatement(GETALLSTMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				memVO = new MemVO();
				
				memVO.setMemID(rs.getInt("MemID"));
				memVO.setMemName(rs.getString("memname"));
				memVO.setMemAccount(rs.getString("memaccount"));
				memVO.setMemPassword(rs.getString("mempassword"));
				memVO.setMemGender(rs.getInt("memgender"));
				memVO.setMemPhone(rs.getString("memphone"));
				memVO.setMemEmail(rs.getString("mememail"));
				memVO.setMemAddress(rs.getString("memaddress"));
				memVO.setMemBirthday(rs.getDate("membirthday"));
				memVO.setMemPermission(rs.getInt("mempermission"));
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
		
		// 新增  done
		MemVO memVO1 = new MemVO();
		memVO1.setMemID(12);
		memVO1.setMemName("LEooo");
		memVO1.setMemAccount ("1qwewqewqe");
		memVO1.setMemPassword("qwewqewqe");
		memVO1.setMemGender(0);
		memVO1.setMemPhone("987654321");
		memVO1.setMemEmail("as@as.com");
		memVO1.setMemAddress("市區路巷弄");
		memVO1.setMemBirthday(new Date(System.currentTimeMillis()));
		memVO1.setMemPermission(0);
		dao.insert(memVO1);
		
		
		
//		 修改  done
//		MemVO memVO2 = new MemVO();
//		memVO2.setMemID(9);
//		memVO2.setMemname("蔡EE");
//		memVO2.setMemaccount ("wowowo");
//		memVO2.setMempassword("123");
//		memVO2.setMemgender(1);
//		memVO2.setMemphone("987654323");
//		memVO2.setMememail("a2s@as.com");
//		memVO2.setMemaddress("市區路巷弄");
//		memVO2.setMembirthday(new Date(System.currentTimeMillis()));
//		memVO2.setMempermission(1);
//		dao.update(memVO2);
		
		
		
		
		//刪除  done
//		dao.delete(10);
		
		
		// 單筆查詢  done
//		MemVO memVO3 = dao.findByPrimaryKey(11);
//		System.out.print(memVO3.getMemID() + ",");
//		System.out.print(memVO3.getMemname() + ",");
//		System.out.print(memVO3.getMemaccount() + ",");
//		System.out.print(memVO3.getMempassword() + ",");
//		System.out.print(memVO3.getMempermission() + ",");
//		System.out.print(memVO3.getMemphone() + ",");
//		System.out.println(memVO3.getMemaddress() + ",");
//		System.out.println(memVO3.getMememail() + ",");
//		System.out.println(memVO3.getMembirthday()+ ",");
//		System.out.println(memVO3.getMempermission()+ ",");
//		System.out.println("---------------------");
		
		
		// 多筆查詢  done
//		List<MemVO> list = dao.getAll();
//		for (MemVO aMem : list) {
//			System.out.print(aMem.getMemID() + ",");
//			System.out.print(aMem.getMemname() + ",");
//			System.out.print(aMem.getMemaccount() + ",");
//			System.out.print(aMem.getMempassword() + ",");
//			System.out.print(aMem.getMempermission() + ",");
//			System.out.print(aMem.getMemphone() + ",");
//			System.out.println(aMem.getMemaddress() + ",");
//			System.out.println(aMem.getMememail() + ",");
//			System.out.println(aMem.getMembirthday()+ ",");
//			System.out.println(aMem.getMempermission()+ ",");
//			System.out.println("---------------------");
		}

	@Override
	public boolean loginAdmin(MemLoginVO admin) {
		// TODO Auto-generated method stub
		return false;
	}
}

	


