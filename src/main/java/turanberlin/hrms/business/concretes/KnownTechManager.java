package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.KnownTechService;
import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.core.utils.resultSystem.SuccessResult;
import turanberlin.hrms.dataAccess.abstracts.KnownTechDao;
import turanberlin.hrms.entities.concretes.KnownTech;

@Service
public class KnownTechManager implements KnownTechService{
	
	private KnownTechDao knownTechDao;

	@Autowired
	public KnownTechManager(KnownTechDao knownTechDao) {
		super();
		this.knownTechDao = knownTechDao;
	}

	@Override
	public Result add(KnownTech knownTech) {
		this.knownTechDao.save(knownTech);
		return new SuccessResult("Success: Known technology added");
	}

}
