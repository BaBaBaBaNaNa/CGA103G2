package com.rsvt.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class RsvtDAOImpl implements RsvtDAO_interface {
	private static final String INSERT_STMT = "INSERT INTO RESERVATION (CUSTOMERNAME, CUSTOMERPHONE,RSVTNUM,RSVTPERIOD,RSVTDATE) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT RSVTID,MEMID,TABLETYPEID,CUSTOMERNAME,CUSTOMERPHONE,RSVTNUM,RSVTPERIOD,RSVTTOSEAT,RSVTDATE,RSVTMEALDATE FROM RESERVATION order by RSVTID";
	private static final String GET_ONE_STMT = "SELECT RSVTID,MEMID,TABLETYPEID,CUSTOMERNAME,CUSTOMERPHONE,RSVTNUM,RSVTPERIOD,RSVTTOSEAT,RSVTDATE,RSVTMEALDATE FROM RESERVATION WHERE RSVTID = ?";
	private static final String DELETE_STMT = "DELETE FROM RESERVATION WHERE RSVTID = ?";
	private static final String UPDATE_STMT = "UPDATE RESERVATION SET CUSTOMERNAME = ?,CUSTOMERPHONE = ?,RSVTNUM=?,RSVTPERIOD=?,RSVTTOSEAT = ?,RSVTDATE = ?,RSVTMEALDATE= ? WHERE RSVTID = ?";
	private static final String GET_NAME_STMT = "SELECT RSVTID,MEMID,TABLETYPEID,CUSTOMERNAME,CUSTOMERPHONE,RSVTNUM,RSVTPERIOD,RSVTTOSEAT,RSVTDATE,RSVTMEALDATE FROM RESERVATION WHERE CUSTOMERNAME = ?";
	
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
//	public static void main(String[] args) {
//		RsvtDAOImpl dao = new RsvtDAOImpl();
//		System.out.println(dao.findByPrimaryKey(2));
//	}
	public List<RsvtVO> getAll() {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_ALL_STMT);
				ResultSet rs = ps.executeQuery()) {
			List<RsvtVO> list = new ArrayList<>();
			while (rs.next()) {
				RsvtVO rsvt = new RsvtVO();
				rsvt.setRsvtId(rs.getInt(1));
				rsvt.setMemId(rs.getInt(2));
				rsvt.setTableTypeId(rs.getInt(3));
				rsvt.setCustomerName(rs.getString(4));
				rsvt.setCustomerPhone(rs.getString(5));
				rsvt.setRsvtNum(rs.getInt(6));
				rsvt.setRsvtPeriod(rs.getInt(7));
				rsvt.setRsvtToSeat(rs.getInt(8));
				rsvt.setRsvtDate(rs.getDate(9));
				rsvt.setRsvtMealDate(rs.getTimestamp(10));
				list.add(rsvt);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void insert(RsvtVO rsvt) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(INSERT_STMT)) {
			ps.setString(1, rsvt.getCustomerName());
			ps.setString(2, rsvt.getCustomerPhone());
			ps.setInt(3, rsvt.getRsvtNum());
			ps.setInt(4, rsvt.getRsvtPeriod());
			ps.setDate(5, rsvt.getRsvtDate());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(RsvtVO rsvt) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(UPDATE_STMT)) {
			ps.setString(1, rsvt.getCustomerName());
			ps.setString(2, rsvt.getCustomerPhone());
			ps.setInt(3, rsvt.getRsvtNum());
			ps.setInt(4, rsvt.getRsvtPeriod());
			ps.setInt(5, rsvt.getRsvtToSeat());
			ps.setDate(6, rsvt.getRsvtDate());
			ps.setTimestamp(7, rsvt.getRsvtMealDate());
			ps.setInt(8, rsvt.getRsvtId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer rsvtId) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(DELETE_STMT)) {
			ps.setInt(1, rsvtId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public RsvtVO findByPrimaryKey(Integer rsvtId) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_ONE_STMT)) {
			ps.setInt(1, rsvtId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RsvtVO rsvt = new RsvtVO();
				rsvt.setRsvtId(rs.getInt(1));
				rsvt.setMemId(rs.getInt(2));
				rsvt.setTableTypeId(rs.getInt(3));
				rsvt.setCustomerName(rs.getString(4));
				rsvt.setCustomerPhone(rs.getString(5));
				rsvt.setRsvtNum(rs.getInt(6));
				rsvt.setRsvtPeriod(rs.getInt(7));
				rsvt.setRsvtToSeat(rs.getInt(8));
				rsvt.setRsvtDate(rs.getDate(9));
				rsvt.setRsvtMealDate(rs.getTimestamp(10));
				return rsvt;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RsvtVO findByCustomerName(String customerName) {
		try (Connection conn = ds.getConnection();
				PreparedStatement ps = conn.prepareStatement(GET_NAME_STMT)) {
			ps.setString(1, customerName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				RsvtVO rsvt = new RsvtVO();
				rsvt.setRsvtId(rs.getInt(1));
				rsvt.setMemId(rs.getInt(2));
				rsvt.setTableTypeId(rs.getInt(3));
				rsvt.setCustomerName(rs.getString(4));
				rsvt.setCustomerPhone(rs.getString(5));
				rsvt.setRsvtNum(rs.getInt(6));
				rsvt.setRsvtPeriod(rs.getInt(7));
				rsvt.setRsvtToSeat(rs.getInt(8));
				rsvt.setRsvtDate(rs.getDate(9));
				rsvt.setRsvtMealDate(rs.getTimestamp(10));
				return rsvt;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
