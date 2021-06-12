package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.WorkLocation;

public interface WorkLocationDao extends JpaRepository<WorkLocation, Integer>{

}
