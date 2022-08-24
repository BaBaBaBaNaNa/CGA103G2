package com.job.model;

import java.util.List;

public class JobService {

	private JobDAO_interface dao;

	public JobService() {
		dao = new JobDAO();
	}

	public JobVO addJob(
			String job_name) {

		JobVO jobVO = new JobVO();

		jobVO.setJob_name(job_name);

		dao.insert(jobVO);

		return jobVO;
	}

	public JobVO updateJob(			
			int job_id, 
			String job_name) {

				JobVO jobVO = new JobVO();

				jobVO.setJob_id(job_id);
				jobVO.setJob_name(job_name);
		
		dao.update(jobVO);

		return jobVO;
	}

	public void deleteJob(Integer job_id) {
		dao.delete(job_id);
	}

	public JobVO getOneJob(Integer job_id) {
		return dao.findByPrimaryKey(job_id);
	}

	public List<JobVO> getAll() {
		return dao.getAll();
	}
}
