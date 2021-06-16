package turanberlin.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import turanberlin.hrms.business.abstracts.SocialLinkService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.SocialLink;

@RestController
@RequestMapping(value="/api/socialLinks")
public class SocialLinksController {

	private SocialLinkService socialLinkService;

	@Autowired
	public SocialLinksController(SocialLinkService socialLinkService) {
		super();
		this.socialLinkService = socialLinkService;
	}
	
	@PostMapping(value="/add/socialLink")
	public Result add(@RequestBody SocialLink socialLink) {
		return this.socialLinkService.add(socialLink);

	}
	
}
