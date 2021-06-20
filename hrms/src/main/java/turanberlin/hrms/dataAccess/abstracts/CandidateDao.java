package turanberlin.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	List<Candidate> getByNationalIdentityNumber(String nationalIdentityNumber);
	
	List<Candidate> getByEmail(String email);
	
	List<Candidate> OrderByCandidateCv_CandidateSchools_GraduationYearDesc();
	
	List<Candidate> OrderByCandidateCv_WorkExps_YearOfLeavingDesc();
	
	Candidate findById(int id);

}