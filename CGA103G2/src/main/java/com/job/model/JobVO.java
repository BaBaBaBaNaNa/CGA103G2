package com.job.model;

public class JobVO implements java.io.Serializable{
	private int jobID;
	private String jobName;

	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	@Override
	public String toString() {
		return "JobVO [jobID=" + jobID + ", jobName=" + jobName +  "]";
	}
}
