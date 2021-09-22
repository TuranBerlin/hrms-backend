package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turanberlin.hrms.business.abstracts.JobTimeService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.dataAccess.abstracts.JobTimeDao;
import turanberlin.hrms.entities.concretes.JobTime;

import java.util.List;

@Service
public class JobTimeManager implements JobTimeService {

    private JobTimeDao jobTimeDao;

    @Autowired
    public JobTimeManager(JobTimeDao jobTimeDao) {
        this.jobTimeDao = jobTimeDao;
    }

    @Override
    public DataResult<List<JobTime>> getAll() {
        return new SuccessDataResult<List<JobTime>>(this.jobTimeDao.findAll(),"Data listed");
    }
}
