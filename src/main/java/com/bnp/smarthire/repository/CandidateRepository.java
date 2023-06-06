package com.bnp.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnp.smarthire.entity.CandidateEntity;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity,Long>{

	@Query("SELECT c FROM CandidateEntity c WHERE c.candidateId = :user AND c.password = :password")
	public CandidateEntity validateCandidate(Long user, String password);
	
	@Query("SELECT c FROM CandidateEntity c WHERE c.email = :user AND c.password = :password")
	public CandidateEntity validateCandidate(String user, String password);
	
	@Query("SELECT c FROM CandidateEntity c WHERE c.email = :user")
	public CandidateEntity getCandidateByEmail(String user);
	
}
