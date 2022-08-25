package com.mem.model;

import java.util.List;

public class MemService {

	private MemDAO_interface dao;

	public MemService() {
		dao = new MemJDBCDAO();
	}

	public MemVO addMem(
			
			String memName,
			String memAccount, 
			String memPassword,
			int memperMission,
			int memGender,
			String memPhone,
			String memAddress,
			String memEmail,
			java.sql.Date memBirthday) {
			
			

		MemVO memVO = new MemVO();
		
		
		memVO.setMemName(memName);
		memVO.setMemAccount(memAccount);
		memVO.setMemPassword(memPassword);
		memVO.setMemGender(memGender);
		memVO.setMemPhone(memPhone);
		memVO.setMemEmail(memEmail);
		memVO.setMemAddress(memAddress);
		memVO.setMemBirthday(memBirthday);
		memVO.setMemPermission(memperMission);
		
		dao.insert(memVO);
		
		return memVO;
		
		
	}

	public MemVO updateMem( 
			Integer memId,
			String memName,
			String memAccount, 
			String memPassword,
			Integer memPermission,
			
			String memPhone, 
			String memAddress,
			String memEmail,
			java.sql.Date memBirthday
			 ) 
	{

		MemVO memVO = new MemVO();

		memVO.setMemAccount(memAccount);
		memVO.setMemName(memName);
		memVO.setMemPassword(memPassword);
		memVO.setMemEmail(memEmail);
		memVO.setMemAddress(memAddress);
		memVO.setMemBirthday(memBirthday);
		memVO.setMemPhone(memPhone);
		memVO.setMemId(memId);
		memVO.setMemPermission(memPermission);
		
		
		
		
		dao.update(memVO);

		return memVO;
	}

	public void deleteMem(Integer memid) {
		dao.delete(memid);
	}

	public MemVO getOneMem(Integer memid) {
		return dao.findByPrimaryKey(memid);
	}

	public List<MemVO> getAll() {
		return dao.getAll();
	}
}
