package turanberlin.hrms.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import turanberlin.hrms.core.utils.externalServices.cloudinary.dataAccess.abstracts.CloudinaryConfigurationDao;

@Configuration
public class AppConfiguration {

	@Autowired
	private CloudinaryConfigurationDao cloudinaryConfigurationDao;

	@Bean
	public Cloudinary cloudinaryService() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", cloudinaryConfigurationDao.findById(1).getCloudName(),
				"api_key", cloudinaryConfigurationDao.findById(1).getApiKey(), "api_secret",
				cloudinaryConfigurationDao.findById(1).getApiSecret()));
	}
}
