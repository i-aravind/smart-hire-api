package com.bnp.smarthire.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bnp.smarthire.entity.QuestionaireEntity;
import com.bnp.smarthire.repository.CandidateAssessmentRepository;
import com.bnp.smarthire.repository.QuestionaireRepository;
import com.bnp.smarthire.request.SubmissionRequest;
import com.bnp.smarthire.response.QuestionsResponse;
import com.bnp.smarthire.service.QuestionaireService;

@Component
public class QuestionaireServiceImpl implements QuestionaireService{

	private QuestionaireRepository questionaireRepository;
	
	private CandidateAssessmentRepository candidateAssessmentRepository;
	
	@Autowired
	public QuestionaireServiceImpl(QuestionaireRepository questionaireRepository,CandidateAssessmentRepository candidateAssessmentRepository){
		this.questionaireRepository = questionaireRepository;
		this.candidateAssessmentRepository = candidateAssessmentRepository;
	}
	@Override
	public Collection<QuestionsResponse> getQuestionaires(Long assessmentId) {
		Collection<QuestionsResponse> questionsResponses = new ArrayList<QuestionsResponse>();
		
		Collection<QuestionaireEntity> questionaireEntitys= questionaireRepository.getQuestionairesbyAssessmentId(assessmentId);
		for(QuestionaireEntity questionaireEntity: questionaireEntitys) {
			QuestionsResponse questionsResponse = new QuestionsResponse();
			questionsResponse.setAssessmentDbid(questionaireEntity.getAssessmentDbid());
			questionsResponse.setQuestionaireDbId(questionaireEntity.getQuestionaireDbId());
			questionsResponse.setQuestionId(questionaireEntity.getQuestionId());
			questionsResponse.setQuestionDescription(questionaireEntity.getQuestionDescription());
			questionsResponse.setOption1(questionaireEntity.getOption1());
			questionsResponse.setOption2(questionaireEntity.getOption2());
			questionsResponse.setOption3(questionaireEntity.getOption3());
			questionsResponse.setOption4(questionaireEntity.getOption4());
			questionsResponse.setAnswer(questionaireEntity.getAnswer());
			questionsResponses.add(questionsResponse);
		}
		return questionsResponses;
	}
	
	@Override
	public Long checkSubmission(SubmissionRequest submissionRequest) {
		Long score = 0L;
		for(QuestionsResponse question : submissionRequest.getQuestions()) {
			if(question.getAnswer().equals(question.getSelected())){
				score++;
			}
		}
		candidateAssessmentRepository.updateSubmission(Long.parseLong(submissionRequest.getCandidateId().replaceAll("\"", "")), Long.parseLong(submissionRequest.getAssessmentId().replaceAll("\"", "")),score, "COMPLETED");
		System.out.println(score);
		return score;
	}

}
