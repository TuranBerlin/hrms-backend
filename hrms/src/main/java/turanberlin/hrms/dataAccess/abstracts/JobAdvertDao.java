package turanberlin.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import turanberlin.hrms.entities.concretes.JobAdvert;
import turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	@Query(value = "Select new turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto(ja.id, e.id, e.companyName, jp.positionName, ja.numberOfOpenPositions, ja.releaseDate, ja.deadline) From  Employer e, JobPosition jp Inner Join jp.jobAdvert ja where e.id=:employerId and ja.isAdvertActive='true'")
	List<JobAdvertWithDetailsDto> getByEmployerId(@Param("employerId") int employerId);
	
	@Query("Select new turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto(ja.id, e.id, e.companyName, jp.positionName, ja.numberOfOpenPositions, ja.releaseDate, ja.deadline) From  Employer e, JobPosition jp Inner Join jp.jobAdvert ja where ja.isAdvertActive = 'true' ")
	List<JobAdvertWithDetailsDto> getJobAdvertWithDetails();
	
	@Query("Select new turanberlin.hrms.entities.dtos.JobAdvertWithDetailsDto(ja.id, e.id, e.companyName, jp.positionName, ja.numberOfOpenPositions, ja.releaseDate, ja.deadline) From  Employer e, JobPosition jp Inner Join jp.jobAdvert ja where ja.isAdvertActive = 'true' order by ja.deadline")
	List<JobAdvertWithDetailsDto> getJobAdvertWithDetailsByDateOrder();
}
