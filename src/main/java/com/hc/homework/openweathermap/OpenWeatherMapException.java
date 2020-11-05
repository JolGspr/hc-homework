package com.hc.homework.openweathermap;

import org.springframework.http.HttpStatus;

public class OpenWeatherMapException extends RuntimeException {
	
	private static final long serialVersionUID = 149566488807163048L;

	private HttpStatus status;
	
	private String message;

	public OpenWeatherMapException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
