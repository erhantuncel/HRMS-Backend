package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	boolean existsByIdentityNumber(String identityNumber);
}
