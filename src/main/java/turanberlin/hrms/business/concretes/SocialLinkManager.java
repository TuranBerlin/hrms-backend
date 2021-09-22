package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.SocialLinkService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.SocialLinkDao;
import turanberlin.hrms.entities.concretes.SocialLink;

@Service
public class SocialLinkManager implements SocialLinkService{

	private SocialLinkDao socialLinkDao;

	@Autowired
	public SocialLinkManager(SocialLinkDao socialLinkDao) {
		super();
		this.socialLinkDao = socialLinkDao;
	}

	@Override
	public Result add(SocialLink socialLink) {
		this.socialLinkDao.save(socialLink);
		return new SuccessResult("Success: Social link added");
	}
}
