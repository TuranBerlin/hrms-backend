package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import turanberlin.hrms.entities.concretes.JobTime;

public interface JobTimeDao extends JpaRepository<JobTime, Integer> {

}
