package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.SocialMediaService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.SocialMediaDao;
import springreact.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public DataResult<List<SocialMedia>> findAll() {
		List<SocialMedia> socialMedias = this.socialMediaDao.findAll();
		return new SuccessDataResult<List<SocialMedia>>(socialMedias, "Social medias are listed.");
	}

	@Override
	public DataResult<SocialMedia> findById(int id) {
		SocialMedia socialMedia = this.socialMediaDao.findById(id).orElse(null);
		return new SuccessDataResult<SocialMedia>(socialMedia);
	}

}
