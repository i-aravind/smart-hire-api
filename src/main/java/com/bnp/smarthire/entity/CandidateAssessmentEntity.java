package com.bnp.smarthire.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CANDIDATE_ASSESSMENT_REF")
public class CandidateAssessmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CANDIDATE_ASSESSMENT_REF_DB_ID")
	private Long candidateAssessmentRefDbId;

	@Column(name = "CANDIDATE_DB_ID")
	private Long candidateDbId;

	@Column(name = "ASSESSMENT_DB_ID")
	private Long assessmentDbId;

	@Column(name = "ASSIGNED_DATE")
	private Date assignedDate;

	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "RECRUITER_DB_ID")
	private Long recruiterDbId;

	@Column(name = "SCORE")
	private Long score;

	public Long getCandidateAssessmentRefDbId() {
		return candidateAssessmentRefDbId;
	}

	public void setCandidateAssessmentRefDbId(Long candidateAssessmentRefDbId) {
		this.candidateAssessmentRefDbId = candidateAssessmentRefDbId;
	}

	public Long getCandidateDbId() {
		return candidateDbId;
	}

	public void setCandidateDbId(Long candidateDbId) {
		this.candidateDbId = candidateDbId;
	}

	public Long getAssessmentDbId() {
		return assessmentDbId;
	}

	public void setAssessmentDbId(Long assessmentDbId) {
		this.assessmentDbId = assessmentDbId;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Long getRecruiterDbId() {
		return recruiterDbId;
	}

	public void setRecruiterDbId(Long recruiterDbId) {
		this.recruiterDbId = recruiterDbId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CandidateAssessmentEntity [candidateAssessmentRefDbId=");
		builder.append(candidateAssessmentRefDbId);
		builder.append(", candidateDbId=");
		builder.append(candidateDbId);
		builder.append(", assessmentDbId=");
		builder.append(assessmentDbId);
		builder.append(", assignedDate=");
		builder.append(assignedDate);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", recruiterDbId=");
		builder.append(recruiterDbId);
		builder.append(", score=");
		builder.append(score);
		builder.append("]");
		return builder.toString();
	}

}
