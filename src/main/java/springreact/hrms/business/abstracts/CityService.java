package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.City;

public interface CityService {
	
	City findById(Integer id);
	DataResult<List<City>> getAll();
}
