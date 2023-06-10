package com.bnp.smarthire.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import com.bnp.smarthire.request.AuthenticateRequest;
import com.bnp.smarthire.response.CreateCandidateResponse;
import com.bnp.smarthire.service.CandidateAssignmentService;
import com.bnp.smarthire.service.CandidateService;
import com.bnp.smarthire.service.QuestionaireService;
import com.bnp.smarthire.service.RecruiterService;
import com.bnp.smarthire.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class TestSmartHireController extends TestUtils{
	
	private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestSmartHireController.class);

	@InjectMocks private SmartHireController smartHireController;
	@Mock private CandidateService candidateService;
	@Mock private CandidateAssignmentService candidateAssignmentService;
	@Mock private RecruiterService recruiterService;
	@Mock private QuestionaireService questionaireService; 
	
	
	@BeforeEach
	public void setup(){
		super.setup();
		this.smartHireController = new SmartHireController(candidateService, candidateAssignmentService, recruiterService, questionaireService);
	}
	@Test
	public void testAuthenticateByUser() {
		printTestSeperator();
		printTestNameStart("testAuthenticateByUser");
		Map<String, String> request = new HashMap<>();
		request.put("user", "1");
		request.put("password", "1234");
		CreateCandidateResponse response = new CreateCandidateResponse();
		response.setCandidateId(1L);
		response.setCandidateName("Pethaperumal");
		Mockito.when(candidateService.authenticateCandidate(Mockito.any(AuthenticateRequest.class))).thenReturn(Boolean.TRUE);
		Mockito.when(candidateService.getCandidatesByReference(Mockito.anyString())).thenReturn(response);
		response = this.smartHireController.authenticate(request);
		LOGGER.info("Candidate autentication : {}",true);
		assertEquals(1L,response.getCandidateId(),"Candidate Id should be "+1L);
		assertEquals("Pethaperumal",response.getCandidateName(),"Candidate Name should be "+1L_);
		printTestNameEnd("testAuthenticateByUser");
	}

}
