package com.rsvt.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class RsvtService {
	private RsvtDAO_interface dao;

	public RsvtService() {
		dao = new RsvtDAOImpl();
	}

	public RsvtVO addRsvt(String cName, String cPhone, Integer rsvtNum, Integer rsvtPeriod, Date rsvtDate) {

		RsvtVO rsvt = new RsvtVO();
		rsvt.setCustomerName(cName);
		rsvt.setCustomerPhone(cPhone);
		rsvt.setRsvtNum(rsvtNum);
		rsvt.setRsvtPeriod(rsvtPeriod);
		rsvt.setRsvtDate(rsvtDate);
		dao.insert(rsvt);

		return rsvt;
	}

	public RsvtVO updateRsvt(String cName, String cPhone,Integer rsvtNum, Integer rsvtPeriod, Integer rsvtToSeat, Date rsvtDate,
			Timestamp rsvtMealDate, Integer rsvtId) {

		RsvtVO rsvt = new RsvtVO();
		rsvt.setCustomerName(cName);
		rsvt.setCustomerPhone(cPhone);
		rsvt.setRsvtNum(rsvtNum);
		rsvt.setRsvtPeriod(rsvtPeriod);
		rsvt.setRsvtToSeat(rsvtToSeat);
		rsvt.setRsvtDate(rsvtDate);
		rsvt.setRsvtMealDate(rsvtMealDate);
		rsvt.setRsvtId(rsvtId);
		dao.update(rsvt);

		return rsvt;
	}

	public void deleteRsvt(Integer rsvtId) {
		dao.delete(rsvtId);
	}

	public RsvtVO getOneRsvt(Integer rsvtId) {
		return dao.findByPrimaryKey(rsvtId);
	}

	public List<RsvtVO> getAll() {
		return dao.getAll();
	}

	public RsvtVO getCustomerName(String customerName) {
		return dao.findByCustomerName(customerName);
	}
}
