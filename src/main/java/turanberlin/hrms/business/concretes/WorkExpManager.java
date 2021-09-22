package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.WorkExpService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.WorkExpDao;
import turanberlin.hrms.entities.concretes.WorkExp;

@Service
public class WorkExpManager implements WorkExpService{
	
	private WorkExpDao workExpDao;

	@Autowired
	public WorkExpManager(WorkExpDao workExpDao) {
		super();
		this.workExpDao = workExpDao;
	}

	@Override
	public Result add(WorkExp workExp) {
		this.workExpDao.save(workExp);
		return new SuccessResult("Success: Work Exprience added");
	}

}
