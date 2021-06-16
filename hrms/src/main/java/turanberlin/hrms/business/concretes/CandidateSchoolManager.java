package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.CandidateSchoolService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.CandidateSchoolDao;
import turanberlin.hrms.entities.concretes.CandidateSchool;

@Service
public class CandidateSchoolManager implements CandidateSchoolService{

	private CandidateSchoolDao candidateSchoolDao;
	
	@Autowired
	public CandidateSchoolManager(CandidateSchoolDao candidateSchoolDao) {
		super();
		this.candidateSchoolDao = candidateSchoolDao;
	}

	@Override
	public Result add(CandidateSchool candidateSchool) {
		this.candidateSchoolDao.save(candidateSchool);
		return new SuccessResult("Success: Candidate school added");
	}

}
