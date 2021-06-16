package turanberlin.hrms.core.utils.externalServices.cloudinary.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import turanberlin.hrms.core.utils.externalServices.cloudinary.business.abstracts.CloudinaryImageUploadService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.ErrorDataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.dataAccess.abstracts.UserDao;
import turanberlin.hrms.dataAccess.abstracts.UserImageDao;
import turanberlin.hrms.entities.concretes.User;
import turanberlin.hrms.entities.concretes.UserImage;

@Service
public class CloudinaryImageUploadManager implements CloudinaryImageUploadService{

	private UserImageDao userImageDao;
	private UserDao userDao;
	private Cloudinary cloudinary;
	
	 @Autowired
	public CloudinaryImageUploadManager(UserImageDao userImageDao, UserDao userDao, Cloudinary cloudinary) {
		super();
		this.userImageDao = userImageDao;
		this.userDao = userDao;
		this.cloudinary = cloudinary;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public DataResult<Map> imageUpload(MultipartFile file, int userId) {
		try {
		Map uploadResult = (Map<String,?>)cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		UserImage userImage = new UserImage();
		User user = userDao.getById(userId);
		userImage.setUser(userDao.getById(userId));
		userImage.setIsImageAvailable(true);
		user.setUserImage(userImage);
		userImageDao.save(userImage);
		return new SuccessDataResult<Map>(uploadResult);
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
		return new ErrorDataResult<Map>();
		}
	
}
