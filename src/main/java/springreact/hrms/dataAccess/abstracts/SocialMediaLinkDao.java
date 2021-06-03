package springreact.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.SocialMediaLink;

public interface SocialMediaLinkDao extends JpaRepository<SocialMediaLink, Integer>{

	List<SocialMediaLink> findByCandidateIdAndIsActive(Integer candidateId, boolean isActive);
}
