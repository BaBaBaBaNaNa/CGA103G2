package com.job.model;
import java.util.*;

public interface JobDAO_interface {
	public void insert(JobVO jobVO);
    public void update(JobVO jobVO);
    public void delete(Integer job_id);
    public JobVO findByPrimaryKey(Integer job_id);
    public List<JobVO> getAll();
}
