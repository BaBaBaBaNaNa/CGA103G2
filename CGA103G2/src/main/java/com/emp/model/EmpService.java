package com.emp.model;

import java.util.List;

public class EmpService {

	private EmpDAO_interface dao;

	public EmpService() {
		dao = new EmpDAO();
	}

	public EmpVO addEmp(
			String emp_name, 
			String emp_account,
			String emp_password,
			int emp_permission,
			String emp_phone,
			String emp_address,
			int emp_job,
			java.sql.Date emp_hiredate) {

		EmpVO empVO = new EmpVO();

		empVO.setEmp_name(emp_name);
		empVO.setEmp_account(emp_account);
		empVO.setEmp_password(emp_password);
		empVO.setEmp_permission(emp_permission);
		empVO.setEmp_phone(emp_phone);
		empVO.setEmp_address(emp_address);
		empVO.setEmp_job(emp_job);
		empVO.setEmp_hiredate(emp_hiredate);
		dao.insert(empVO);

		return empVO;
	}

	public EmpVO updateEmp(
			Integer emp_id,
			String emp_name, 
			String emp_account,
			String emp_password,
			int emp_permission,
			String emp_phone,
			String emp_address,
			int emp_job,
			java.sql.Date emp_hiredate) {

		EmpVO empVO = new EmpVO();

		empVO.setEmp_id(emp_id);
		empVO.setEmp_name(emp_name);
		empVO.setEmp_account(emp_account);
		empVO.setEmp_password(emp_password);
		empVO.setEmp_permission(emp_permission);
		empVO.setEmp_phone(emp_phone);
		empVO.setEmp_address(emp_address);
		empVO.setEmp_job(emp_job);
		empVO.setEmp_hiredate(emp_hiredate);
		dao.update(empVO);

		return empVO;
	}

	public void deleteEmp(Integer emp_id) {
		dao.delete(emp_id);
	}

	public EmpVO getOneEmp(Integer emp_id) {
		return dao.findByPrimaryKey(emp_id);
	}

	public List<EmpVO> getAll() {
		return dao.getAll();
	}
}
