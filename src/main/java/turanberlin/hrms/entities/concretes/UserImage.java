package turanberlin.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_images")
public class UserImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="upload_date")
	private LocalDate uploadDate = LocalDate.now();
	
	@Column(name="image_available")
	private Boolean isImageAvailable;

	@JsonBackReference
	@JoinColumn(name = "user_id")
	@OneToOne()
	private Candidate candidate;

}
