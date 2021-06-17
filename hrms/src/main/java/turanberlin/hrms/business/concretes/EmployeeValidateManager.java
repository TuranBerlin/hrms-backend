package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.EmployeeValidateService;
import turanberlin.hrms.core.utils.resultSystem.ErrorResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.EmployerDao;
import turanberlin.hrms.entities.concretes.Employer;

@Service
public class EmployeeValidateManager implements EmployeeValidateService {
	
	private EmployerDao employerDao;

	@Autowired
	public EmployeeValidateManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result employeeValidate(Employer employer) {
		employer.setIsEmployeeConfirmed(true);
		this.employerDao.save(employer);
		if (employer.getIsEmployeeConfirmed() == true) {
			return new SuccessResult("Employee verified:" + employer.getCompanyName());
		}else {
			return new ErrorResult("Employer verification failed:" + employer.getCompanyName());
		}
	}

}
