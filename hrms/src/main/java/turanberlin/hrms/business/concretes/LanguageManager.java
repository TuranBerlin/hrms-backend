package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.LanguageService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.LanguageDao;
import turanberlin.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {
		this.languageDao.save(language);
		return new SuccessResult("Success: Language added");
	}

}
