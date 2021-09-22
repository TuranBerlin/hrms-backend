package turanberlin.hrms.entities.concretes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "known_technologies")
public class KnownTech {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "known_technology")
	@Lob
	private String knownTech;

	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	private CandidateCv candidateCv;

}
