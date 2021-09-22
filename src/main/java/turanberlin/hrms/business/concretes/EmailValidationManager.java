package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.EmailValidationService;
import turanberlin.hrms.core.utils.resultSystem.ErrorResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.CandidateDao;
import turanberlin.hrms.dataAccess.abstracts.EmployerDao;
import turanberlin.hrms.entities.concretes.Candidate;
import turanberlin.hrms.entities.concretes.Employer;

@Service
public class EmailValidationManager implements EmailValidationService{
	
	private CandidateDao candidateDao;
	private EmployerDao employerDao;
	
	@Autowired
	public EmailValidationManager(CandidateDao candidateDao, EmployerDao employerDao) {
		super();
		this.candidateDao = candidateDao;
		this.employerDao = employerDao;
	}


	@Override
	public Result validate( Candidate candidate) {
		candidate.setIsEmailConfirmed(true);
		this.candidateDao.save(candidate);
		if (candidate.getIsEmailConfirmed() == true) {
			return new SuccessResult("Candidate e-mail verified");
		}else {
			return new ErrorResult("Candidate e-mail verification failed");
		}
	}			
	

	@Override
	public Result validate( Employer employer) {
		employer.setIsEmailConfirmed(true);
		this.employerDao.save(employer);
		if (employer.getIsEmailConfirmed() == true) {
			return new SuccessResult("Employer e-mail verified");
		}else {
			return new ErrorResult("Employer e-mail verification failed");
		}
	}
}


