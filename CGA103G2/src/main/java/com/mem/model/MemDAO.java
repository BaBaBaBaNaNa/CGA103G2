package com.mem.model;

import java.util.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import com.mem.model.MemVO;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemDAO implements MemDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cga103g2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

private static final String LOGIN_STMT = "SELECT memAccount,memPassword from Members where memAccount = ? and memPassword = ?";
private static final String INSERTSTMT = "INSERT INTO members (memName,memAccount,memPassword,memGender,memPhone,memEmail,memAddress,memBirthday,memPermission) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
private static final String GETALLSTMT = "SELECT memID, memname, memaccount, mempassword, memgender, memphone, mememail, memaddress, membirthday, mempermission FROM members order by memID";
private static final String GETONESTMT = "SELECT memID, memname, memaccount, mempassword, memgender, memphone, mememail, memaddress, membirthday, mempermission FROM members  where memID = ?";
private static final String DELETE = "DELETE FROM members where memID = ?";
private static final String UPDATE = "UPDATE members set memname=?, memaccount=?, mempassword=?, memgender=?, memphone=?, mememail=?, memaddress=?, membirthday=?, mempermission=? where memID = ?";



@Override
public boolean loginAdmin(MemLoginVO admin) {
	Connection con = null;
	PreparedStatement pstmt = null;
	
	int res = 0;
	try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(LOGIN_STMT);
		
		pstmt.setString(1, admin.getMemAccount());
		pstmt.setString(2, admin.getMemPassword());

		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			res = 1;
		}
		pstmt.close();
		rs.close();
		if (res == 1) {
			return true;
		}
	} catch (SQLException se) {
		throw new RuntimeException("A database error occured. " + se.getMessage());
	}if (con != null) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	return false;
}




@Override
public void insert(MemVO memVO) {
	Connection con =null;
	PreparedStatement pstmt = null;
	
	try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(INSERTSTMT);
	
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
public void update(MemVO memVO) {

	Connection con = null;
	PreparedStatement pstmt = null;

	try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(UPDATE);
		
		pstmt.setString(1, memVO.getMemName());
		pstmt.setString(2, memVO.getMemAccount());
		pstmt.setString(3, memVO.getMemPassword());
		pstmt.setInt(4, memVO.getMemGender());
		pstmt.setString(5, memVO.getMemPhone());
		pstmt.setString(6, memVO.getMemEmail());
		pstmt.setString(7, memVO.getMemAddress());
		pstmt.setDate(8, memVO.getMemBirthday());
		pstmt.setInt(9, memVO.getMemPermission());
		pstmt.setInt(10, memVO.getMemID());
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
public void delete(Integer memID) {
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(DELETE);
		
		pstmt.setInt(1, memID);

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
public MemVO findByPrimaryKey(Integer memID) {
	MemVO memVO = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		con = ds.getConnection();
		pstmt = con.prepareStatement(GETONESTMT);
		
		pstmt.setInt(1, memID);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			memVO = new MemVO();
			
//			pstmt.setInt(1, memVO.getmemID());
			memVO.setMemID(rs.getInt("memID"));
//			pstmt.setString(2, memVO.getMemname());
			memVO.setMemName(rs.getString("memname"));
//			pstmt.setString(3, memVO.getMemaccount());
			memVO.setMemAccount(rs.getString("memaccount"));
//			pstmt.setString(4, memVO.getMempassword());
			memVO.setMemPassword(rs.getString("mempassword"));
//			pstmt.setInt(5, memVO.getMemgender());
			memVO.setMemGender(rs.getInt("memgender"));
//			pstmt.setInt(6, memVO.getMemphone());
			memVO.setMemPhone(rs.getString("memphone"));
//			pstmt.setString(7, memVO.getMememail());
			memVO.setMemEmail(rs.getString("mememail"));
//			pstmt.setString(8, memVO.getMemaddress());
			memVO.setMemAddress(rs.getString("memaddress"));
//			pstmt.setDate(9, memVO.getMembirthday());
			memVO.setMemBirthday(rs.getDate("membirthday"));
//			pstmt.setInt(10, memVO.getMempermission());
			memVO.setMemPermission(rs.getInt("mempermission"));
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
		con = ds.getConnection();
		pstmt = con.prepareStatement(GETALLSTMT);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			// empVO 也稱為 Domain objects
			memVO = new MemVO();
			
			memVO.setMemID(rs.getInt("memID"));
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
//	MemVO memVO1 = new MemVO();
//	memVO1.setMemID(12);
//	memVO1.setMemName("LEO");
//	memVO1.setMemAccount ("1qwewqewqe");
//	memVO1.setMemPassword("qwewqewqe");
//	memVO1.setMemGender(0);
//	memVO1.setMemPhone("987654321");
//	memVO1.setMemEmail("as@as.com");
//	memVO1.setMemAddress("市區路巷弄");
//	memVO1.setMemBirthday(new Date(System.currentTimeMillis()));
//	memVO1.setMemPermission(1);
//	dao.insert(memVO1);
	
	
	
	// 修改  done
//	MemVO memVO2 = new MemVO();
//	memVO2.setMemID(1);
//	memVO2.setMemName("連勝文");
//	memVO2.setMemAccount ("wowowo");
//	memVO2.setMemPassword("123");
//	memVO2.setMemGender(0);
//	memVO2.setMemPhone("987654323");
//	memVO2.setMemEmail("a2s@as.com");
//	memVO2.setMemAddress("市區路巷弄");
//	memVO2.setMemBirthday(new Date(System.currentTimeMillis()));
//	memVO2.setMemPermission(1);
//	dao.update(memVO2);
	
	
	
	
	//刪除  done
//	dao.delete(10);
	
	
	// 單筆查詢  done
//	MemVO memVO3 = dao.findByPrimaryKey(11);
//	System.out.print(memVO3.getMemID() + ",");
//	System.out.print(memVO3.getMemName() + ",");
//	System.out.print(memVO3.getMemAccount() + ",");
//	System.out.print(memVO3.getMemPassword() + ",");
//	System.out.print(memVO3.getMemPermission() + ",");
//	System.out.print(memVO3.getMemPhone() + ",");
//	System.out.println(memVO3.getMemAddress() + ",");
//	System.out.println(memVO3.getMemEmail() + ",");
//	System.out.println(memVO3.getMemBirthday()+ ",");
//	System.out.println(memVO3.getMemPermission()+ ",");
//	System.out.println("---------------------");
	
	
	// 多筆查詢  done
	List<MemVO> list = dao.getAll();
	for (MemVO aMem : list) {
		System.out.print(aMem.getMemID() + ",");
		System.out.print(aMem.getMemName() + ",");
		System.out.print(aMem.getMemAccount() + ",");
		System.out.print(aMem.getMemPassword() + ",");
		System.out.print(aMem.getMemPermission() + ",");
		System.out.print(aMem.getMemPhone() + ",");
		System.out.println(aMem.getMemAddress() + ",");
		System.out.println(aMem.getMemEmail() + ",");
		System.out.println(aMem.getMemBirthday()+ ",");
		System.out.println(aMem.getMemPermission()+ ",");
		System.out.println("---------------------");
	}
}

}

