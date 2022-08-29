package com.permission.model;

import java.util.List;

public class PermissionService {

	private PermissionDAO_interface dao;  

	public PermissionService() {
		dao = new PermissionDAO();
	}
//123
	public PermissionVO addPermission(
			int empID, 
			int functionID) {

		PermissionVO permissionVO = new PermissionVO();

		permissionVO.setEmpID(empID);
		permissionVO.setFunctionID(functionID);

		dao.insert(permissionVO);

		return permissionVO;
	}

	public PermissionVO updatePermission(			
			int empID, 
			int functionID) {

		PermissionVO permissionVO = new PermissionVO();

		permissionVO.setEmpID(empID);
		permissionVO.setFunctionID(functionID);
		
		dao.update(permissionVO);

		return permissionVO;
	}

	public void deletePermission(Integer empID) {
		dao.delete(empID);
	}

	public PermissionVO getOnePermission(Integer empID) {
		return dao.findByPrimaryKey(empID);
	}

	public List<PermissionVO> getAll() {
		return dao.getAll();
	}
}
