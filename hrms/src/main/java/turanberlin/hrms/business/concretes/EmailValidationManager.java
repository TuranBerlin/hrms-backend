package turanberlin.hrms.business.concretes;

import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.EmailValidationService;
import turanberlin.hrms.core.utils.resultSystem.ErrorResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.entities.concretes.Candidate;
import turanberlin.hrms.entities.concretes.Employer;

@Service
public class EmailValidationManager implements EmailValidationService{
	
	
	@Override
	public Result validate( Candidate candidate) {
		candidate.setEmailConfirmed(true);
		if (candidate.isEmailConfirmed() == true) {
			return new SuccessResult("Candidate e-mail verified");
		}else {
			return new ErrorResult("Candidate e-mail verification failed");
		}
	}			
	

	@Override
	public Result validate( Employer employer) {
		employer.setEmailConfirmed(true);
		if (employer.isEmailConfirmed() == true) {
			return new SuccessResult("Employer e-mail verified");
		}else {
			return new ErrorResult("Employer e-mail verification failed");
		}
	}
}


