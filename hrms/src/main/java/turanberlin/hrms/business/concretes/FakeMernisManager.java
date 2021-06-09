package turanberlin.hrms.business.concretes;

import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.FakeMernisService;
import turanberlin.hrms.entities.concretes.Candidate;

@Service
public class FakeMernisManager implements FakeMernisService{
	@Override
	public boolean fakeMernisValidate( Candidate candidate) {

			return true;
	}	

}
