package turanberlin.hrms.business.abstracts;

import java.util.List;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Employee;

public interface EmployeeService {
	Result add(Employee employee);

	DataResult<List<Employee>> getEmployees();

}
