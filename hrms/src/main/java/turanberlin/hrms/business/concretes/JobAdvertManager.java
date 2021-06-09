package turanberlin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.JobAdvertService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.JobAdvertDao;
import turanberlin.hrms.entities.concretes.JobAdvert;
import turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getJobAdverts() {

		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(),"Data listed");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("Success: Job advertisement added");
	}

	@Override
	public DataResult<List<JobAdvertWithDetailsDto>> getByEmployerId(int employerId) {
		return new SuccessDataResult<List<JobAdvertWithDetailsDto>>(this.jobAdvertDao.getByEmployerId(employerId));
	}

	@Override
	public DataResult<List<JobAdvertWithDetailsDto>> getJobAdvertWithDetails() {
		return new SuccessDataResult<List<JobAdvertWithDetailsDto>>(this.jobAdvertDao.getJobAdvertWithDetails(),"Data listed");
	}

	@Override
	public Result setAdvertStatus(Boolean status, int advertId) {
		this.jobAdvertDao.getById(advertId).setIsAdvertActive(status);
		return new SuccessResult("Success: Job advertisements status updated");
	}

	@Override
	public DataResult<List<JobAdvertWithDetailsDto>> getJobAdvertWithDetailsByDateOrder() {
		return new SuccessDataResult<List<JobAdvertWithDetailsDto>>(this.jobAdvertDao.getJobAdvertWithDetailsByDateOrder());
	}

}
