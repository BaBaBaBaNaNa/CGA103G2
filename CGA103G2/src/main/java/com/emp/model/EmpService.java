package com.emp.model;

import java.util.List;

public class EmpService {

	private EmpDAO_interface dao;

	public EmpService() {
		dao = new EmpDAO();
	}

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

	public void deleteEmp(Integer empID) {
		dao.delete(empID);
	}

	public EmpVO getOneEmp(Integer empID) {
		return dao.findByPrimaryKey(empID);
	}

	public List<EmpVO> getAll() {
		return dao.getAll();
	}
}
