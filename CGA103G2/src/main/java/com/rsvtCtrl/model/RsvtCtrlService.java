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

	public RsvtCtrlVO updateRsvtCtrl(Integer rsvtCtrlOpen,
			Integer rsvtCtrlMax, Integer rsvtCtrlNum,Integer rsvtCtrlId) {

		RsvtCtrlVO rsvt = new RsvtCtrlVO();
		rsvt.setTableTypeId(1);
		rsvt.setRsvtCtrlOpen(rsvtCtrlOpen);
		rsvt.setRsvtCtrlMax(rsvtCtrlMax);
		rsvt.setRsvtCtrlId(rsvtCtrlId);
		rsvt.setRsvtCtrlNumber(rsvtCtrlNum);
		dao.update(rsvt);

		return rsvt;
	}

	public void deleteRsvtCtrl(Integer rsvtCtrlId) {
		dao.delete(rsvtCtrlId);
	}

	public RsvtCtrlVO getOneRsvtCtrl(Integer rsvtCtrlId) {
		return dao.findByPrimaryKey(rsvtCtrlId);
	}
	
	public List<RsvtCtrlVO> getOneDate(String rsvtCtrlDate) {
		return dao.findByDate(rsvtCtrlDate);
	}

	public List<RsvtCtrlVO> getAll() {
		return dao.getAll();
	}
	
}
