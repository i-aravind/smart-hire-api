package com.bnp.smarthire.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.bnp.smarthire.entity.CandidateAssessmentEntity;
import com.bnp.smarthire.entity.CandidateEntity;
import com.bnp.smarthire.repository.AssessmentRepository;
import com.bnp.smarthire.repository.CandidateAssessmentRepository;
import com.bnp.smarthire.repository.CandidateRepository;
import com.bnp.smarthire.request.AuthenticateRequest;
import com.bnp.smarthire.request.CreateCandidateRequest;
import com.bnp.smarthire.response.CandidateViewResponse;
import com.bnp.smarthire.response.CreateCandidateResponse;
import com.bnp.smarthire.service.CandidateService;

@Component
public class CandidateServiceImpl implements CandidateService {

	private CandidateRepository candidateRepository;
	
	private CandidateAssessmentRepository candidateAssessmentRepository;
	
	private AssessmentRepository assessmentRepository;
	
	@Autowired
	public CandidateServiceImpl(final CandidateRepository candidateRepository, CandidateAssessmentRepository candidateAssessmentRepository, AssessmentRepository assessmentRepository) {
		this.candidateRepository = candidateRepository;
		this.candidateAssessmentRepository = candidateAssessmentRepository;
		this.assessmentRepository = assessmentRepository;
	}
	
	@Override
	public CreateCandidateResponse createCandidate(CreateCandidateRequest createCandidateRequest) {
		CandidateEntity candidateEntity = new CandidateEntity();
		candidateEntity.setEmail(createCandidateRequest.getEmail());
		candidateEntity.setPassword(createCandidateRequest.getPassword());
		candidateEntity.setCandidateName(createCandidateRequest.getCandidateName());
		candidateEntity.setCandidateQualification(createCandidateRequest.getCandidateQualification());
		Date dob = getDate(createCandidateRequest.getDob());
		candidateEntity.setDob(dob);
		candidateEntity.setRole(createCandidateRequest.getRole());
		candidateEntity.setYearsofExperience(createCandidateRequest.getYearsofExperience());
		CreateCandidateResponse response = new CreateCandidateResponse();
		try{
			CandidateEntity savedcandidate= candidateRepository.save(candidateEntity);
			savedcandidate = candidateRepository.getReferenceById(savedcandidate.getCandidateId());
			response.setCandidateId(savedcandidate.getCandidateId());
			response.setEmail(savedcandidate.getEmail());
			response.setPassword(savedcandidate.getPassword());
			response.setCandidateName(savedcandidate.getCandidateName());
			response.setCandidateQualification(savedcandidate.getCandidateQualification());
			response.setDob(getDateString(savedcandidate.getDob()));
			response.setRole(savedcandidate.getRole());
			response.setYearsofExperience(savedcandidate.getYearsofExperience());
			return response;
		}catch(Exception e) {
			response.setErrorMsg("Email already exist in the database : "+createCandidateRequest.getEmail());
			return response;
		}
	}

	private Date getDate(String dob) {
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
		try{
		return DateFor.parse(dob);
		}catch (ParseException e) {e.printStackTrace();}
		return null;
	}
	
	private String getDateString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        return dateFormat.format(date);  
	}

	@Override
	public Boolean authenticateCandidate(AuthenticateRequest authenticateRequest) {
		try {
			Boolean status = Objects.nonNull(candidateRepository.validateCandidate(Long.parseLong(authenticateRequest.getUser()), authenticateRequest.getPassword()));
			return status;
		}catch(Exception e) {
			return Objects.nonNull(candidateRepository.validateCandidate(authenticateRequest.getUser(), authenticateRequest.getPassword()));
		}
	}

	@Override
	public CreateCandidateResponse getCandidatesByReference(Long candidateId) {
		CreateCandidateResponse response = new CreateCandidateResponse();
		CandidateEntity fetchedCandidate = candidateRepository.getReferenceById(candidateId);
		response.setCandidateId(fetchedCandidate.getCandidateId());
		response.setEmail(fetchedCandidate.getEmail());
		response.setPassword(fetchedCandidate.getPassword());
		response.setCandidateName(fetchedCandidate.getCandidateName());
		response.setCandidateQualification(fetchedCandidate.getCandidateQualification());
		response.setDob(getDateString(fetchedCandidate.getDob()));
		response.setRole(fetchedCandidate.getRole());
		response.setYearsofExperience(fetchedCandidate.getYearsofExperience());
		return response;
	}

	@Override
	public CreateCandidateResponse getCandidatesByReference(String email) {
		CreateCandidateResponse response = new CreateCandidateResponse();
		CandidateEntity fetchedCandidate = candidateRepository.getCandidateByEmail(email);
		response.setCandidateId(fetchedCandidate.getCandidateId());
		response.setEmail(fetchedCandidate.getEmail());
		response.setPassword(fetchedCandidate.getPassword());
		response.setCandidateName(fetchedCandidate.getCandidateName());
		response.setCandidateQualification(fetchedCandidate.getCandidateQualification());
		response.setDob(getDateString(fetchedCandidate.getDob()));
		response.setRole(fetchedCandidate.getRole());
		response.setYearsofExperience(fetchedCandidate.getYearsofExperience());
		return response;
	}

	@Override
	public Collection<CandidateViewResponse> getAllCandidates() {
		
		List<CandidateViewResponse> responses = new ArrayList<CandidateViewResponse>();
		for(CandidateEntity candidate :this.candidateRepository.findAll()) {
			CandidateViewResponse response = new CandidateViewResponse();
			response.setCandidateId(candidate.getCandidateId().toString());
			response.setCandidateName(candidate.getCandidateName());
			response.setCandidateEmail(candidate.getEmail());
			response.setCandidateQualification(candidate.getCandidateQualification());
			response.setCandidateExperince(candidate.getYearsofExperience().toString());
			Collection<CandidateAssessmentEntity> caes= candidateAssessmentRepository.getAssessmentDetails(candidate.getCandidateId());
			if(!CollectionUtils.isEmpty(caes)) {
				for(CandidateAssessmentEntity cae: caes) {
					Long percent = Objects.nonNull(cae.getScore())?cae.getScore()*10:0;
					CandidateViewResponse newResponse = response;
					newResponse.setAssessmentStatus(cae.getStatus());
					newResponse.setCandidateStatus(cae.getStatus().equals("PENDING")?"IN PROCESS":cae.getScore()>=7L?"SELECTED":"REJECTED");
					newResponse.setCandidateRole(assessmentRepository.getReferenceById(cae.getAssessmentDbId()).getAssessmentName());
					newResponse.setScore(percent.equals(0L)?"NA":percent.toString().concat("%"));
					responses.add(newResponse);
				}
			}else {
				response.setCandidateRole(candidate.getRole());
				response.setAssessmentStatus("NA");
				response.setCandidateStatus("NEW");
				response.setScore("NA");
				responses.add(response);
			}
		}
		return responses;
	}

}
