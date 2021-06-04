package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.Resume;

public interface ResumeService {

	DataResult<Resume> save(Resume resume);
	DataResult<List<Resume>> findByCandidateId(Integer candidateId, boolean isActive);
}
