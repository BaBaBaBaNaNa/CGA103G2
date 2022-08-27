package com.permission.model;

public class PermissionVO implements java.io.Serializable{
	private int empID;
	private int functionID;
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public int getFunctionID() {
		return functionID;
	}
	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}

}