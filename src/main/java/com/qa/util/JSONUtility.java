package com.qa.util;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class JSONUtility {

	private Gson gson;

	public JSONUtility() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> classType) {
		return gson.fromJson(jsonString, classType);
	}
}
