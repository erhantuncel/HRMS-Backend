package springreact.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.entities.concretes.Photo;

public interface PhotoService {

	DataResult<List<Photo>> getAll();
	DataResult<Photo> save(Photo photo);
	DataResult<Photo> save(MultipartFile photoFile);
	Result delete(String publicId);
}
