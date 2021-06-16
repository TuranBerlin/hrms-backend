package turanberlin.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_cv")
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateSchools","knownTechs","knownLanguages","socialLinks","workExps","candidates"})
public class CandidateCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int id;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateSchool> candidateSchools;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCv")
	private List<KnownTech> knownTechs;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCv")
	private List<Language> knownLanguages;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCv")
	private List<SocialLink> socialLinks;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "candidateCv")
	private List<WorkExp> workExps;

	@JsonBackReference
	@OneToOne()
	private Candidate candidate;
	
}
