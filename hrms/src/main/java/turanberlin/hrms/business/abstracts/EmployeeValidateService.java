package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Employer;

public interface EmployeeValidateService {

	Result employeeValidate(Employer employer);
}
