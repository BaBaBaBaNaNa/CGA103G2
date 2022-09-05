package com.job.model;
import java.util.*;

public interface JobDAO_interface {
	public void insert(JobVO jobVO);
    public void update(JobVO jobVO);
    public void delete(Integer jobID);
    public JobVO findByPrimaryKey(Integer jobID);
    public List<JobVO> getAll();
    public JobVO checkRepeatJobName(String jobName);
}
