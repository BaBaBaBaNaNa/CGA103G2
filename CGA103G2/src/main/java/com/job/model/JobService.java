package com.job.model;

import java.util.List;

public class JobService {

	private JobDAO_interface dao;

	public JobService() {
		dao = new JobDAO();
	}

	public JobVO addJob(
			String jobName) {

		JobVO jobVO = new JobVO();

		jobVO.setJobName(jobName);

		dao.insert(jobVO);

		return jobVO;
	}

	public JobVO updateJob(			
			int jobID, 
			String jobName) {

				JobVO jobVO = new JobVO();

				jobVO.setJobID(jobID);
				jobVO.setJobName(jobName);
		
		dao.update(jobVO);

		return jobVO;
	}

	public void deleteJob(Integer jobID) {
		dao.delete(jobID);
	}

	public JobVO getOneJob(Integer jobID) {
		return dao.findByPrimaryKey(jobID);
	}

	public List<JobVO> getAll() {
		return dao.getAll();
	}
}
