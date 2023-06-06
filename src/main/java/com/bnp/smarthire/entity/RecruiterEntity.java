package com.bnp.smarthire.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RECRUITER")
public class RecruiterEntity {

	@Id
	@Column(name = "RECRUITER_DB_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruiterDbId;

	@Column(name = "RECRUITER_NAME")
	private String recruiterName;

	@Column(name = "RECRUITER_EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	public Long getRecruiterDbId() {
		return recruiterDbId;
	}

	public void setRecruiterDbId(Long recruiterId) {
		this.recruiterDbId = recruiterId;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RecruiterEntity [recruiterId=");
		builder.append(recruiterDbId);
		builder.append(", recruiterName=");
		builder.append(recruiterName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}
