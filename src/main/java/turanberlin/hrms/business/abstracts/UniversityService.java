package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.University;

import java.util.List;

public interface UniversityService {
    DataResult<List<University>> getAll();
}
