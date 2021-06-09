package turanberlin.hrms.business.concretes;

import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.EmailService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.entities.concretes.Candidate;
import turanberlin.hrms.entities.concretes.Employer;

@Service
public class EmailManager implements EmailService{

	@Override
	public Result send(int code, Candidate to) {
		return new SuccessResult("E-mail sended to: " + to +
				"Message: Your validation code is: " + code);
	}

	@Override
	public Result send(int code, Employer to) {
		return new SuccessResult("E-mail sended to: " + to +
				"Message: Your validation code is: " + code);
		
	}

}
