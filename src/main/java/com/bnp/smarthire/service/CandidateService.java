package com.bnp.smarthire.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.bnp.smarthire.request.AuthenticateRequest;
import com.bnp.smarthire.request.CreateCandidateRequest;
import com.bnp.smarthire.response.CandidateViewResponse;
import com.bnp.smarthire.response.CreateCandidateResponse;

@Service
public interface CandidateService {
	
	public CreateCandidateResponse getCandidatesByReference(Long candidateId);
	
	public CreateCandidateResponse getCandidatesByReference(String email);

	public CreateCandidateResponse createCandidate(CreateCandidateRequest createCandidateRequest);
	
	public Boolean authenticateCandidate(AuthenticateRequest authenticateRequest);
	
	public Collection<CandidateViewResponse> getAllCandidates();
}
