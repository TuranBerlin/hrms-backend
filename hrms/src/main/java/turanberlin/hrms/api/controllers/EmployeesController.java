package turanberlin.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import turanberlin.hrms.business.abstracts.EmployeeService;
import turanberlin.hrms.business.abstracts.EmployeeValidateService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.ErrorDataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Employee;
import turanberlin.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {

	private EmployeeService employeeService;
	private EmployeeValidateService employeeValidateService;

	@Autowired
	public EmployeesController(EmployeeService employeeService, EmployeeValidateService employeeValidateService) {
		super();
		this.employeeService = employeeService;
		this.employeeValidateService = employeeValidateService;
	}

	@GetMapping("/get/all")
	public DataResult<List<Employee>> getEmployees() {
		return this.employeeService.getEmployees();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee , String confirmPassword) {
		return ResponseEntity.ok(this.employeeService.add(employee , confirmPassword));
	}
	
	@PostMapping("/verify/employer")
	public Result validate(@RequestBody Employer employer) {
		 return this.employeeValidateService.employeeValidate(employer);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
	

}
