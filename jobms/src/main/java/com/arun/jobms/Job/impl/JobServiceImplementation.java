package com.arun.jobms.Job.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arun.jobms.Job.Job;
import com.arun.jobms.Job.JobRepository;
import com.arun.jobms.Job.JobService;
import com.arun.jobms.Job.External.Company;
import com.arun.jobms.Job.External.Review;
import com.arun.jobms.Job.Mapper.JobMapper;
import com.arun.jobms.Job.client.CompanyClient;
import com.arun.jobms.Job.client.ReviewClient;
import com.arun.jobms.Job.dto.JobDTO;
@Service
public class JobServiceImplementation implements JobService {
	//private List<Job> jobs=new ArrayList<>();
	//private long nextId=1l;
	
	JobRepository jobRepository;
	@Autowired
	RestTemplate restTemplate;
	
	private CompanyClient companyClient;
	private ReviewClient reviewClient;
	
	
	

	public JobServiceImplementation(JobRepository jobRepository,CompanyClient companyClient,ReviewClient reviewClient) {
		super();
		this.jobRepository = jobRepository;
		this.companyClient=companyClient;
		this.reviewClient=reviewClient;
	}

//	@Override
//	public List<Job> findAll() {
//		RestTemplate restTemplate=new RestTemplate();
//		Company company=restTemplate.getForObject("http://localhost:8081/companies/1",Company.class);
//		System.out.println("company :"+company.getCompanyName());
//		System.out.println("company :" +company.getId());
//		return jobRepository.findAll();
//	}
	@Override
	public List<JobDTO> findAll() {
		List<Job> jobs=jobRepository.findAll();
		List<JobDTO> jobDTOs=new ArrayList<JobDTO>();

		return jobs.stream().map(this::converttoDto).collect(Collectors.toList());
	}
	
	private JobDTO converttoDto(Job job)
	{
//		  RestTemplate restTemplate=new RestTemplate();

			Company company=companyClient.getCompany(job.getCompanyId());
		    List<Review> reviews=reviewClient.getReviews(job.getCompanyId());
			JobDTO jobDTO=JobMapper.mapJobwithCompanyDTO(job,company,reviews);
//			jobDTO.setCompany(company);
			return jobDTO;

	}
	

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
		
	}
//   public Job getJobById(Long id) {
//       return jobRepository.findById(id).orElse(null);
//	}
	 public JobDTO getJobById(Long id) {
	       Job job=jobRepository.findById(id).orElse(null);
	       return converttoDto(job);
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
