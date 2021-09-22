package turanberlin.hrms.core.utils.externalServices.cloudinary.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.core.utils.externalServices.cloudinary.entities.concretes.CloudinaryConfiguration;

public interface CloudinaryConfigurationDao extends JpaRepository<CloudinaryConfiguration, Integer>{

	CloudinaryConfiguration findById(int id);
}
