package com.functions.model;

import java.util.List;

public class FunctionsService {

	private FunctionsDAO_interface dao;

	public FunctionsService() {
		dao = new FunctionsDAO();
	}

	public FunctionsVO addFunctions(
			String functionName) {

		FunctionsVO functionsVO = new FunctionsVO();

		functionsVO.setFunctionName(functionName);

		dao.insert(functionsVO);

		return functionsVO;
	}

	public FunctionsVO updateFunctions(			
			int functionID, 
			String functionName) {

				FunctionsVO functionsVO = new FunctionsVO();

				functionsVO.setFunctionID(functionID);
				functionsVO.setFunctionName(functionName);
		
		dao.update(functionsVO);

		return functionsVO;
	}

	public void deleteFunctions(Integer functionID) {
		dao.delete(functionID);
	}

	public FunctionsVO getOneFunctions(Integer functionID) {
		return dao.findByPrimaryKey(functionID);
	}

	public List<FunctionsVO> getAll() {
		return dao.getAll();
	}
}
