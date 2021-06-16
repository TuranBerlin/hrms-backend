package turanberlin.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import turanberlin.hrms.entities.concretes.UserImage;

public interface UserImageDao extends JpaRepository<UserImage, Integer>{

	@Query("Select u from UserImage u where u.isImageAvailable = 'true'")
	List<UserImage> getAllByAvailability();
}
