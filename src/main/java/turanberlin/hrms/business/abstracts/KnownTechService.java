package turanberlin.hrms.business.abstracts;

import turanberlin.hrms.core.utils.resultSystem.Result;
import turanberlin.hrms.entities.concretes.KnownTech;

public interface KnownTechService {
	Result add(KnownTech knownTech) ;
}
