package com.login.model;

import java.util.List;

public class EmpLoginService {

	private EmpLoginDAO_interface dao;

	public EmpLoginService() {
		dao = new EmpLoginDAO();
	}
}
