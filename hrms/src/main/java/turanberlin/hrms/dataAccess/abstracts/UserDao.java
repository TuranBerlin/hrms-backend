package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

	User findById(int id);
}
