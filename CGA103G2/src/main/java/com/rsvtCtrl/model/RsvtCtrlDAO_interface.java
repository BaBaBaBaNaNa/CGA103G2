package com.rsvtCtrl.model;

import java.sql.Date;
import java.util.List;

public interface RsvtCtrlDAO_interface {
	public void insert(RsvtCtrlVO rsvtCtrl);

	public void update(RsvtCtrlVO rsvtCtrl);

	public void delete(Integer rsvtCtrlId);

	public void updateForOne(Integer id, String colName, Object value);

	public RsvtCtrlVO findByPrimaryKey(Integer rsvtCtrlId);
	public RsvtCtrlVO findByDate(String rsvtDate);

	public List<RsvtCtrlVO> getAll();
}
