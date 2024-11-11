package com.arun.JobApp.Job.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arun.JobApp.Job.Job;
import com.arun.JobApp.Job.JobRepository;
import com.arun.JobApp.Job.JobService;
@Service
public class JobServiceImplementation implements JobService {
	//private List<Job> jobs=new ArrayList<>();
	//private long nextId=1l;
	
	JobRepository jobRepository;
	
	

	public JobServiceImplementation(JobRepository jobRepository) {
		super();
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
		
	}
   public Job getJobById(Long id) {
       return jobRepository.findById(id).orElse(null);
	}


public boolean deleteById(Long id) {
	try {
	jobRepository.deleteById(id);
			return true;
		}
	catch(Exception e) {
	return false;
	}
}

@Override
public boolean updateJob(Long id, Job updatedJob) {
	Optional<Job> optional=jobRepository.findById(id);
		if(optional.isPresent())
		{
			Job job=optional.get();
			job.setTitle(updatedJob.getTitle());
			job.setDescription(updatedJob.getDescription());
			job.setMaxSalary(updatedJob.getMaxSalary());
			job.setMinSalary(updatedJob.getMinSalary());
			job.setLocation(updatedJob.getLocation());
			jobRepository.save(job);
			return true;
		}
	
	return false;
}

}
