package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Candidate;
import turanberlin.hrms.entities.concretes.Employer;

public interface EmailValidationService {

	Result validate(Candidate candidate);
	
	Result validate(Employer employer);
	

}
