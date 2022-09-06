package com.rsvtCtrl.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RsvtCtrlService {
	private RsvtCtrlDAO_interface dao;

	public RsvtCtrlService() {
		dao = new RsvtCtrlDAOImpl();
	}

	public RsvtCtrlVO addRsvtCtrl(Integer rsvtCtrlOpen, Date rsvtCtrlDate, Integer rsvtCtrlPeriod, Integer rsvtCtrlMax) {

		RsvtCtrlVO rsvt = new RsvtCtrlVO();
		rsvt.setRsvtCtrlOpen(rsvtCtrlOpen);;
		rsvt.setRsvtCtrlDate(rsvtCtrlDate);
		rsvt.setRsvtCtrlPeriod(rsvtCtrlPeriod);
		rsvt.setRsvtCtrlMax(rsvtCtrlMax);
		
		dao.insert(rsvt);

		return rsvt;
	}

	public RsvtCtrlVO updateRsvtCtrl(Integer tbtId, Integer rsvtCtrlOpen, Date rsvtCtrlDate, Integer rsvtCtrlPeriod,
			Integer rsvtCtrlMax, Integer rsvtCtrlNumber, Integer rsvtCtrlId) {

		RsvtCtrlVO rsvt = new RsvtCtrlVO();
		rsvt.setTableTypeId(tbtId);
		rsvt.setRsvtCtrlOpen(rsvtCtrlOpen);
		rsvt.setRsvtCtrlDate(rsvtCtrlDate);
		rsvt.setRsvtCtrlPeriod(rsvtCtrlPeriod);
		rsvt.setRsvtCtrlMax(rsvtCtrlMax);
		rsvt.setRsvtCtrlNumber(rsvtCtrlNumber);
		rsvt.setRsvtCtrlId(rsvtCtrlId);
		dao.update(rsvt);

		return rsvt;
	}

	public void deleteRsvtCtrl(Integer rsvtCtrlId) {
		dao.delete(rsvtCtrlId);
	}

	public RsvtCtrlVO getOneRsvtCtrl(Integer rsvtCtrlId) {
		return dao.findByPrimaryKey(rsvtCtrlId);
	}
	
	public RsvtCtrlVO getOneDate(String rsvtCtrlDate) {
		return dao.findByDate(rsvtCtrlDate);
	}

	public List<RsvtCtrlVO> getAll() {
		return dao.getAll();
	}
	
	public static void main(String[] args) {
		RsvtCtrlService rsvtCtrlSvc = new RsvtCtrlService();
		List<RsvtCtrlVO> list = rsvtCtrlSvc.getAll();
		List<String> dateList = new ArrayList<>();
		for (RsvtCtrlVO all : list) {
			if (all.getRsvtCtrlOpen() == 1) {
				dateList.add(all.getRsvtCtrlDate().toString());
			}
		}
	}
}
