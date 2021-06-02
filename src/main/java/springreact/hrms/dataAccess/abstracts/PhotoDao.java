package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

	Photo findByPublicId(String publicId);
}
