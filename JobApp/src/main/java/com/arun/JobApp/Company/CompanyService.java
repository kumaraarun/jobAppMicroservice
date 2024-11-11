package com.arun.JobApp.Company;

import java.util.List;

public interface CompanyService {

	

	List<Company> findAll();

	void createCompany(Company company);

	boolean updateCompany(Long id,Company updatedCompany);

	boolean deleteJob(Long id);

    Company findCompaniesById(Long id);
     

}
