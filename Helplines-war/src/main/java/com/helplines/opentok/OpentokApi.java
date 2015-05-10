package com.helplines.opentok;

import com.opentok.OpenTok;
import com.opentok.Session;
import com.opentok.TokenOptions;
import com.opentok.exception.OpenTokException;

public class OpentokApi {

	int apiKey = 45233282; // Opentok API key
	String apiSecret = "a01e857f8325c95abed9d6cfbec544e6078cb067";
	private String sessionId = "1_MX40NTIzMzI4Mn5-MTQzMTI3OTA5ODI2Nn4zWkdQM2hCQzN6WGZrcEZ0b3RaU1JIV2J-fg";
	OpenTok openTok = new OpenTok(apiKey, apiSecret);

	public OpentokApi(int apiKey, String apiSecret) throws OpenTokException {
		Session session = openTok.createSession();
	}

	public OpentokApi(String sessionId, TokenOptions options)
			throws OpenTokException {
		String token = openTok.generateToken(sessionId);
	}
}
