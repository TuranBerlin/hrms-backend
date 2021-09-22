package turanberlin.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import turanberlin.hrms.entities.concretes.SocialLink;

public interface SocialLinkDao extends JpaRepository<SocialLink, Integer>{

}
