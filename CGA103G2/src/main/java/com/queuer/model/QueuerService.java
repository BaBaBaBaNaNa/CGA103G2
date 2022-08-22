package com.queuer.model;

import java.util.List;

public class QueuerService {
	
	private QueuerDAO_interface dao;
	
	public QueuerService() {
		dao = new QueuerDAO();
	}
	
	public QueuerVO addQueuer(Integer queuer_id, Integer queuer_status, String queuer_name, String queuer_phone, Integer queuer_no) {
		
		QueuerVO queuerVO = new QueuerVO();
		
		queuerVO.setqueuer_id(queuer_id);
		queuerVO.setqueuer_status(queuer_status);
		queuerVO.setqueuer_name(queuer_name);
		queuerVO.setqueuer_phone(queuer_phone);
		queuerVO.setqueuer_no(queuer_no);
		dao.insert(queuerVO);
		
		
		return queuerVO;
	}
	
	public QueuerVO updatQueuer(Integer queuer_id, Integer queuer_status, String queuer_name, String queuer_phone, Integer queuer_no) {
		
		QueuerVO queuerVO = new QueuerVO();
		
		queuerVO.setqueuer_id(queuer_id);
		queuerVO.setqueuer_status(queuer_status);
		queuerVO.setqueuer_name(queuer_name);
		queuerVO.setqueuer_phone(queuer_phone);
		queuerVO.setqueuer_no(queuer_no);
		dao.update(queuerVO);
		
		
		return queuerVO;
	}
	
	public void deleteQueuer(Integer queuer_id) {
		dao.delete(queuer_id);
	}
	
	public QueuerVO getOneQueuer(Integer queuer_id) {
		return dao.findByPrimaryKey(queuer_id);
	}
	
	public List<QueuerVO> getAll(){
		return dao.getAll();
	}
	
}

