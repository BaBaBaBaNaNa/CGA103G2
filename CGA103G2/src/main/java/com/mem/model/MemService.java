package com.mem.model;

import java.util.List;

public class MemService {

	private MemDAO_interface dao;

	public MemService() {
		dao = new MemJDBCDAO();
	}

	public MemVO addMem(Integer mem_id, String mem_name, String mem_account, 
			String mem_password, Integer mem_gneder,
			Integer mem_phone, String mem_email, String mem_address, 
			java.sql.Date mem_birthday, Integer mem_permission) {
			
			

		MemVO memVO = new MemVO();
		
		memVO.setMem_id(mem_id);
		memVO.setMem_name(mem_name);
		memVO.setMem_account(mem_account);
		memVO.setMem_password(mem_password);
		memVO.setMem_gender(mem_gneder);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_email(mem_email);
		memVO.setMem_address(mem_address);
		memVO.setMem_birthday(mem_birthday);
		memVO.setMem_permission(mem_permission);
		
		dao.insert(memVO);
		
		return memVO;
		
		
	}

	public MemVO updateMem( String mem_name,  
			String mem_address,java.sql.Date mem_birthday,
			Integer mem_phone, 
			 Integer mem_gneder, 
			 Integer mem_permission) {

		MemVO memVO = new MemVO();

	
		memVO.setMem_name(mem_name);
		memVO.setMem_address(mem_address);
		memVO.setMem_birthday(mem_birthday);
		memVO.setMem_phone(mem_phone);
		memVO.setMem_gender(mem_gneder);
		memVO.setMem_permission(mem_permission);
		
		
		
		
		dao.update(memVO);

		return memVO;
	}

	public void deleteMem(Integer mem_id) {
		dao.delete(mem_id);
	}

	public MemVO getOneMem(Integer mem_id) {
		return dao.findByPrimaryKey(mem_id);
	}

	public List<MemVO> getAll() {
		return dao.getAll();
	}
}
