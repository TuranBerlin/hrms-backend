package turanberlin.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import turanberlin.hrms.business.abstracts.UserImageService;
import turanberlin.hrms.core.utils.externalServices.cloudinary.business.abstracts.CloudinaryImageUploadService;

@RestController
@RequestMapping(name="/api/userImages")
public class UserImagesController {

	private CloudinaryImageUploadService cloudinaryImageUploadService;
	private UserImageService userImageService;

	@Autowired
	public UserImagesController(CloudinaryImageUploadService cloudinaryImageUploadService,
			UserImageService userImageService) {
		super();
		this.cloudinaryImageUploadService = cloudinaryImageUploadService;
		this.userImageService = userImageService;
	}

	@PostMapping(name="/upload/image")
	public ResponseEntity<?> uploadImage(@RequestBody MultipartFile file,@RequestParam int userId) {
		return ResponseEntity.ok(this.cloudinaryImageUploadService.imageUpload(file, userId));
	}
	
	@GetMapping(name="/get/images")
	public ResponseEntity<?> getImages() {
		return ResponseEntity.ok(this.userImageService.getAll());
	}
	
//	@GetMapping(name="/get/images/byAvailability")
//	public ResponseEntity<?> getImagesByAvailability() {
//		return ResponseEntity.ok(this.userImageService.getAllByAvailability());
//	}
}
