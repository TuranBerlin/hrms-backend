package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import turanberlin.hrms.entities.concretes.University;

public interface UniversityDao extends JpaRepository<University, Integer> {
}
