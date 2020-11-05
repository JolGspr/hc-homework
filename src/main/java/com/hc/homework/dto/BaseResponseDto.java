package com.hc.homework.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseResponseDto {

	private String responseCode;
	
	private String message;
	
	public BaseResponseDto() {}
	
	public BaseResponseDto(String message) {
		this.message = message;
	}


	public BaseResponseDto(String responseCode, String message) {
		super();
		this.responseCode = responseCode;
		this.message = message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
