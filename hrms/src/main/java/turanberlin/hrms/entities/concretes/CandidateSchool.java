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
@Table(name = "schools")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSchool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_school_id")
	private int id;
	
	@Column(name = "school_entry_year")
	private String schoolEntryYear;
	
	@Column(name = "graduation_year")
	private String graduationYear;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	
	@ManyToOne()
	@JoinColumn(name="department_id")
	private Department department;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private CandidateCv candidateCv;
	
}
