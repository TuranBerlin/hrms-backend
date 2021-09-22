package turanberlin.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import turanberlin.hrms.business.abstracts.JobTimeService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.JobTime;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/jobTimes")
public class JobTimesController {

    private JobTimeService jobTimeService;

    public JobTimesController(JobTimeService jobTimeService) {
        this.jobTimeService = jobTimeService;
    }

    @GetMapping("/get/all")
    public DataResult<List<JobTime>> getAll() {
        return this.jobTimeService.getAll();
    }

}
