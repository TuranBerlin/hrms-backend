package turanberlin.hrms.business.abstracts;

import java.util.List;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Candidate;

public interface CandidateService {
	
	DataResult<List<Candidate>> getCandidates();

	Result add(Candidate candidate, String confirmPassword) ;
	
}
