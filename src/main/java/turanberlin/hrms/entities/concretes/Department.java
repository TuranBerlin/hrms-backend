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
@Table(name = "university_department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
public class Department{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private int id;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_status")
	private int departmentStatus;
	
	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<CandidateSchool> candidateSchools;
	
	@ManyToOne()
	@JoinColumn(name="university_id")
	private University university;
	
	@ManyToOne()
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
}
