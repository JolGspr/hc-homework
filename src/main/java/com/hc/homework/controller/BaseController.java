package com.hc.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.hc.homework.dto.BaseResponseDto;
import com.hc.homework.openweathermap.OpenWeatherMapException;

@RestController
public class BaseController {

	@ExceptionHandler({OpenWeatherMapException.class })
	public ResponseEntity<?> handleError(OpenWeatherMapException e) {
		return ResponseEntity.status(e.getStatus()).body(new BaseResponseDto(String.valueOf(e.getStatus().value()), e.getMessage()));
	}
}
