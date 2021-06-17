package turanberlin.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import turanberlin.hrms.business.abstracts.JobAdvertService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.JobAdvert;
import turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto;

@RestController
@RequestMapping("/api/jobAdverts")
public class JobAdvertsController {

	private JobAdvertService jobAdvertService;
	
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}

	@GetMapping("/get/all")
	public DataResult<List<JobAdvert>> getJobAdverts() {
		return this.jobAdvertService.getJobAdverts();
	}
	
	@GetMapping("/get/jobAdvertWithDetails")
	public DataResult<List<JobAdvertWithDetailsDto>> getJobAdvertWithDetails() {
		return this.jobAdvertService.getJobAdvertWithDetails();
	}
	
	@GetMapping("/get/jobAdvertWithDetails/pageable")
	public DataResult<List<JobAdvertWithDetailsDto>> getJobAdvertWithDetailsPageable(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return this.jobAdvertService.getAllByPage( pageNumber,  pageSize);
	}
	
	@GetMapping("/get/jobAdvertWithDetails/dateOrder")
	public DataResult<List<JobAdvertWithDetailsDto>> getJobAdvertWithDetailsByDateOrder() {
		return this.jobAdvertService.getJobAdvertWithDetailsByDateOrder();
	}
	
	@GetMapping("/getByCompanyName")
	public DataResult<List<JobAdvertWithDetailsDto>> getByEmployerId(int employerId) {
		return this.jobAdvertService.getByEmployerId(employerId);
	}
	
	@PostMapping("/add/jobAdvert")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/changeStatus/jobAdvert")
	public Result setAdvertStatus(@RequestBody Boolean status, @RequestBody int advertId) {
		return this.jobAdvertService.setAdvertStatus(status, advertId);
	}
	
}
