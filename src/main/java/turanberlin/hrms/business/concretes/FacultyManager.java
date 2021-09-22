package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turanberlin.hrms.business.abstracts.FacultyService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.dataAccess.abstracts.FacultyDao;
import turanberlin.hrms.entities.concretes.Faculty;

import java.util.List;

@Service
public class FacultyManager implements FacultyService {

    private FacultyDao facultyDao;

    @Autowired
    public FacultyManager(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    @Override
    public DataResult<List<Faculty>> getAll() {
        return new SuccessDataResult<List<Faculty>>(this.facultyDao.findAll(), "Data listed");
    }
}
