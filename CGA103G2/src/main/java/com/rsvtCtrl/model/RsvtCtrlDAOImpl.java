package com.rsvtCtrl.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class RsvtCtrlDAOImpl implements RsvtCtrlDAO_interface {
	private static final String INSERT_STMT = "INSERT INTO RESERVATIONCTRL (RSVTCTRLOPEN ,RSVTCTRLDATE,RSVTCTRLPERIOD,RSVTCTRLMAX) VALUES(?,?,?,?);";
	private static final String GET_ALL_STMT = "SELECT RSVTCTRLID,TABLETYPEID,RSVTCTRLOPEN,RSVTCTRLDATE,RSVTCTRLPERIOD,RSVTCTRLMAX,RSVTCTRLNUMBER FROM RESERVATIONCTRL;";
	private static final String GET_ONE_STMT = "SELECT RSVTCTRLID,TABLETYPEID,RSVTCTRLOPEN,RSVTCTRLDATE,RSVTCTRLPERIOD,RSVTCTRLMAX,RSVTCTRLNUMBER FROM RESERVATIONCTRL WHERE RSVTCTRLID = ?";
	private static final String GET_DATE_STMT = "SELECT RSVTCTRLID,TABLETYPEID,RSVTCTRLOPEN,RSVTCTRLDATE,RSVTCTRLPERIOD,RSVTCTRLMAX,RSVTCTRLNUMBER FROM RESERVATIONCTRL WHERE RSVTCTRLDATE = ?";
	private static final String DELETE_STMT = "DELETE FROM RESERVATIONCTRL WHERE RSVTCTRLID = ?";
	private static final String UPDATE_STMT = "UPDATE RESERVATIONCTRL SET TABLETYPEID = ?,RSVTCTRLOPEN = ?,RSVTCTRLDATE = ?,RSVTCTRLPERIOD = ?,RSVTCTRLMAX = ?,RSVTCTRLNUMBER = ? WHERE RSVTCTRLID = ? ;";
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/cga103g2");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public List<RsvtCtrlVO> getAll() {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_ALL_STMT);
				ResultSet rs = ps.executeQuery()) {
			List<RsvtCtrlVO> list = new ArrayList<RsvtCtrlVO>();
			while (rs.next()) {
				RsvtCtrlVO rsvtCtrl = new RsvtCtrlVO();
				rsvtCtrl.setRsvtCtrlId(rs.getInt(1));
				rsvtCtrl.setTableTypeId(rs.getInt(2));
				rsvtCtrl.setRsvtCtrlOpen(rs.getInt(3));
				rsvtCtrl.setRsvtCtrlDate(rs.getDate(4));
				rsvtCtrl.setRsvtCtrlPeriod(rs.getInt(5));
				rsvtCtrl.setRsvtCtrlMax(rs.getInt(6));
				rsvtCtrl.setRsvtCtrlNumber(rs.getInt(7));
				list.add(rsvtCtrl);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insert(RsvtCtrlVO rsvtCtrl) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_STMT);) {
			ps.setInt(1, rsvtCtrl.getRsvtCtrlOpen());
			ps.setDate(2, rsvtCtrl.getRsvtCtrlDate());
			ps.setInt(3, rsvtCtrl.getRsvtCtrlPeriod());
			ps.setInt(4, rsvtCtrl.getRsvtCtrlMax());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Integer rsvtCtrlId) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(DELETE_STMT);) {
			ps.setInt(1, rsvtCtrlId);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(RsvtCtrlVO rsvtCtrl) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(UPDATE_STMT);) {
			ps.setInt(1, rsvtCtrl.getTableTypeId());
			ps.setInt(2, rsvtCtrl.getRsvtCtrlOpen());
			ps.setDate(3, rsvtCtrl.getRsvtCtrlDate());
			ps.setInt(4, rsvtCtrl.getRsvtCtrlPeriod());
			ps.setInt(5, rsvtCtrl.getRsvtCtrlMax());
			ps.setInt(6, rsvtCtrl.getRsvtCtrlNumber());
			ps.setInt(7, rsvtCtrl.getRsvtCtrlId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateForOne(Integer rsvtCtrlId, String columnName, Object value) {
		String SQL = "UPDATE RESERVATIONCTRL SET " + columnName + " = ? WHERE RSVTCTRLID = ?";
		System.out.println(SQL);
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL);) {
			int type = -1;
			if ("TABLETYPEID".equals(columnName)) {
				type = 4;
			}
			if ("RSVTCTRLOPEN".equals(columnName)) {
				type = 4;
			}
			if ("RSVTCTRLDATE".equals(columnName)) {
				type = 91;
			}
			if ("RSVTCTRLPERIOD".equals(columnName)) {
				type = 4;
			}
			if ("RSVTCTRLMAX".equals(columnName)) {
				type = 4;
			}
			if ("RSVTCTRLPERIOD".equals(columnName)) {
				type = 4;
			}
			if (type != -1) {
				if (type == 4) {
					ps.setInt(1, (int) value);
				}
				if (type == 91) {
					ps.setDate(1, (Date) value);
				}
			}
			ps.setInt(2, rsvtCtrlId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public RsvtCtrlVO findByPrimaryKey(Integer rsvtCtrlId) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_ONE_STMT);) {
			ps.setInt(1, rsvtCtrlId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RsvtCtrlVO rsvtCtrl = new RsvtCtrlVO();
				rsvtCtrl.setRsvtCtrlId(rs.getInt("rsvtctrlid"));
				rsvtCtrl.setTableTypeId(rs.getInt("tabletypeid"));
				rsvtCtrl.setRsvtCtrlOpen(rs.getInt("rsvtctrlopen"));
				rsvtCtrl.setRsvtCtrlDate(rs.getDate("rsvtctrldate"));
				rsvtCtrl.setRsvtCtrlPeriod(rs.getInt("rsvtctrlperiod"));
				rsvtCtrl.setRsvtCtrlMax(rs.getInt("rsvtctrlmax"));
				rsvtCtrl.setRsvtCtrlNumber(rs.getInt("rsvtctrlnumber"));
				return rsvtCtrl;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<RsvtCtrlVO> findByDate(String rsvtCtrlDate) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_DATE_STMT)) {
			ps.setString(1, rsvtCtrlDate);
			ResultSet rs = ps.executeQuery();
			List<RsvtCtrlVO> list = new ArrayList<>();
			while (rs.next()) {
				RsvtCtrlVO rsvtCtrl = new RsvtCtrlVO();
				rsvtCtrl.setRsvtCtrlId(rs.getInt("rsvtctrlid"));
				rsvtCtrl.setTableTypeId(rs.getInt("tabletypeid"));
				rsvtCtrl.setRsvtCtrlOpen(rs.getInt("rsvtctrlopen"));
				rsvtCtrl.setRsvtCtrlDate(rs.getDate("rsvtctrldate"));
				rsvtCtrl.setRsvtCtrlPeriod(rs.getInt("rsvtctrlperiod"));
				rsvtCtrl.setRsvtCtrlMax(rs.getInt("rsvtctrlmax"));
				rsvtCtrl.setRsvtCtrlNumber(rs.getInt("rsvtctrlnumber"));
				list.add(rsvtCtrl);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static void main(String[] args) {
//		String str = "2022-11-11";
//		Date date = Date.valueOf(str);
//		RsvtCtrlDAOImpl dao = new RsvtCtrlDAOImpl();
//		dao.updateForOne(2, "RSVTCTRLOPEN", date);
//		for (RsvtCtrlVO test : dao.getAll()) {
//			System.out.println(test.getRsvtCtrlId() + " " + test.getRsvtCtrlDate());
//		}
//	}

}
