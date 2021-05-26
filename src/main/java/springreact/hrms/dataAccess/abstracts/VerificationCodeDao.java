package springreact.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import springreact.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer>{
	VerificationCode findByUserIdAndCode(Integer userId, String code);
}
