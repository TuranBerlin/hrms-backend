package turanberlin.hrms.core.utils.externalServices.cloudinary.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cloudinary_configurations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CloudinaryConfiguration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cloud_name")
	private String cloudName;
	
	@Column(name="api_key")
	private String apiKey;
	
	@Column(name="api_secret")
	private String apiSecret;
	
}
