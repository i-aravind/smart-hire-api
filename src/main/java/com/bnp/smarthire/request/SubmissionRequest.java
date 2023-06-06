package com.bnp.smarthire.request;

import java.util.Collection;

import com.bnp.smarthire.response.QuestionsResponse;

public class SubmissionRequest {

	private String candidateId;

	private String assessmentId;

	private Collection<QuestionsResponse> questions;

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Collection<QuestionsResponse> getQuestions() {
		return questions;
	}

	public void setQuestions(Collection<QuestionsResponse> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SubmissionRequest [candidateId=");
		builder.append(candidateId);
		builder.append(", assessmentId=");
		builder.append(assessmentId);
		builder.append(", questions=");
		builder.append(questions);
		builder.append("]");
		return builder.toString();
	}

}
