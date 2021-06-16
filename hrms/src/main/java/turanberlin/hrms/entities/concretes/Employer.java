package turanberlin.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvert"})
public class Employer extends User {
	
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

	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;
	
	@Column(name = "web_address")
	@NotBlank
	@NotNull
	private String webAddress;
	
	@Column(name = "phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	@Column(name = "email_confirmed")
	private Boolean isEmailConfirmed;
	
	@Column(name = "employee_confirmed")
	private Boolean isEmployeeConfirmed;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdvert;
	
}
