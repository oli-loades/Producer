package com.qa.constants;

public interface GlossaryConstants {
	static final String HOST = "http://localhost";
	static final String PORT = ":8090";
	static final String API_GET_PATH = "/get-definition/";
	static final String API_GET_ALL_PATH = "/get-all-definitions/";
	static final String ROOT = "/dictionary";
	static final String API_GET_ADDRESS = HOST + PORT + ROOT + API_GET_PATH;
	static final String API_GET_ALL_ADDRESS = HOST + PORT + ROOT + API_GET_ALL_PATH;
	static final String REQUEST_MSG = "Request for Glossary API";

}
