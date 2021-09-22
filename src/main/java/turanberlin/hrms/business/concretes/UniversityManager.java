package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turanberlin.hrms.business.abstracts.UniversityService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.dataAccess.abstracts.UniversityDao;
import turanberlin.hrms.entities.concretes.University;

import java.util.List;

@Service
public class UniversityManager implements UniversityService {

    private UniversityDao universityDao;

    @Autowired
    public UniversityManager(UniversityDao universityDao) {
        this.universityDao = universityDao;
    }

    @Override
    public DataResult<List<University>> getAll() {
        return new SuccessDataResult<List<University>>(this.universityDao.findAll(), "Data listed");
    }
}
