package turanberlin.hrms.business.abstracts;

import java.util.List;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.UserImage;

public interface UserImageService {
	
	public DataResult<List<UserImage>> getAll();
	
	public DataResult<List<UserImage>> getAllByAvailability();

}
