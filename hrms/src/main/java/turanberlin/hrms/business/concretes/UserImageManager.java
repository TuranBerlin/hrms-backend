package turanberlin.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.UserImageService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.dataAccess.abstracts.UserImageDao;
import turanberlin.hrms.entities.concretes.UserImage;

@Service
public class UserImageManager implements UserImageService {
	
	private UserImageDao userImageDao;


	public UserImageManager(UserImageDao userImageDao) {
		super();
		this.userImageDao = userImageDao;
	}
	
	@Override
	public DataResult<List<UserImage>> getAll() {
		return new SuccessDataResult<List<UserImage>>(this.userImageDao.findAll(),"Data listed");
	}

	@Override
	public DataResult<List<UserImage>> getAllByAvailability() {
		return new SuccessDataResult<List<UserImage>>(this.userImageDao.getAllByAvailability(),"Data listed");
	}

}
