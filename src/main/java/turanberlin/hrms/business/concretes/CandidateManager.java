package turanberlin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.CandidateService;
import turanberlin.hrms.business.abstracts.FakeMernisService;
import turanberlin.hrms.business.abstracts.UserInfoValidateService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.ErrorResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.CandidateDao;
import turanberlin.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserInfoValidateService userInfoValidateService;
	private FakeMernisService fakeMernisService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserInfoValidateService userInfoValidateService,
			FakeMernisService fakeMernisService) {
		super();
		this.candidateDao = candidateDao;
		this.userInfoValidateService = userInfoValidateService;
		this.fakeMernisService = fakeMernisService;
	}

	@Override
	public DataResult<List<Candidate>> getCandidates() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listed");
	}
	

	@Override
	public DataResult<List<Candidate>> orderByCandidateCv_CandidateSchools_GraduationYearDesc() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.OrderByCandidateCv_CandidateSchools_GraduationYearDesc(),"Data listed");
	}
	

	@Override
	public DataResult<List<Candidate>> OrderByCandidateCv_WorkExps_YearOfLeavingDesc() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.OrderByCandidateCv_WorkExps_YearOfLeavingDesc());
	}


	@Override
	public Result add(Candidate candidate) {
		if (this.userInfoValidateService.validate(candidate))
			if (this.getByNationalIdentityNumber(candidate.getNationalIdentityNumber()).isEmpty())
				if (this.getByEmail(candidate.getEmail()).isEmpty())
					if (this.fakeMernisService.fakeMernisValidate(candidate) == true)
						if (candidate.getPassword().equals(candidate.getConfirmPassword())) {
							this.candidateDao.save(candidate);
							return new SuccessResult("Success: Candidate added");
						} else {
							return new ErrorResult(
									"Error: Employer add operation failed, password and confirm password not same");
						}
					else {
						return new ErrorResult("Error: Employer add operation failed, Mernis validation failed");
					}
				else {
					return new ErrorResult("Error: Employer add operation failed, e-mail already used");
				}
			else {
				return new ErrorResult("Error: Employer add operation failed, national identity number already used");
			}
		else {
			return new ErrorResult("Error: Candidate add operation failed");
		}
	}

	private List<Candidate> getByNationalIdentityNumber(String nationalIdentityNumber) {
		return this.candidateDao.getByNationalIdentityNumber(nationalIdentityNumber);
	}

	private List<Candidate> getByEmail(String email) {
		return this.candidateDao.getByEmail(email);
	}

}
