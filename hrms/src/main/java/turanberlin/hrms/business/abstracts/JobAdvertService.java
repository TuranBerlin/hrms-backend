package turanberlin.hrms.business.abstracts;

import java.util.List;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.JobAdvert;
import turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto;

public interface JobAdvertService {
	DataResult<List<JobAdvert>> getJobAdverts();

	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvertWithDetailsDto>> getByEmployerId(int employerId);
	
	DataResult<List<JobAdvertWithDetailsDto>> getJobAdvertWithDetails();
	
	DataResult<List<JobAdvertWithDetailsDto>> getJobAdvertWithDetailsByDateOrder();
	
	Result setAdvertStatus(Boolean status, int advertId);

}
