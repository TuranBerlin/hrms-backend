package turanberlin.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
	
	@Column(name = "birth_of_year")
	private int birthOfYear;
	
	@Column(name = "email_confirmed")
	private boolean emailConfirmed;
	

}