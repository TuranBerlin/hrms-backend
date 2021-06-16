package turanberlin.hrms.business.abstracts;

import java.util.List;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.CandidateCv;

public interface CandidateCvService {
	
	DataResult<List<CandidateCv>> getAll();
	
	Result add(CandidateCv candidateCv);

}
