package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer> {

}
