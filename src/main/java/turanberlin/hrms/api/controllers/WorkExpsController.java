package turanberlin.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turanberlin.hrms.business.abstracts.WorkExpService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.WorkExp;

@RestController
@RequestMapping(value="/api/workExps")
public class WorkExpsController {
	
	private WorkExpService workExpService;

	@Autowired
	public WorkExpsController(WorkExpService workExpService) {
		super();
		this.workExpService = workExpService;
	}
	
	@PostMapping(value="/add/workExp")
	public Result add(@RequestBody WorkExp workExp) {
		return this.workExpService.add(workExp);
	}

}
