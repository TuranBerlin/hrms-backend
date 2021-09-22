package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import turanberlin.hrms.entities.concretes.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer> {
}
