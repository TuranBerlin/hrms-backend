package turanberlin.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import turanberlin.hrms.business.abstracts.UserService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.dataAccess.abstracts.UserDao;
import turanberlin.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Data listed");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public DataResult getById(int id) {
		return new SuccessDataResult<User>(this.userDao.findById(id));
	}

}
