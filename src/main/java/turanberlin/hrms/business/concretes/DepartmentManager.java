package turanberlin.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turanberlin.hrms.business.abstracts.DepartmentService;
import turanberlin.hrms.core.utils.resultSystem.DataResult;
import turanberlin.hrms.core.utils.resultSystem.SuccessDataResult;
import turanberlin.hrms.dataAccess.abstracts.DepartmentDao;
import turanberlin.hrms.entities.concretes.Department;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<List<Department>>(this.departmentDao.findAll(), "Data listed");
    }
}
