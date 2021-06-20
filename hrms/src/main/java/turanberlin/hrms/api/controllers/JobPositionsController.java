package turanberlin.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turanberlin.hrms.business.abstracts.JobPositionService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.JobPosition;

@CrossOrigin
@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {

	private JobPositionService jobPositionService;

	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/get/all")
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionService.getAll();
	}
}
