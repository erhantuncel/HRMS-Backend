package springreact.hrms.business.concretes;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.LanguageService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.LanguageDao;
import springreact.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<Language> save(Language language) {
		language.setActive(true);
		language.setCreatedDate(new Date());
		Language savedLanguage = this.languageDao.save(language);
		return new SuccessDataResult<Language>(savedLanguage, "Language is saved to db");
	}

}
