package com.bnp.smarthire.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bnp.smarthire.entity.CandidateAssessmentEntity;
import com.bnp.smarthire.repository.AssessmentRepository;
import com.bnp.smarthire.repository.CandidateAssessmentRepository;
import com.bnp.smarthire.repository.RecruiterRepository;
import com.bnp.smarthire.response.CandidateAssessmentResponse;
import com.bnp.smarthire.service.CandidateAssignmentService;

@Component
public class CandidateAssignmentServiceImpl implements CandidateAssignmentService {

	private CandidateAssessmentRepository candidateAssessmentRepository;
	
	private AssessmentRepository assessmentRepository;
	
	private RecruiterRepository recruiterRepository;

	@Autowired
	public CandidateAssignmentServiceImpl(CandidateAssessmentRepository candidateAssessmentRepository, AssessmentRepository assessmentRepository, RecruiterRepository recruiterRepository) {
		this.candidateAssessmentRepository = candidateAssessmentRepository;
		this.assessmentRepository = assessmentRepository;
		this.recruiterRepository = recruiterRepository;
	}

	@Override
	public Collection<CandidateAssessmentResponse> getAssessmentDetailsForCandidate(Long candidateId) {
		Collection<CandidateAssessmentResponse> candidateAssessmentResponses = new ArrayList<CandidateAssessmentResponse>();
		Collection<CandidateAssessmentEntity> candidateAssessmentEntitys = candidateAssessmentRepository
				.getAssessmentDetails(candidateId);
		for(CandidateAssessmentEntity candidateAssessmentEntity : candidateAssessmentEntitys) {
			CandidateAssessmentResponse candidateAssessmentResponse = new CandidateAssessmentResponse();
			candidateAssessmentResponse.setCandidateId(candidateAssessmentEntity.getCandidateDbId());
			candidateAssessmentResponse.setAssessmentId(candidateAssessmentEntity.getAssessmentDbId());
			candidateAssessmentResponse.setAssessmentName(assessmentRepository.getReferenceById(candidateAssessmentEntity.getAssessmentDbId()).getAssessmentName());
			candidateAssessmentResponse.setAssignedDate(getDateString(candidateAssessmentEntity.getAssignedDate()));
			candidateAssessmentResponse.setExpiryDate(getDateString(candidateAssessmentEntity.getExpiryDate()));
			candidateAssessmentResponse.setStatus(candidateAssessmentEntity.getStatus());
			candidateAssessmentResponse.setRecruiterEmail(recruiterRepository.getReferenceById(candidateAssessmentEntity.getRecruiterDbId()).getEmail());
			candidateAssessmentResponses.add(candidateAssessmentResponse);
		}
		return candidateAssessmentResponses;
	}

	private String getDateString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return Objects.nonNull(date)?dateFormat.format(date):null;
	}
	
	private Date getDate(String date) {
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-MM-dd");
		try{
		return DateFor.parse(date);
		}catch (ParseException e) {e.printStackTrace();}
		return null;
	}

	@Override
	public Boolean scheduleAssessment(CandidateAssessmentResponse request) {
		try {
			CandidateAssessmentEntity candidateAssessmentEntity = new CandidateAssessmentEntity();
			candidateAssessmentEntity.setCandidateDbId(request.getCandidateId());
			candidateAssessmentEntity.setAssessmentDbId(assessmentRepository.getByName(request.getAssessmentName()));
			candidateAssessmentEntity.setRecruiterDbId(recruiterRepository.getReferenceByEmailId(request.getRecruiterEmail()).getRecruiterDbId());
			candidateAssessmentEntity.setAssignedDate(getDate(request.getAssignedDate()));
			candidateAssessmentEntity.setExpiryDate(getDate(request.getExpiryDate()));
			candidateAssessmentEntity.setStatus(request.getStatus());
			return Objects.nonNull(candidateAssessmentRepository.save(candidateAssessmentEntity));
		}catch(Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean revokeAssessment(CandidateAssessmentResponse request) {
		try {
			System.out.println(request.getCandidateId()+" " + request.getAssessmentName());
			candidateAssessmentRepository.deleteAssessmentDetails(request.getCandidateId(), assessmentRepository.getByName(request.getAssessmentName()));
			return Boolean.TRUE;
		}catch(Exception e) {
			return Boolean.FALSE;
		}
	}

	@Override
	public Boolean submission(Long candidateId, Long assessmentId, String status,Long score) {
		try {
			candidateAssessmentRepository.updateSubmission(candidateId, assessmentId, score, status);
			return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}
}
