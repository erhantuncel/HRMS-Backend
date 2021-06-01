package springreact.hrms.core.utilities.adapters.imageservices;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.ErrorDataResult;
import springreact.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryServiceAdapter implements ImageService {
	
	Cloudinary cloudinary;

	@Autowired
	public CloudinaryServiceAdapter(Cloudinary cloudinary) {
		super();
		this.cloudinary = cloudinary;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> save(MultipartFile file) {
		if (this.cloudinary.config.cloudName.isBlank() 
				|| this.cloudinary.config.apiKey.isBlank() 
				|| this.cloudinary.config.apiSecret.isBlank()) {
			return new ErrorDataResult<Map>("Check Cloudinary api configuration parameters in application.properties file.");
		}
		try {
			Map result = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(result, "Image is uploaded successfully.");
		} catch (IOException e) {
			return new ErrorDataResult<Map>("Image is not uploaded.");
		}
	}

}
