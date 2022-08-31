package com.queuer.model;

import java.util.List;

public class QueuerService {
	
	private QueuerDAO_interface dao;
	
	public QueuerService() {
		dao = new QueuerDAO();
	}
	
	public QueuerVO addQueuer( String queuerName, String queuerPhone) {
		
		QueuerVO queuerVO = new QueuerVO();
		
		queuerVO.setQueuerName(queuerName);
		queuerVO.setQueuerPhone(queuerPhone);
		dao.insert(queuerVO);
		
		
		return queuerVO;
	}
	
	public QueuerVO updateQueuer(Integer queuerStatus, Integer queuerID) {
		
		QueuerVO queuerVO = new QueuerVO();
		
		queuerVO.setQueuerStatus(queuerStatus);
		queuerVO.setQueuerID(queuerID);
		dao.update(queuerVO);
		
		
		return queuerVO;
	}
	
	public void deleteQueuer(Integer queuerID) {
		dao.delete(queuerID);
	}
	
	public QueuerVO getOneQueuer(Integer queuerID) {
		return dao.findByPrimaryKey(queuerID);
	}
	
	public List<QueuerVO> getAll(){
		return dao.getAll();
	}
	
}

