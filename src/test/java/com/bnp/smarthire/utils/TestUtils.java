package com.bnp.smarthire.utils;

import org.junit.jupiter.api.BeforeEach;
import org.slf4j.LoggerFactory;

public class TestUtils {

	private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TestUtils.class);
	
	@BeforeEach
	protected void setup(){
		LOGGER.info("********* Starting Services *********");
	}
	
	protected void printTestSeperator() {
		LOGGER.info("=".repeat(40));
	}
	
	protected void printTestNameStart(String testName) {
		LOGGER.info("Start "+ testName);
	}
	
	protected void printTestNameEnd(String testName) {
		LOGGER.info("End "+ testName);
	}
}
