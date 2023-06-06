package com.bnp.smarthire.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ASSESSMENT")
public class AssessmentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ASSESSMENT_DB_ID")
	private Long assessmentId;

	@Column(name = "ASSESSMENT_NAME")
	private String assessmentName;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AssessmentEntity [assessmentId=");
		builder.append(assessmentId);
		builder.append(", assessmentName=");
		builder.append(assessmentName);
		builder.append("]");
		return builder.toString();
	}

}
