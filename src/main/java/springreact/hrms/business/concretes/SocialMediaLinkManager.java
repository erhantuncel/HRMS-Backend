package springreact.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.SocialMediaLinkService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.SocialMediaLinkDao;
import springreact.hrms.entities.concretes.SocialMediaLink;

@Service
public class SocialMediaLinkManager implements SocialMediaLinkService {

	private SocialMediaLinkDao socialMediaLinkDao;
	
	@Autowired
	public SocialMediaLinkManager(SocialMediaLinkDao socialMediaLinkDao) {
		super();
		this.socialMediaLinkDao = socialMediaLinkDao;
	}

	@Override
	public DataResult<SocialMediaLink> save(SocialMediaLink socialMediaLink) {
		socialMediaLink.setActive(true);
		socialMediaLink.setCreatedDate(new Date());
		SocialMediaLink savedSocialMediaLink = this.socialMediaLinkDao.save(socialMediaLink);
		return new SuccessDataResult<SocialMediaLink>(savedSocialMediaLink, 
				"Social media link is saved to db.");
	}

	@Override
	public DataResult<List<SocialMediaLink>> findByResumeId(Integer resumeId, boolean isActive) {
		List<SocialMediaLink> socialMediaLinks = this.socialMediaLinkDao.findByResumeIdAndIsActive(resumeId, isActive);
		return new SuccessDataResult<List<SocialMediaLink>>(socialMediaLinks, "Social media links are listed.");
	}

}
