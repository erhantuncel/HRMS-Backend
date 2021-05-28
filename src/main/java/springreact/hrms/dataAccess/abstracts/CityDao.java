package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
