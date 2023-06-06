package com.bnp.smarthire.response;

public class CandidateViewResponse implements Cloneable {

	private String candidateId;

	private String candidateName;

	private String candidateEmail;

	private String candidateRole;

	private String candidateExperince;

	private String candidateQualification;

	private String assessmentStatus;

	private String candidateStatus;

	private String score;

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public String getCandidateRole() {
		return candidateRole;
	}

	public void setCandidateRole(String candidateRole) {
		this.candidateRole = candidateRole;
	}

	public String getCandidateExperince() {
		return candidateExperince;
	}

	public void setCandidateExperince(String candidateExperince) {
		this.candidateExperince = candidateExperince;
	}

	public String getCandidateQualification() {
		return candidateQualification;
	}

	public void setCandidateQualification(String candidateQualification) {
		this.candidateQualification = candidateQualification;
	}

	public String getAssessmentStatus() {
		return assessmentStatus;
	}

	public void setAssessmentStatus(String assessmentStatus) {
		this.assessmentStatus = assessmentStatus;
	}

	public String getCandidateStatus() {
		return candidateStatus;
	}

	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CandidateViewResponse [candidateId=");
		builder.append(candidateId);
		builder.append(", candidateName=");
		builder.append(candidateName);
		builder.append(", candidateEmail=");
		builder.append(candidateEmail);
		builder.append(", candidateRole=");
		builder.append(candidateRole);
		builder.append(", candidateExperince=");
		builder.append(candidateExperince);
		builder.append(", candidateQualification=");
		builder.append(candidateQualification);
		builder.append(", assessmentStatus=");
		builder.append(assessmentStatus);
		builder.append(", candidateStatus=");
		builder.append(candidateStatus);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}

}
