package turanberlin.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turanberlin.hrms.business.abstracts.CandidateCvService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.CandidateCv;

@RestController
@RequestMapping("/api/candiateCvs")
public class CandidateCvsController {

	private CandidateCvService candidateCvService;

	@Autowired
	public CandidateCvsController(CandidateCvService candidateCvService) {
		super();
		this.candidateCvService = candidateCvService;
	}
	
	@GetMapping("/get/candidateCvs")
	public DataResult<List<CandidateCv>> getAll() {
		return this.candidateCvService.getAll();
	}
	
	@PostMapping("/add/candidateCv")
	public Result add(@RequestBody CandidateCv candidateCv) {
		return this.candidateCvService.add(candidateCv);
	}
}
