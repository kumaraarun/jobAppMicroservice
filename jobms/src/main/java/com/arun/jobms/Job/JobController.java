package com.arun.jobms.Job;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arun.jobms.Job.dto.JobDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/jobs")
@RestController
public class JobController {
	
	private JobService jobService;
	
	
	public JobController(JobService jobService) {
		super();
		this.jobService = jobService;
	}
	@GetMapping
	public ResponseEntity<List<JobDTO>> findAll()
	{
		return ResponseEntity.ok(jobService.findAll());
	}
	@PostMapping
	public  ResponseEntity<String> createJob(@RequestBody Job job) {
	    jobService.createJob(job);
		return new ResponseEntity<String>("succesfully created done",HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<JobDTO> findbyId(@PathVariable Long id)
	{
		JobDTO jobDTO=jobService.getJobById(id);
		if(jobDTO!=null)
			return new ResponseEntity<>(jobDTO,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id)
	{
		boolean deleted=jobService.deleteById(id);
		if(deleted)
			return  new ResponseEntity<String>("succesfully deleted",HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob)
	{
		boolean updated=jobService.updateJob(id,updatedJob);
		if(updated)
			return new ResponseEntity<String>("Succesfully updated",HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
