package turanberlin.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_adverts")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer","city","jobPosition"})
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "advert_id")
	private int id;

//	@Column(name = "employer_id")
//	private int employerId;
//
//	@Column(name = "city_id")
//	private int cityId;
	
	@Column(name = "minimum_salary")
	private int minSalary;
	
	@Column(name = "maximum_salary")
	private int maxSalary;
	
//	@Column(name = "position_id")
//	private int positionId;
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;
	
	@Column(name = "deadline")
	private LocalDate deadline;
	
	@Column(name = "release_date")
	private LocalDate releaseDate=LocalDate.now();
	
	@Column(name = "is_advert_active")
	private Boolean isAdvertActive;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "position_id")
	private JobPosition jobPosition;
	

}
