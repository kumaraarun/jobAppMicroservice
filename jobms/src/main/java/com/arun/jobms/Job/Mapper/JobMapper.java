package com.arun.jobms.Job.Mapper;

import java.util.List;

import com.arun.jobms.Job.Job;
import com.arun.jobms.Job.External.Company;
import com.arun.jobms.Job.External.Review;
import com.arun.jobms.Job.dto.JobDTO;

public class JobMapper {
	public static JobDTO mapJobwithCompanyDTO(Job job,Company company,List<Review> reviews) {
		
		JobDTO jobDTO=new JobDTO();
		jobDTO.setId(job.getId());
		jobDTO.setTitle(job.getTitle());
		jobDTO.setDescription(job.getDescription());
		jobDTO.setMaxSalary(job.getMaxSalary());
		jobDTO.setMinSalary(job.getMinSalary());
		jobDTO.setLocation(job.getLocation());
		jobDTO.setCompany(company);
		jobDTO.setReviews(reviews);
		return jobDTO;

	}

}
