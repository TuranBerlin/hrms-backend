package turanberlin.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {
	
	private int id;
	
	@Column(name = "email")
	@Email
	@NotBlank
	@NotNull
	private String email;
	
	@Column(name = "password")
	@NotBlank
	@NotNull
	private String password;
	
	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;
	
	@Column(name = "identity_number")
	@NotBlank
	@NotNull
	private String nationalIdentityNumber;
	
	@Column(name = "year_of_birth")
	private LocalDate yearOfBirth;
	
	@Column(name = "email_confirmed")
	private Boolean isEmailConfirmed;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "candidate")
	private CandidateCv candidateCv;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "candidate")
	private UserImage userImage;

}