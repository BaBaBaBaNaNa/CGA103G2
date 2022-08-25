package com.functions.model;

public class FunctionsVO implements java.io.Serializable{
	private int functionID;
	private String functionName;
	
	public int getFunctionID() {
		return functionID;
	}
	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
}
