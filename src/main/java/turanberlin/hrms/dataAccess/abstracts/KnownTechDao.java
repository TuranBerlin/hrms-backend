package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.KnownTech;

public interface KnownTechDao extends JpaRepository<KnownTech, Integer>{

}
