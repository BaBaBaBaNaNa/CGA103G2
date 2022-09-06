package com.waiting.model;

import java.sql.Date;
import java.util.List;

public class WaitingService {
	
	private WaitingDAO_interface dao;
	
	public WaitingService() {
		dao = new WaitingDAO();
	}
	
	public WaitingVO addWaiting(Integer waiting_id, Date waiting_date, Integer waiting_time, Integer current_no, Integer current_queued_no) {
		WaitingVO waitingVO = new WaitingVO();
		
		waitingVO.setwaiting_id(waiting_id);
		waitingVO.setwaiting_date(waiting_date);
		waitingVO.setwaiting_time(waiting_time);
		waitingVO.setcurrent_no(current_no);
		waitingVO.setcurrent_queued_no(current_queued_no);
		
		return waitingVO;
	}
	
	public WaitingVO updateWaiting(Integer waiting_id, Date waiting_date, Integer waiting_time, Integer current_no, Integer current_queued_no) {
		WaitingVO waitingVO = new WaitingVO();
		
		waitingVO.setwaiting_id(waiting_id);
		waitingVO.setwaiting_date(waiting_date);
		waitingVO.setwaiting_time(waiting_time);
		waitingVO.setcurrent_no(current_no);
		waitingVO.setcurrent_queued_no(current_queued_no);
		dao.update(waitingVO);
		
		return waitingVO;
	}
	
	public void deleteWaiting(Integer waiting_id){
		dao.delete(waiting_id);
	}
	
	public WaitingVO getOneWaiting(Integer waiting_id) {
		return dao.findByPrimaryKey(waiting_id);
	}
	
	public List<WaitingVO>getAll(){
		return dao.getAll();
		
	}
}
