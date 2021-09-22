package turanberlin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.EmployerService;
import turanberlin.hrms.business.abstracts.UserInfoValidateService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.ErrorResult;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.EmployerDao;
import turanberlin.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserInfoValidateService userInfoValidateService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserInfoValidateService userInfoValidateService) {
		super();
		this.employerDao = employerDao;
		this.userInfoValidateService = userInfoValidateService;
	}

	@Override
	public DataResult<List<Employer>> getEmployers() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listed");
	}

	@Override
	public Result add(Employer employer) {
		String[] splittedEmail = employer.getEmail().split("@", 2);
		String[] splittedWebAddress = employer.getWebAddress().split("://", 2);
		if (userInfoValidateService.validate(employer))
		if (getByWebAddress(employer.getWebAddress()).isEmpty())
		if (getByEmail(employer.getEmail()).isEmpty())
		if (getByPhoneNumber(employer.getPhoneNumber()).isEmpty()) {
		if (employer.getPassword().equals(employer.getConfirmPassword())) {
			if (splittedEmail[1].equals(splittedWebAddress[1])) {
				this.employerDao.save(employer);
				return new SuccessResult("Success: Employer added");
			} else {
				return new ErrorResult("Error: Employer add operation failed, web address and e-mail are not compatible");
			}
		} else {
			return new ErrorResult("Error: Employer add operation failed, password and confirm password not same");
		}} else {
			return new ErrorResult("Error: Employer add operation failed, phone number already used");
		} else {
			return new ErrorResult("Error: Employer add operation failed, e-mail already used");
		} else {
			return new ErrorResult("Error: Employer add operation failed, web address already used");
		} else {
			return new ErrorResult("Error: Employer add operation failed");
		}
	}

	private List<Employer> getByEmail(String email) {
		return this.employerDao.getByEmail(email);
	}

	private List<Employer> getByWebAddress(String webAddress) {
		return this.employerDao.getByWebAddress(webAddress);
	}

	private List<Employer> getByPhoneNumber(String phoneNumber) {
		return this.employerDao.getByPhoneNumber(phoneNumber);
	}

}
