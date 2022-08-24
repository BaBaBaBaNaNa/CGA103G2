package com.permission.model1;

import java.util.List;

public class PermissionService {

	private PermissionDAO_interface dao;  

	public PermissionService() {
		dao = new PermissionDAO();
	}
//123
	public PermissionVO addPermission(
			int emp_id, 
			int function_id) {

		PermissionVO permissionVO = new PermissionVO();

		permissionVO.setEmp_id(emp_id);
		permissionVO.setFunction_id(function_id);

		dao.insert(permissionVO);

		return permissionVO;
	}

	public PermissionVO updatePermission(			
			int emp_id, 
			int function_id) {

		PermissionVO permissionVO = new PermissionVO();

		permissionVO.setEmp_id(emp_id);
		permissionVO.setFunction_id(function_id);
		
		dao.update(permissionVO);

		return permissionVO;
	}

	public void deletePermission(Integer emp_id) {
		dao.delete(emp_id);
	}

	public PermissionVO getOnePermission(Integer emp_id) {
		return dao.findByPrimaryKey(emp_id);
	}

	public List<PermissionVO> getAll() {
		return dao.getAll();
	}
}
