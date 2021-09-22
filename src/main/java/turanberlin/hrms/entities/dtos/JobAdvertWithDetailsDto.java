package turanberlin.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertWithDetailsDto {

	private int id;
	private int employerId;
	private String companyName;
	private String jobPosition;
	private int numberOfOpenPositions;
	private LocalDate releaseDate;
	private LocalDate deadline;
	private int minSalary;
	private int maxSalary;
	private String title;
	private String description;
	private String cityName;
	private String jobTime;
	
}
