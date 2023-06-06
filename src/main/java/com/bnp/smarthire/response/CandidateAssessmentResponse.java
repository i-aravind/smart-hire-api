package com.bnp.smarthire.response;

public class CandidateAssessmentResponse {

	private Long candidateId;

	private Long assessmentId;

	private String assessmentName;

	private String assignedDate;

	private String expiryDate;

	private String status;
	
	private String recruiterEmail;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecruiterEmail() {
		return recruiterEmail;
	}

	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CandidateAssessmentResponse [candidateId=");
		builder.append(candidateId);
		builder.append(", assessmentId=");
		builder.append(assessmentId);
		builder.append(", assessmentName=");
		builder.append(assessmentName);
		builder.append(", assignedDate=");
		builder.append(assignedDate);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", recruiterEmail=");
		builder.append(recruiterEmail);
		builder.append("]");
		return builder.toString();
	}

}
