package com.bnp.smarthire.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnp.smarthire.request.AuthenticateRequest;
import com.bnp.smarthire.request.CreateCandidateRequest;
import com.bnp.smarthire.request.SubmissionRequest;
import com.bnp.smarthire.response.CandidateAssessmentResponse;
import com.bnp.smarthire.response.CandidateViewResponse;
import com.bnp.smarthire.response.CreateCandidateResponse;
import com.bnp.smarthire.response.QuestionsResponse;
import com.bnp.smarthire.response.RecruiterResponse;
import com.bnp.smarthire.service.CandidateAssignmentService;
import com.bnp.smarthire.service.CandidateService;
import com.bnp.smarthire.service.QuestionaireService;
import com.bnp.smarthire.service.RecruiterService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class SmartHireController {
	
	private CandidateService candidateService;
	
	private CandidateAssignmentService candidateAssignmentService;
	
	private RecruiterService recruiterService;
	
	private QuestionaireService questionaireService;
	
	@Autowired
	public SmartHireController(final CandidateService candidateService, CandidateAssignmentService candidateAssignmentService, RecruiterService recruiterService, QuestionaireService questionaireService) {
		this.candidateService = candidateService;
		this.candidateAssignmentService = candidateAssignmentService;
		this.recruiterService = recruiterService;
		this.questionaireService = questionaireService;
	}	
	
	@PostMapping(value = "/scheduleAssessment")
	public Boolean scheduleAssessment(@RequestBody CandidateAssessmentResponse createCandidateRequest) {
		return candidateAssignmentService.scheduleAssessment(createCandidateRequest);
	}
	
	@PostMapping(value = "/revokeAssessment")
	public Boolean revokeAssessment(@RequestBody CandidateAssessmentResponse createCandidateRequest) {
		return candidateAssignmentService.revokeAssessment(createCandidateRequest);
	}
	
	@PostMapping(value = "/createCandidate")
	public CreateCandidateResponse createCandidate(@RequestBody CreateCandidateRequest createCandidateRequest) {
		return candidateService.createCandidate(createCandidateRequest);
	}
	
	@GetMapping(value = "/authenticate")
	public CreateCandidateResponse authenticate(@RequestParam Map<String, String> request) {
		CreateCandidateResponse response = new CreateCandidateResponse();
		AuthenticateRequest authenticateRequest = new AuthenticateRequest(request.get("user"),request.get("password"));
		if(candidateService.authenticateCandidate(authenticateRequest)) {
			try {
				response = candidateService.getCandidatesByReference(Long.valueOf(authenticateRequest.getUser()));
			}catch(Exception e) {
				response = candidateService.getCandidatesByReference(authenticateRequest.getUser());
			}
			response.setAuthenticated(Boolean.TRUE);
		}else {
			response.setAuthenticated(Boolean.FALSE);
		}
		return response;
	}
	
	@GetMapping(value = "/getAssessmentDetails")
	public Collection<CandidateAssessmentResponse> getAssessmentDetails(@RequestParam Map<String, String> request) {
		try {
			return candidateAssignmentService.getAssessmentDetailsForCandidate(Long.valueOf(request.get("candidateId")));
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(value = "/authenticateRecruiter")
	public RecruiterResponse authenticateRecruiter(@RequestParam Map<String, String> request) {
		RecruiterResponse response = new RecruiterResponse();
		AuthenticateRequest authenticateRequest = new AuthenticateRequest(request.get("user"),request.get("password"));
		if(recruiterService.authenticateRecruiter(authenticateRequest)) {
			try {
				response = recruiterService.getRecruiterByReference(Long.valueOf(authenticateRequest.getUser()));
			}catch(Exception e) {
				response = recruiterService.getRecruiterByReference(authenticateRequest.getUser());
			}
			response.setAuthenticated(Boolean.TRUE);
		}else {
			response.setAuthenticated(Boolean.FALSE);
		}
		return response;
	}
	
	@GetMapping(value = "/getAllCandidates")
	public Collection<CandidateViewResponse> getAllCandidates() {
		return candidateService.getAllCandidates();
	}
	
	@GetMapping(value = "/getQuestions")
	public Collection<QuestionsResponse> getQuestions(@RequestParam Map<String, String> request) {
		String assessmentId = request.get("assessmentId").replaceAll("\"", "");
		return questionaireService.getQuestionaires(Long.parseLong(assessmentId));
	}
	
	@PostMapping(value = "/submission")
	public Long submission(@RequestBody SubmissionRequest submissionRequest) {
		System.out.println(submissionRequest);
		return questionaireService.checkSubmission(submissionRequest);
	}
	
}
