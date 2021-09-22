package turanberlin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.EmployeeService;
import turanberlin.hrms.business.abstracts.UserInfoValidateService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.ErrorResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.EmployeeDao;
import turanberlin.hrms.entities.concretes.Employee;


@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	private UserInfoValidateService userInfoValidateService;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, UserInfoValidateService userInfoValidateService) {
		super();
		this.employeeDao = employeeDao;
		this.userInfoValidateService = userInfoValidateService;
	}

	@Override
	public DataResult<List<Employee>> getEmployees() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "Data listed");
	}

	@Override
	public Result add(Employee employee) {
	if(userInfoValidateService.validate(employee)) {
		if (this.getByEmail(employee.getEmail()).isEmpty()) {
		if (new String(employee.getPassword()).equals(employee.getConfirmPassword())) {
			this.employeeDao.save(employee);
			return new SuccessResult("Success: Employee added");
		}
		else{
			return new ErrorResult("Error: Employee add operation failed");
		}
	} else {
		return new ErrorResult("Error: Employee add operation failed");
	}} else {
		return new ErrorResult("Error: Employee add operation failed");
	}
	}

	private List<Employee> getByEmail(String email) {
		return this.employeeDao.getByEmail(email);
	}
}
