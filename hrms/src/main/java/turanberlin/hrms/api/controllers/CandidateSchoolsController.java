package turanberlin.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turanberlin.hrms.business.abstracts.CandidateSchoolService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.CandidateSchool;

@RestController
@RequestMapping(value = "/api/candidateSchools")
public class CandidateSchoolsController {
	
	CandidateSchoolService candidateSchoolService;

	@Autowired
	public CandidateSchoolsController(CandidateSchoolService candidateSchoolService) {
		super();
		this.candidateSchoolService = candidateSchoolService;
	}
	
	@PostMapping(value = "/add/candidateSchool")
	public Result add(@RequestBody CandidateSchool candidateSchool) {
		return this.candidateSchoolService.add(candidateSchool);
	}

}
