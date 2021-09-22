package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.entities.concretes.Candidate;
import turanberlin.hrms.entities.concretes.Employee;
import turanberlin.hrms.entities.concretes.Employer;

public interface UserInfoValidateService{
	
	boolean validate(Candidate candidate); 

	boolean validate(Employer employer);

	boolean validate(Employee employee);

}
