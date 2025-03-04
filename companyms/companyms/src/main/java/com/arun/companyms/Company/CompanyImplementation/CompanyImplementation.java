package com.arun.companyms.Company.CompanyImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arun.companyms.Company.Company;
import com.arun.companyms.Company.CompanyRepository;
import com.arun.companyms.Company.CompanyService;

@Service
public class CompanyImplementation implements CompanyService{
	private CompanyRepository companyRepository;
	
	

	public CompanyImplementation(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}



	public List<Company> findAll() {
		return companyRepository.findAll() ;
	}



	public void createCompany(Company company) {
		 companyRepository.save(company);
		
	}



	public boolean updateCompany(Long id,Company updatedCompany) {
		Optional<Company> optional=companyRepository.findById(id);
		if(optional.isPresent())
		{
			Company company=optional.get();
			company.setCompanyName(updatedCompany.getCompanyName());
			company.setDescription(updatedCompany.getDescription());
			
			companyRepository.save(company);
			return true;
		}
		 
		return false;
	}



	@Override
	public boolean deleteJob(Long id) {
		if(companyRepository.existsById(id))
		{
			companyRepository.deleteById(id);
			return true;
		}
		return false;
	}



	@Override
	public Company findCompaniesById(Long id) {
		
		return companyRepository.findById(id).orElse(null);
	}

}
