package springreact.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springreact.hrms.business.abstracts.CityService;
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

}
