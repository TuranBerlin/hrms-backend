package turanberlin.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "work_experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_experience_id")
	private int id;
	
	@Column(name = "work_place_name")
	private String workPlaceName;
	
	@Column(name = "job_position")
	private String jobPosition;
	
	@Column(name = "year_of_employment")
	private String yearOfEmployment;
	
	@Column(name = "year_of_leaving")
	private String yearOfLeaving;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private CandidateCv candidateCv;
	
}
