package turanberlin.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import turanberlin.hrms.business.abstracts.UniversityService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.University;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {

    private UniversityService universityService;

    @Autowired
    public UniversitiesController(UniversityService universityService) {
        super();
        this.universityService = universityService;
    }

    @GetMapping("/get/all")
    public DataResult<List<University>> getAll() {
        return this.universityService.getAll();
    }
}
