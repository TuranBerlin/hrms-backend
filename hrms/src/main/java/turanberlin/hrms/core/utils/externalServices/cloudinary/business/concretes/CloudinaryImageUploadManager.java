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
import turanberlin.hrms.dataAccess.abstracts.CandidateDao;
import turanberlin.hrms.dataAccess.abstracts.UserImageDao;
import turanberlin.hrms.entities.concretes.Candidate;
import turanberlin.hrms.entities.concretes.UserImage;

@Service
public class CloudinaryImageUploadManager implements CloudinaryImageUploadService{

	private UserImageDao userImageDao;
	private CandidateDao candidateDao;
	private Cloudinary cloudinary;
	
	@Autowired
	public CloudinaryImageUploadManager(UserImageDao userImageDao, CandidateDao candidateDao, Cloudinary cloudinary) {
		super();
		this.userImageDao = userImageDao;
		this.candidateDao = candidateDao;
		this.cloudinary = cloudinary;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public DataResult<Map> imageUpload(MultipartFile file, int candidateId) {
		try {
		Map uploadResult = (Map<String,?>)cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
		UserImage userImage = new UserImage();
		Candidate candidate = candidateDao.getById(candidateId);
		userImage.setCandidate(candidateDao.findById(candidateId));
		userImage.setIsImageAvailable(true);
		userImage.setImageUrl(uploadResult.get("url").toString());
		candidate.setUserImage(userImage);
		this.userImageDao.save(userImage);
		return new SuccessDataResult<Map>(uploadResult);
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
		return new ErrorDataResult<Map>();
		}
	
}
