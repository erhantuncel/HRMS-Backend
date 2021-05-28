package springreact.hrms.business.abstracts;

import springreact.hrms.entities.concretes.City;

public interface CityService {
	
	City findById(Integer id);
}
