package turanberlin.hrms.business.abstracts;

import java.util.List;

import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	
	DataResult<User> getById(int id);

}
