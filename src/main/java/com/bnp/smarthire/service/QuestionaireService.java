package com.bnp.smarthire.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.bnp.smarthire.request.SubmissionRequest;
import com.bnp.smarthire.response.QuestionsResponse;

@Service
public interface QuestionaireService {

	public Collection<QuestionsResponse> getQuestionaires(Long assessmentId);
	
	public Long checkSubmission(SubmissionRequest submissionRequest);
}
