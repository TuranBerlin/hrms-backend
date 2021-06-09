package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {

}
