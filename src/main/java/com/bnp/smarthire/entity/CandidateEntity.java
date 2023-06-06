package com.bnp.smarthire.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CANDIDATE")
public class CandidateEntity {

	@Column(name = "CANDIDATE_DB_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateId;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "CANDIDATE_NAME")
	private String candidateName;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "YEARS_OF_EXPERIENCE")
	private Float yearsofExperience;

	@Column(name = "CANDIDATE_QUALIFICATION")
	private String candidateQualification;

	@Column(name = "ROLE")
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
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
		builder.append("CandidateEntity [candidateId=");
		builder.append(candidateId);
		builder.append(", email=");
		builder.append(email);
		builder.append(", password=");
		builder.append(password);
		builder.append(", candidateName=");
		builder.append(candidateName);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", yearsofExperience=");
		builder.append(yearsofExperience);
		builder.append(", candidateQualification=");
		builder.append(candidateQualification);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

}
