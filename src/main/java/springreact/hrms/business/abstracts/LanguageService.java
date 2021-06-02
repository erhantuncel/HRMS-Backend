package springreact.hrms.business.abstracts;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.Language;

public interface LanguageService {

	DataResult<Language> save(Language language);
}
