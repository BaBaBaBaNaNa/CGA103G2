package com.job.model;

import java.util.List;

public class JobService {

	private JobDAO_interface dao;

	public JobService() {
		dao = new JobDAO();
	}

	//新增職位
	public JobVO addJob(
			String jobName) {

		JobVO jobVO = new JobVO();

		jobVO.setJobName(jobName);

		dao.insert(jobVO);

		return jobVO;
	}

	//修改職位
	public JobVO updateJob(			
			int jobID, 
			String jobName) {

				JobVO jobVO = new JobVO();

				jobVO.setJobID(jobID);
				jobVO.setJobName(jobName);
		
		dao.update(jobVO);

		return jobVO;
	}

	//刪除職位
	public void deleteJob(Integer jobID) {
		dao.delete(jobID);
	}

	//使用jobID找某職位
	public JobVO getOneJob(Integer jobID) {
		return dao.findByPrimaryKey(jobID);
	}

	//查詢全部職位
	public List<JobVO> getAll() {
		return dao.getAll();
	}
	
	//使用jobName找是否有職位
	public JobVO getJobNameCheck(String jobName) {
		return dao.checkRepeatJobName(jobName);
	}
}
