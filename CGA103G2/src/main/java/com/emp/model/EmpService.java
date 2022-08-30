package com.emp.model;

import java.util.List;

import com.job.model.JobVO;

public class EmpService {

	private EmpDAO_interface dao;

	public EmpService() {
		dao = new EmpDAO();
	}

	//新增員工
	public EmpVO addEmp(
			String empName, 
			String empAccount,
			String empPassword,
			int empPermission,
			String empPhone,
			String empAddress,
			int JobID,
			java.sql.Date empHiredate) {

		EmpVO empVO = new EmpVO();

		empVO.setEmpName(empName);
		empVO.setEmpAccount(empAccount);
		empVO.setEmpPassword(empPassword);
		empVO.setEmpPermission(empPermission);
		empVO.setEmpPhone(empPhone);
		empVO.setEmpAddress(empAddress);
		empVO.setJobID(JobID);
		empVO.setEmpHiredate(empHiredate);
		dao.insert(empVO);

		return empVO;
	}

	//修改員工資料
	public EmpVO updateEmp(
			Integer empID,
			String empName, 
			String empAccount,
			String empPassword,
			int empPermission,
			String empPhone,
			String empAddress,
			int jobID,
			java.sql.Date empHiredate) {

		EmpVO empVO = new EmpVO();

		empVO.setEmpID(empID);
		empVO.setEmpName(empName);
		empVO.setEmpAccount(empAccount);
		empVO.setEmpPassword(empPassword);
		empVO.setEmpPermission(empPermission);
		empVO.setEmpPhone(empPhone);
		empVO.setEmpAddress(empAddress);
		empVO.setJobID(jobID);
		empVO.setEmpHiredate(empHiredate);
		dao.update(empVO);

		return empVO;
	}

	//刪除員工
	public void deleteEmp(Integer empID) {
		dao.delete(empID);
	}

	//查詢一位員工資料
	public EmpVO getOneEmp(Integer empID) {
		return dao.findByPrimaryKey(empID);
	}

	//查詢所有員工資料
	public List<EmpVO> getAll() {
		return dao.getAll();
	}
	
	//使用empAccount找是否有職位
	public EmpVO getEmpAccountCheck(String empAccount) {
		return dao.checkRepeatEmpAccount(empAccount);
	}
}
