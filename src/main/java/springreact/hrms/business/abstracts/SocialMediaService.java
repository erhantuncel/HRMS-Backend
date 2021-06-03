package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {

	DataResult<List<SocialMedia>> findAll();
	DataResult<SocialMedia> findById(int id);
}
