package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.CandidateSchool;

public interface CandidateSchoolDao extends JpaRepository<CandidateSchool, Integer>{

}
