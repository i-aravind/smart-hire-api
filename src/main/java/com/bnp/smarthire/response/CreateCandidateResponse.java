package com.bnp.smarthire.response;

public class CreateCandidateResponse {

	private Long candidateId;

	private String candidateName;

	private String dob;

	private Float yearsofExperience;

	private String candidateQualification;

	private String email;

	private String password;

	private String errorMsg;

	private String role;
	
	private Boolean authenticated;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Float getYearsofExperience() {
		return yearsofExperience;
	}

	public void setYearsofExperience(Float yearsofExperience) {
		this.yearsofExperience = yearsofExperience;
	}

	public String getCandidateQualification() {
		return candidateQualification;
	}

	public void setCandidateQualification(String candidateQualification) {
		this.candidateQualification = candidateQualification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean isAuthenticated) {
		this.authenticated = isAuthenticated;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateCandidateResponse [candidateId=");
		builder.append(candidateId);
		builder.append(", candidateName=");
		builder.append(candidateName);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", yearsofExperience=");
		builder.append(yearsofExperience);
		builder.append(", candidateQualification=");
		builder.append(candidateQualification);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", errorMsg=");
		builder.append(errorMsg);
		builder.append(", role=");
		builder.append(role);
		builder.append(", isAuthenticated=");
		builder.append(authenticated);
		builder.append("]");
		return builder.toString();
	}
}
