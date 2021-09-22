package turanberlin.hrms.core.utils.externalServices.cloudinary.business.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import turanberlin.hrms.core.utils.resultSystem.DataResult;

public interface CloudinaryImageUploadService {

	@SuppressWarnings("rawtypes")
	DataResult<Map> imageUpload(MultipartFile file, int userId);
}
