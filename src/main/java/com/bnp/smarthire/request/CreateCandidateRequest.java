package com.bnp.smarthire.request;

public class CreateCandidateRequest {

	private Long candidateId;

	private String candidateName;

	private String dob;

	private Float yearsofExperience;

	private String candidateQualification;

	private String email;

	private String password;

	private String role;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateCandidateRequest [candidateId=");
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
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

}
