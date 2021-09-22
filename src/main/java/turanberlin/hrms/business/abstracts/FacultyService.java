package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.Faculty;

import java.util.List;

public interface FacultyService {
    DataResult<List<Faculty>> getAll();
}
