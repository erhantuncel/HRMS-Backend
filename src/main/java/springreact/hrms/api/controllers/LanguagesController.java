package springreact.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springreact.hrms.business.abstracts.LanguageService;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.Language;

@RestController
@RequestMapping(path = "/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping(path = "/add")
	public Result saveLanguage(@RequestBody @Valid Language language) {
		return this.languageService.save(language);
	}

}
