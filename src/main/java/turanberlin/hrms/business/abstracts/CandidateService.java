package turanberlin.hrms.business.abstracts;

import java.util.List;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Candidate;


public interface CandidateService {
	
	DataResult<List<Candidate>> getCandidates();
	
	DataResult<List<Candidate>> orderByCandidateCv_CandidateSchools_GraduationYearDesc();
	
	DataResult<List<Candidate>> OrderByCandidateCv_WorkExps_YearOfLeavingDesc();

	Result add(Candidate candidate) ;
	
}
