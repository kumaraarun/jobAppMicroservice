package com.arun.jobms.Job;
import java.util.List;

import com.arun.jobms.Job.dto.JobDTO;

public interface JobService {
	List<JobDTO> findAll();
	void createJob(Job job);
	JobDTO getJobById(Long id);
	boolean deleteById(Long id);
	boolean updateJob(Long id, Job updatedJob);
	
	

}
