package com.functions.model;

import java.util.List;

public class FunctionsService {

	private FunctionsDAO_interface dao;

	public FunctionsService() {
		dao = new FunctionsDAO();
	}

	public FunctionsVO addFunctions(
			String function_name) {

		FunctionsVO functionsVO = new FunctionsVO();

		functionsVO.setFunction_name(function_name);

		dao.insert(functionsVO);

		return functionsVO;
	}

	public FunctionsVO updateFunctions(			
			int function_id, 
			String function_name) {

				FunctionsVO functionsVO = new FunctionsVO();

				functionsVO.setFunction_id(function_id);
				functionsVO.setFunction_name(function_name);
		
		dao.update(functionsVO);

		return functionsVO;
	}

	public void deleteFunctions(Integer function_id) {
		dao.delete(function_id);
	}

	public FunctionsVO getOneFunctions(Integer function_id) {
		return dao.findByPrimaryKey(function_id);
	}

	public List<FunctionsVO> getAll() {
		return dao.getAll();
	}
}
