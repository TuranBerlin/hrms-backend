package turanberlin.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "university_faculty")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
public class Faculty{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="faculty_id")
	private int id;
	
	@Column(name="faculty_name")
	private String facultyName;
	
	@Column(name="type")
	private int facultyType;
	
	@Column(name="faculty_status")
	private int facultyStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "faculty")
	private List<CandidateSchool> candidateSchools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "faculty")
	private List<Department> departments;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;

}
