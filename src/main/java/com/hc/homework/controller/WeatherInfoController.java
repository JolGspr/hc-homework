package com.hc.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hc.homework.dto.WeatherInfoRequest;
import com.hc.homework.dto.WeatherLogInfo;
import com.hc.homework.service.WeatherInfoService;

@RestController
@RequestMapping("hc-homework/weather-info")
public class WeatherInfoController extends BaseController {
	
	private WeatherInfoService weatherInfoService;
	
	@Autowired
	public WeatherInfoController(WeatherInfoService weatherInfoService) {
		this.weatherInfoService = weatherInfoService;
	}
	
	@PostMapping(value = "location")
	public ResponseEntity<?> getWeatherInfoByLocation(@RequestBody WeatherInfoRequest request) {
		WeatherLogInfo resp = weatherInfoService.getWeatherInformationByLocation(request);
		return ResponseEntity.ok(resp);
	}
	
	@GetMapping(value = "latest-5")
	public ResponseEntity<?> getLatestFive() {
		List<WeatherLogInfo> resp = weatherInfoService.fetchLastFiveWeatherInfo();
		return ResponseEntity.ok(resp);
	}

}
