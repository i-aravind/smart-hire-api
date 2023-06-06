package com.bnp.smarthire.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnp.smarthire.entity.CandidateAssessmentEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CandidateAssessmentRepository extends JpaRepository<CandidateAssessmentEntity, Long>{
	
	@Query("SELECT c FROM CandidateAssessmentEntity c WHERE c.candidateDbId = :candidateId")
	public Collection<CandidateAssessmentEntity> getAssessmentDetails(Long candidateId);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM CandidateAssessmentEntity c WHERE c.candidateDbId = :candidateId AND c.assessmentDbId=:assessmentId")
	public void deleteAssessmentDetails(Long candidateId, Long assessmentId);
	
	@Modifying
	@Transactional
	@Query("UPDATE CandidateAssessmentEntity c SET c.status = :status, c.score=:score WHERE c.candidateDbId = :candidateId AND c.assessmentDbId = :assessmentId")
	public void updateSubmission(Long candidateId, Long assessmentId, Long score, String status);
}
