package springreact.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import springreact.hrms.business.abstracts.PhotoService;
import springreact.hrms.core.utilities.adapters.imageservices.ImageService;
import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.core.utilities.results.ErrorDataResult;
import springreact.hrms.core.utilities.results.ErrorResult;
import springreact.hrms.core.utilities.results.Result;
import springreact.hrms.core.utilities.results.SuccessDataResult;
import springreact.hrms.core.utilities.results.SuccessResult;
import springreact.hrms.dataAccess.abstracts.PhotoDao;
import springreact.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService {

	PhotoDao photoDao;
	ImageService imageService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, ImageService imageService) {
		super();
		this.photoDao = photoDao;
		this.imageService = imageService;
	}

	@Override
	public DataResult<List<Photo>> getAll() {
		List<Photo> photos = this.photoDao.findAll();
		return new SuccessDataResult<List<Photo>>(photos, "Photos are listed.");
	}
	
	@Override
	public DataResult<Photo> save(Photo photo) {
		Photo savedPhoto = this.photoDao.save(photo);
		return new SuccessDataResult<Photo>(savedPhoto, "Photo is saved to db.");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Photo> save(MultipartFile photoFile) {
		DataResult<?> uploadResult = this.imageService.save(photoFile);
		if(uploadResult.isSuccess()) {
			Map uploadResultData = (Map)uploadResult.getData();
			Photo photoToSave = new Photo(0, 
					(String)uploadResultData.get("public_id"), 
					(String)uploadResultData.get("url"), null);
			return this.save(photoToSave);
		}
		return new ErrorDataResult<Photo>("Photo is not saved to db.");
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Result delete(String publicId) {
		Photo photoFromDb = this.photoDao.findByPublicId(publicId);
		if(photoFromDb == null) {
			return new ErrorResult("There is not photo with this public id in database."); 
		}
		DataResult<?> deleteResult = this.imageService.delete(publicId);
		if(deleteResult.isSuccess()) {
			Map deleteResultInfo = (Map) deleteResult.getData();
			if(deleteResultInfo.get("result").equals("ok")) {
				photoFromDb.setActive(false);
				this.photoDao.save(photoFromDb);
				return new SuccessResult("Image is removed.");
			}
		}
		return new ErrorResult("Image is not removed.");
	}

}
