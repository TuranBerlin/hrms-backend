package turanberlin.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import turanberlin.hrms.business.abstracts.FacultyService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.Faculty;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/faculties")
public class FacultiesController {

    private FacultyService facultyService;

    @Autowired
    public FacultiesController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/get/all")
    public DataResult<List<Faculty>> getAll() {
        return this.facultyService.getAll();
    }
}
