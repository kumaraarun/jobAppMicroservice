package com.arun.jobms.Job.External;


	public class Company {
		
		private Long id;
		private String companyName;
		private String description;
		
		
		
		
		
		
		
		public Company(long id, String companyName, String locationString, String description) {
			super();
			this.id = id;
			this.companyName = companyName;
			this.description = description;
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	
		

	}



