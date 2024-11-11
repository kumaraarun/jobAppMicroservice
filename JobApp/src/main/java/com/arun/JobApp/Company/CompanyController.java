package com.arun.JobApp.Company;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arun.JobApp.Job.JobService;

import ch.qos.logback.core.joran.conditional.IfAction;

import java.util.List;

import org.hibernate.ObjectDeletedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/companies")
public class CompanyController {
	 private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
	@GetMapping
	public ResponseEntity<List<Company>> findCompanies() {
		return ResponseEntity.ok(companyService.findAll());
	}
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company)
	{
		companyService.createCompany(company);
		return new ResponseEntity<String>("succesfully created",HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updatedCompany) {
		boolean updated=companyService.updateCompany(id,updatedCompany);
		if(updated)
			return new ResponseEntity<String>("succesfully updated",HttpStatus.OK);
		
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable Long id)
	{
         boolean deleted=companyService.deleteJob(id);
         if(deleted)
        	 return new ResponseEntity<String>("deleted succesfully",HttpStatus.OK);
         return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Company> findCompaniesById(@PathVariable Long id) {
		Company company=companyService.findCompaniesById(id);
		if(company!=null)
			return new ResponseEntity<>(company,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	

}
