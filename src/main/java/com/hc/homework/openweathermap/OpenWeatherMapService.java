package com.hc.homework.openweathermap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OpenWeatherMapService {

	private OpenWeatherMapProperties openWeatherMapProperties;
	
	@Autowired
	public OpenWeatherMapService(OpenWeatherMapProperties openWeatherMapProperties) {
		this.openWeatherMapProperties = openWeatherMapProperties;
	}
	
	public CurrentWeatherResponse getCurrentWeatherByCityName(String locationName) {
		RestTemplate restTemplate =  new RestTemplate();
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openWeatherMapProperties.getOpenWeatherMapUrl())
		        .queryParam("q", locationName)
		        .queryParam("appid", openWeatherMapProperties.getOpenWeatherMapApiKey())
		        .queryParam("units", "metric");
		
		String uri = builder.build().toUriString();
		
		try {
			ResponseEntity<CurrentWeatherResponse> response = restTemplate.postForEntity(uri, null, CurrentWeatherResponse.class);
			
			if (!response.getStatusCode().is2xxSuccessful()) {
				throw new RuntimeException("Error fetching weather information from openweathermap.org");
			}
			
			return response.getBody();
			
		}  catch (HttpClientErrorException e) {
			if (e.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
				throw new OpenWeatherMapException(e.getStatusCode(), 
						"A problem was encountered while processing your request. Please contact the administrator.");
			} else {
				throw new OpenWeatherMapException(e.getStatusCode(), extractErrorResponse(e));
			}
		}
	}
	
	private String extractErrorResponse(HttpClientErrorException e) {
		String responseBody = e.getResponseBodyAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			Map<?,?> map = objectMapper.readValue(responseBody, HashMap.class);
			return map.get("message").toString();
		} catch (IOException e1) {
			throw new RuntimeException("An exception was encountered while extracting error response body");
		}
	}
}
