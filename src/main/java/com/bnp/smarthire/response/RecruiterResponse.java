package com.bnp.smarthire.response;

public class RecruiterResponse {

	private Long recruiterId;

	private String recruiterName;

	private String recruiterEmail;

	private String password;

	private Boolean authenticated;

	private String errorMsg;

	public Long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getRecruiterEmail() {
		return recruiterEmail;
	}

	public void setRecruiterEmail(String recruiterEmail) {
		this.recruiterEmail = recruiterEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecruiterResponse [recruiterId=");
		builder.append(recruiterId);
		builder.append(", recruiterName=");
		builder.append(recruiterName);
		builder.append(", recruiterEmail=");
		builder.append(recruiterEmail);
		builder.append(", password=");
		builder.append(password);
		builder.append(", authenticated=");
		builder.append(authenticated);
		builder.append(", errorMsg=");
		builder.append(errorMsg);
		builder.append("]");
		return builder.toString();
	}

}
