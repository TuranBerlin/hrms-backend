package turanberlin.hrms.api.controllers;

import java.rmi.RemoteException;
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

import turanberlin.hrms.core.utils.resultSystem.ErrorDataResult;
import turanberlin.hrms.business.abstracts.CandidateService;
import turanberlin.hrms.business.abstracts.EmailService;
import turanberlin.hrms.business.abstracts.EmailValidationService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping(value = "/api/users")
public class CandidatesController {

	CandidateService candidateService;
	EmailService emailService;
	EmailValidationService emailValidationService;

	@Autowired
	public CandidatesController(CandidateService candidateService, EmailService emailService,
			EmailValidationService emailValidationService) {
		super();
		this.candidateService = candidateService;
		this.emailService = emailService;
		this.emailValidationService = emailValidationService;
	}

	@GetMapping("/get/candidates")
	public DataResult<List<Candidate>> getCandidates() {
		return this.candidateService.getCandidates();
	}

	@PostMapping(value = "/add/candidate")
	public ResponseEntity<?> add(@Valid @RequestBody Candidate candidate, String confirmPassword) throws NumberFormatException, RemoteException {
		return ResponseEntity.ok(this.candidateService.add(candidate , confirmPassword));
	}
	
	@PostMapping("/sendVerificationCode/candidate")
	public Result send(@RequestBody Candidate to, int code) {
		 return this.emailService.send(code, to);
	}

	@PostMapping("/verify/candidate")
	public Result validate(@RequestBody Candidate candidate) {
		 return this.emailValidationService.validate(candidate);
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
