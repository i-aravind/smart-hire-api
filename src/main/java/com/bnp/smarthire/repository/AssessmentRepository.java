package com.bnp.smarthire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnp.smarthire.entity.AssessmentEntity;

@Repository
public interface AssessmentRepository extends JpaRepository<AssessmentEntity, Long> {

	@Query("SELECT a.assessmentId FROM AssessmentEntity a WHERE a.assessmentName=:assessmentName")
	public Long getByName(String assessmentName);
}
