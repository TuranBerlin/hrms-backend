package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.Candidate;
import turanberlin.hrms.entities.concretes.Employer;

public interface EmailService {

	Result send(int code , Candidate to);

	Result send(int code , Employer to);
}
