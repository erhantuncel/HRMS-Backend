package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer>{

}
