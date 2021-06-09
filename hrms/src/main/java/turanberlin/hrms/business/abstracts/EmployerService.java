package turanberlin.hrms.business.abstracts;

import java.util.List;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getEmployers();

	Result add(Employer employer, String confirmPassword);

}
