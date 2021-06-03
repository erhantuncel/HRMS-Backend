package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.SocialMediaLink;

public interface SocialMediaLinkService {

	DataResult<SocialMediaLink> save(SocialMediaLink socialMediaLink);
	DataResult<List<SocialMediaLink>> findByCandidateId(Integer candidateId, boolean isActive);
}
