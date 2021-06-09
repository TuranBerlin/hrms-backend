package turanberlin.hrms.business.concretes;

import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.EmployeeValidateService;
import turanberlin.hrms.core.utils.resultSystem.ErrorResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.entities.concretes.Employer;

@Service
public class EmployeeValidateManager implements EmployeeValidateService {

	@Override
	public Result employeeValidate(Employer employer) {
		employer.setEmployeeConfirmed(true);
		if (employer.isEmployeeConfirmed() == true) {
			return new SuccessResult("Employee verified:" + employer.getCompanyName());
		}else {
			return new ErrorResult("Employer verification failed:" + employer.getCompanyName());
		}
	}

}
