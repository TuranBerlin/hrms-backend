package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.JobTime;

import java.util.List;

public interface JobTimeService {

    DataResult<List<JobTime>> getAll();
}
