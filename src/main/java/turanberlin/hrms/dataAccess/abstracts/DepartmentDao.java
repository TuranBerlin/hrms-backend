package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import turanberlin.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
