package turanberlin.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import turanberlin.hrms.entities.concretes.JobAdvert;
import turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	@Query(value = "Select new turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto (ja.id, e.id, e.companyName, jp.positionName, ja.numberOfOpenPositions, ja.releaseDate, ja.deadline, ja.minSalary, ja.maxSalary, ja.title, ja.description, c.cityName, jt.jobTimeName) From  JobAdvert ja LEFT JOIN ja.jobPosition jp LEFT JOIN ja.city c LEFT JOIN ja.employer e LEFT JOIN ja.jobTime jt where e.id=:employerId and ja.isAdvertActive='true'")
	List<JobAdvertWithDetailsDto> getByEmployerId(@Param("employerId") int employerId);
	
	@Query("Select new turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto (ja.id, e.id, e.companyName, jp.positionName, ja.numberOfOpenPositions, ja.releaseDate, ja.deadline, ja.minSalary, ja.maxSalary, ja.title, ja.description, c.cityName, jt.jobTimeName) From  JobAdvert ja LEFT JOIN ja.jobPosition jp LEFT JOIN ja.city c LEFT JOIN ja.employer e LEFT JOIN ja.jobTime jt where ja.isAdvertActive = 'true' ")
	List<JobAdvertWithDetailsDto> getJobAdvertWithDetails();
	
	@Query("Select new turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto (ja.id, e.id, e.companyName, jp.positionName, ja.numberOfOpenPositions, ja.releaseDate, ja.deadline, ja.minSalary, ja.maxSalary, ja.title, ja.description, c.cityName, jt.jobTimeName) From  JobAdvert ja LEFT JOIN ja.jobPosition jp LEFT JOIN ja.city c LEFT JOIN ja.employer e LEFT JOIN ja.jobTime jt  where ja.isAdvertActive = 'true' ")
	List<JobAdvertWithDetailsDto> getJobAdvertWithDetails(Pageable pageable);
	
	@Query("Select new turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto (ja.id, e.id, e.companyName, jp.positionName, ja.numberOfOpenPositions, ja.releaseDate, ja.deadline, ja.minSalary, ja.maxSalary, ja.title, ja.description, c.cityName, jt.jobTimeName) From  JobAdvert ja LEFT JOIN ja.jobPosition jp LEFT JOIN ja.city c LEFT JOIN ja.employer e LEFT JOIN ja.jobTime jt  where ja.isAdvertActive = 'true' order by ja.deadline")
	List<JobAdvertWithDetailsDto> getJobAdvertWithDetailsByDateOrder();

	@Query("Select new turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto (ja.id, e.id, e.companyName, jp.positionName, ja.numberOfOpenPositions, ja.releaseDate, ja.deadline, ja.minSalary, ja.maxSalary, ja.title, ja.description, c.cityName, jt.jobTimeName) From  JobAdvert ja LEFT JOIN ja.jobPosition jp LEFT JOIN ja.city c LEFT JOIN ja.employer e LEFT JOIN ja.jobTime jt where ja.isAdvertActive = 'false' ")
	List<JobAdvertWithDetailsDto> getJobAdvertWithDetailsOnlyUnverifieds();
	
	JobAdvert findById(int jobAdvertId);
	
}
