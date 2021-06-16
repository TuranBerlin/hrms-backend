package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.WorkExp;

public interface WorkExpDao extends JpaRepository<WorkExp, Integer>{

}
