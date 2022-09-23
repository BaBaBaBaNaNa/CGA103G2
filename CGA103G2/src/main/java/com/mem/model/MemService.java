package com.mem.model;

import java.util.List;


public class MemService {

	private MemDAO_interface dao;

	public MemService() {
		dao = new MemDAO();
	}

	public MemVO addMem(
			
			String memName,
			String memAccount, 
			String memPassword,
			int memGender,
			int memperMission,
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
			Integer memID,
			String memName,
			String memAccount, 
			String memPassword, 
			Integer memGender,
			Integer memPermission,
			String memPhone, 
			String memAddress,
			String memEmail,
			java.sql.Date memBirthday
			 ) 
	{
		MemVO memVO = new MemVO();

		memVO.setMemName(memName);
		memVO.setMemAccount(memAccount);
		memVO.setMemPassword(memPassword);
		memVO.setMemGender(memGender);
		memVO.setMemPhone(memPhone);
		memVO.setMemEmail(memEmail);
		memVO.setMemAddress(memAddress);
		memVO.setMemBirthday(memBirthday);
		memVO.setMemPermission(memPermission);
		memVO.setMemID(memID);
		
		dao.update(memVO);

		return memVO;
	}

	public void deleteMem(Integer MemID) {
		dao.delete(MemID);
	}

	public MemVO getOneMem(Integer MemID) {
		return dao.findByPrimaryKey(MemID);
	}

	public List<MemVO> getAll() {
		return dao.getAll();
	}
	public MemVO getOwnMem(String memAccount) {
		return dao.findByMemAccount(memAccount);
	}
	
	public MemVO updatePassword(String mem_password,Integer mem_no) {
		
		MemVO memVO = new MemVO();
		memVO.setMem_pwd(mem_password);
		memVO.setMem_no(mem_no);
		
		dao.upatePassword(memVO);
		return memVO;
	}
}
