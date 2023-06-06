package com.bnp.smarthire.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.bnp.smarthire.response.CandidateAssessmentResponse;

@Service
public interface CandidateAssignmentService {

	public Collection<CandidateAssessmentResponse> getAssessmentDetailsForCandidate(Long candidateId);
	
	public Boolean scheduleAssessment(CandidateAssessmentResponse request);
	
	public Boolean revokeAssessment(CandidateAssessmentResponse request);
	
	public Boolean submission(Long candidateId, Long assessmentId, String status, Long score);
}
