package com.bnp.smarthire.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.bnp.smarthire.entity.RecruiterEntity;
import com.bnp.smarthire.repository.RecruiterRepository;
import com.bnp.smarthire.request.AuthenticateRequest;
import com.bnp.smarthire.response.RecruiterResponse;
import com.bnp.smarthire.service.RecruiterService;

@Component
public class RecruiterServiceImpl implements RecruiterService {

	private RecruiterRepository recruiterRepository;
	
	public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
		this.recruiterRepository = recruiterRepository;
	}
	@Override
	public Boolean authenticateRecruiter(AuthenticateRequest authenticateRequest) {
		try{
			return Objects.nonNull(recruiterRepository.validateRecruiter(Long.valueOf(authenticateRequest.getUser()), authenticateRequest.getPassword()));
		}catch(Exception e) {
			return Objects.nonNull(recruiterRepository.validateRecruiter(authenticateRequest.getUser(),authenticateRequest.getPassword()));
		}
	}
	
	@Override
	public RecruiterResponse getRecruiterByReference(Long recruiterId) {
		RecruiterResponse recruiterResponse = new RecruiterResponse();
		RecruiterEntity recruiterEntity = recruiterRepository.getReferenceById(recruiterId);
		recruiterResponse.setRecruiterId(recruiterEntity.getRecruiterDbId());
		recruiterResponse.setRecruiterName(recruiterEntity.getRecruiterName());
		recruiterResponse.setRecruiterEmail(recruiterEntity.getEmail());
		recruiterResponse.setPassword(recruiterEntity.getPassword());
		return recruiterResponse;
	}
	@Override
	public RecruiterResponse getRecruiterByReference(String recruiterId) {
		RecruiterResponse recruiterResponse = new RecruiterResponse();
		RecruiterEntity recruiterEntity = recruiterRepository.getReferenceByEmailId(recruiterId);
		recruiterResponse.setRecruiterId(recruiterEntity.getRecruiterDbId());
		recruiterResponse.setRecruiterName(recruiterEntity.getRecruiterName());
		recruiterResponse.setRecruiterEmail(recruiterEntity.getEmail());
		recruiterResponse.setPassword(recruiterEntity.getPassword());
		return recruiterResponse;
	}

}
