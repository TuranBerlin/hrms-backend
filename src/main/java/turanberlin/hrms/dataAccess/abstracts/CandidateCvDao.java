package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.CandidateCv;

public interface CandidateCvDao extends JpaRepository<CandidateCv, Integer>{

}
