package springreact.hrms.business.abstracts;

import java.util.List;

import springreact.hrms.core.utilities.results.DataResult;
import springreact.hrms.entities.concretes.Preface;

public interface PrefaceService {

	DataResult<Preface> save(Preface preface);
	DataResult<List<Preface>> findByCandidateId(int candidateId, boolean isActive);
}
