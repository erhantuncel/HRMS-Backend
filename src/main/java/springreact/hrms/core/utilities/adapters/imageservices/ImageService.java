package springreact.hrms.core.utilities.adapters.imageservices;

import org.springframework.web.multipart.MultipartFile;

import springreact.hrms.core.utilities.results.DataResult;

public interface ImageService {

	DataResult<?> save(MultipartFile file);
	DataResult<?> delete(String publicId);
}
