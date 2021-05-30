package springreact.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.CityService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.dataAccess.abstracts.CityDao;
import springreact.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public City findById(Integer id) {
		return this.cityDao.findById(id).orElse(null);
		
	}

	@Override
	public DataResult<List<City>> getAll() {
		List<City> cities = this.cityDao.findAll();
		return new SuccessDataResult<List<City>>(cities, "Cities are listed.");
	}

}
