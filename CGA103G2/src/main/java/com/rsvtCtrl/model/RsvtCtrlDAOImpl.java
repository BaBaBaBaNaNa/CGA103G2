package com.rsvtCtrl.model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class RsvtCtrlDAOImpl implements RsvtCtrlDAO_interface {
	private static final String INSERT_STMT = "INSERT INTO RESERVATION_CTRL (RSVT_CTRL_ID,RSVT_CTRL_DATE,RSVT_CTRL_PERIOD,RSVT_CTRL_MAX) VALUES(?,?,?,?);";
	private static final String GET_ALL_STMT = "SELECT RSVT_CTRL_ID,TABLE_TYPE_ID,RSVT_CTRL_OPEN,RSVT_CTRL_DATE,RSVT_CTRL_PERIOD,RSVT_CTRL_MAX,RSVT_CTRL_NUMBER FROM RESERVATION_CTRL;";
	private static final String GET_ONE_STMT = "SELECT RSVT_CTRL_ID,TABLE_TYPE_ID,RSVT_CTRL_OPEN,RSVT_CTRL_DATE,RSVT_CTRL_PERIOD,RSVT_CTRL_MAX,RSVT_CTRL_NUMBER FROM RESERVATION_CTRL WHERE RSVT_CTRL_ID = ?";
	private static final String GET_DATE_STMT = "SELECT RSVT_CTRL_ID,TABLE_TYPE_ID,RSVT_CTRL_OPEN,RSVT_CTRL_DATE,RSVT_CTRL_PERIOD,RSVT_CTRL_MAX,RSVT_CTRL_NUMBER FROM RESERVATION_CTRL WHERE RSVT_CTRL_DATE = ?";
	private static final String DELETE_STMT = "DELETE FROM RESERVATION_CTRL WHERE RSVT_CTRL_ID = ?";
	private static String UPDATE_STMT = "UPDATE RESERVATION_CTRL SET TABLE_TYPE_ID = ?,RSVT_CTRL_OPEN = ?,RSVT_CTRL_DATE = ?,RSVT_CTRL_PERIOD = ?,RSVT_CTRL_MAX = ?,RSVT_CTRL_NUMBER = ? WHERE RSVT_CTRL_ID = ? ;";
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Restaurant");
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
			ps.setInt(1, rsvtCtrl.getRsvtCtrlId());
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
			ps.setInt(1, rsvtCtrl.getRsvtCtrlOpen());
			ps.setDate(2, rsvtCtrl.getRsvtCtrlDate());
			ps.setInt(3, rsvtCtrl.getRsvtCtrlPeriod());
			ps.setInt(4, rsvtCtrl.getRsvtCtrlMax());
			ps.setInt(5, rsvtCtrl.getRsvtCtrlNumber());
			ps.setInt(6, rsvtCtrl.getRsvtCtrlId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateForOne(Integer rsvtCtrlId, String columnName, Object value) {
		String SQL = "UPDATE RESERVATION_CTRL SET " + columnName + " = ? WHERE RSVT_CTRL_ID = ?";
		System.out.println(SQL);
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(SQL);) {
			int type = -1;
			if ("TABLE_TYPE_ID".equals(columnName)) {
				type = 4;
			}
			if ("RSVT_CTRL_OPEN".equals(columnName)) {
				type = 4;
			}
			if ("RSVT_CTRL_DATE".equals(columnName)) {
				type = 91;
			}
			if ("RSVT_CTRL_PERIOD".equals(columnName)) {
				type = 4;
			}
			if ("RSVT_CTRL_MAX".equals(columnName)) {
				type = 4;
			}
			if ("RSVT_CTRL_PERIOD".equals(columnName)) {
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
				PreparedStatement ps = conn.prepareStatement(GET_ONE_STMT);
					ResultSet rs = ps.executeQuery();) {
			ps.setInt(1, rsvtCtrlId);
			ps.execute();
			while (rs.next()) {
				RsvtCtrlVO rsvtCtrl = new RsvtCtrlVO();
				rsvtCtrl.setRsvtCtrlId(rs.getInt("rsvt_ctrl_id"));
				rsvtCtrl.setTableTypeId(rs.getInt("table_type_id"));
				rsvtCtrl.setRsvtCtrlOpen(rs.getInt("rsvt_ctrl_open"));
				rsvtCtrl.setRsvtCtrlDate(rs.getDate("rsvt_ctrl_date"));
				rsvtCtrl.setRsvtCtrlPeriod(rs.getInt("rsvt_ctrl_period"));
				rsvtCtrl.setRsvtCtrlMax(rs.getInt("rsvt_ctrl_max"));
				rsvtCtrl.setRsvtCtrlNumber(rs.getInt("rsvt_ctrl_number"));
				return rsvtCtrl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public RsvtCtrlVO findByDate(Date rsvtCtrlDate) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_DATE_STMT);
					ResultSet rs = ps.executeQuery();) {
			ps.setDate(1, rsvtCtrlDate);
			ps.execute();
			while (rs.next()) {
				RsvtCtrlVO rsvtCtrl = new RsvtCtrlVO();
				rsvtCtrl.setRsvtCtrlId(rs.getInt("rsvt_ctrl_id"));
				rsvtCtrl.setTableTypeId(rs.getInt("table_type_id"));
				rsvtCtrl.setRsvtCtrlOpen(rs.getInt("rsvt_ctrl_open"));
				rsvtCtrl.setRsvtCtrlDate(rs.getDate("rsvt_ctrl_date"));
				rsvtCtrl.setRsvtCtrlPeriod(rs.getInt("rsvt_ctrl_period"));
				rsvtCtrl.setRsvtCtrlMax(rs.getInt("rsvt_ctrl_max"));
				rsvtCtrl.setRsvtCtrlNumber(rs.getInt("rsvt_ctrl_number"));
				return rsvtCtrl;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
//	public static void main(String[] args) {
//		String str = "2022-11-11";
//		Date date = Date.valueOf(str);
//		RsvtCtrlDAOImpl dao = new RsvtCtrlDAOImpl();
//		dao.updateForOne(2, "RSVT_CTRL_OPEN", date);
//		for (RsvtCtrlVO test : dao.getAll()) {
//			System.out.println(test.getRsvtCtrlId() + " " + test.getRsvtCtrlDate());
//		}
//	}

}
