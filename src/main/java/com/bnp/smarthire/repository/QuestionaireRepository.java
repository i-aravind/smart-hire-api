package com.bnp.smarthire.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bnp.smarthire.entity.QuestionaireEntity;

@Repository
public interface QuestionaireRepository extends JpaRepository<QuestionaireEntity, Long>{

	@Query("SELECT q FROM QuestionaireEntity q WHERE q.assessmentDbid = :assessmentDbId ORDER BY q.questionId")
	public Collection<QuestionaireEntity> getQuestionairesbyAssessmentId(Long assessmentDbId);
	
}
