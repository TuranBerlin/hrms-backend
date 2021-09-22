package turanberlin.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

	List<Employer> getByEmail(String email);
	
	List<Employer> getByWebAddress(String webAddress);
	
	List<Employer> getByPhoneNumber(String phoneNumber);
}
