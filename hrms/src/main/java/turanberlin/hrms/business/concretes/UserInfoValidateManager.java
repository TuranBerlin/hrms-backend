package turanberlin.hrms.business.concretes;

import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.UserInfoValidateService;
import turanberlin.hrms.core.utils.ValidationRules;
import turanberlin.hrms.entities.concretes.Candidate;
import turanberlin.hrms.entities.concretes.Employee;
import turanberlin.hrms.entities.concretes.Employer;

@Service
public class UserInfoValidateManager implements UserInfoValidateService{	
	
	@Override
	public boolean validate(Candidate candidate) {
		boolean result = ValidationRules.run(
				isPasswordLengthValid(candidate.getPassword()), isFirstNameLengthValid(candidate.getFirstName()), isNationalIdentityNumberLengthValid(candidate.getNationalIdentityNumber()),
				isLastNameLengthValid(candidate.getLastName()), isAllFieldsFilledCandidate(candidate.getFirstName(),
				candidate.getLastName(), candidate.getEmail(), candidate.getPassword(), candidate.getNationalIdentityNumber()));
		return result;
	}
	
	@Override
	public boolean validate(Employer employer) {
		boolean result =  ValidationRules.run(
				isPasswordLengthValid(employer.getPassword()), isFirstNameLengthValid(employer.getCompanyName()),
				isWebAddressLengthValid(employer.getWebAddress()),
				isPhoneNumberLengthValid(employer.getPhoneNumber()),
				isAllFieldsFilledEmployer(employer.getCompanyName(), employer.getWebAddress(), employer.getPhoneNumber(),employer.getEmail(), employer.getPassword()));

		return result;
	}
	
	@Override
	public boolean validate(Employee employee) {
		boolean result =  ValidationRules.run(
				isPasswordLengthValid(employee.getPassword()), isFirstNameLengthValid(employee.getFirstName()),
				isLastNameLengthValid(employee.getLastName()),
				isAllFieldsFilledEmployee(employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getPassword()));

		return result;
	}
	
	
	private boolean isNationalIdentityNumberLengthValid(String nationalIdentityNumber) {
		return nationalIdentityNumber.length() == 11;
	}
	
	
	private boolean isPasswordLengthValid(String password) {
		return password.length() >= 6;
	}
	
	
	private boolean isWebAddressLengthValid(String webAddress) {
		return webAddress.length() >= 4;
	}
	
	
	private boolean isPhoneNumberLengthValid(String phoneNumber) {
		return phoneNumber.length() >= 7;
	}

	
	private boolean isFirstNameLengthValid(String firstName) {
		return firstName.length() > 2;
	}

	
	private boolean isLastNameLengthValid(String lastName) {
		return lastName.length() >= 2;
	}
	

	private boolean isAllFieldsFilledCandidate(String firstName, String lastName, String email, String password, String nationalIdentityNumber) {
		if (firstName.length() <= 0 || lastName.length() <= 0 || email.length() <= 0 || password.length() <= 0 || nationalIdentityNumber.length() <= 0) {
			return false;
		}
		return true;
	}
	
	private boolean isAllFieldsFilledEmployee(String firstName, String lastName, String email, String password) {
		if (firstName.length() <= 0 || lastName.length() <= 0 || email.length() <= 0 || password.length() <= 0) {
			return false;
		}
		return true;
	}
	
	private boolean isAllFieldsFilledEmployer(String companyName, String webAddress , String phoneNumber, String email, String password) {
		if ( email.length() <= 0 || password.length() <= 0 || companyName.length() <= 0 || phoneNumber.length() <= 0 || webAddress.length() <= 0) {
			return false;
		}
		return true;
	}
	
	

	
}
