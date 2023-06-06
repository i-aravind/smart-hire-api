package com.bnp.smarthire.service;

import org.springframework.stereotype.Service;

import com.bnp.smarthire.request.AuthenticateRequest;
import com.bnp.smarthire.response.RecruiterResponse;

@Service
public interface RecruiterService {
	
	public RecruiterResponse getRecruiterByReference(Long recruiterId);
	
	public RecruiterResponse getRecruiterByReference(String recruiterId);

	public Boolean authenticateRecruiter(AuthenticateRequest authenticateRequest);
}
