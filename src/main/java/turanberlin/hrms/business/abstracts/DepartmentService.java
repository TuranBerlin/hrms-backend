package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {
    DataResult<List<Department>> getAll();
}
