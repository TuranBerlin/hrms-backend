package turanberlin.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import turanberlin.hrms.business.abstracts.DepartmentService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.Department;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentsController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/get/all")
    public DataResult<List<Department>> getAll() {
        return this.departmentService.getAll();
    }
}
