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

import turanberlin.hrms.business.abstracts.EmailService;
import turanberlin.hrms.business.abstracts.EmailValidationService;
import turanberlin.hrms.business.abstracts.EmployerService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.ErrorDataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/users")
public class EmployersController {

	private EmployerService employerService;
	private EmailService emailService;
	private EmailValidationService emailValidationService;

	@Autowired
	public EmployersController(EmployerService employerService, EmailService emailService,
			EmailValidationService emailValidationService) {
		super();
		this.employerService = employerService;
		this.emailService = emailService;
		this.emailValidationService = emailValidationService;
	}

	@GetMapping("/get/employer")
	public DataResult<List<Employer>> getEmployers() {
		return this.employerService.getEmployers();
	}

	@PostMapping("/add/employer")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer , String confirmPassword) {
		return ResponseEntity.ok(this.employerService.add(employer , confirmPassword));
	}
	
	@PostMapping("/sendVerificationCode/employer")
	public Result send(@RequestBody Employer to, int code) {
		 return this.emailService.send(code,to);
	}

	@PostMapping("/verify/employer")
	public Result validate(@RequestBody Employer employer) {
		 return this.emailValidationService.validate(employer);
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
