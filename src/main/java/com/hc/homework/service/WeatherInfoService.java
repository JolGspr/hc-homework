package com.hc.homework.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hc.homework.dto.WeatherInfoRequest;
import com.hc.homework.dto.WeatherLogInfo;
import com.hc.homework.model.WeatherLog;
import com.hc.homework.openweathermap.CurrentWeatherResponse;
import com.hc.homework.openweathermap.OpenWeatherMapService;
import com.hc.homework.repository.WeatherLogRepository;

@Service
public class WeatherInfoService {
	
	private OpenWeatherMapService openWeatherMapService;
	private WeatherLogRepository weatherLogRepository;
	
	@Autowired
	public WeatherInfoService(OpenWeatherMapService openWeatherMapService,
			WeatherLogRepository weatherLogRepository) {
		this.openWeatherMapService = openWeatherMapService;
		this.weatherLogRepository = weatherLogRepository;
	}
	
	//API #1
	public WeatherLogInfo getWeatherInformationByLocation(WeatherInfoRequest request) {
		CurrentWeatherResponse response = openWeatherMapService.getCurrentWeatherByCityName(request.getLocation());
		
		String locationName = response.getName();
		String actualWeather = response.getWeather().get(0).getMain();
		String temperature = String.valueOf(response.getMain().getTemp()) + " celsius";
		
		LocalDateTime currentDateTime = LocalDateTime.now(ZoneOffset.UTC);
		
		WeatherLog saved = weatherLogRepository.save(new WeatherLog(locationName, actualWeather, temperature, currentDateTime));
 		
		return new WeatherLogInfo(saved.getLocation(), saved.getActualWeather(), saved.getTemperature());
	}
	
	//API #2
	public List<WeatherLogInfo> fetchLastFiveWeatherInfo() {
		return weatherLogRepository.findTop5ByOrderByIdDesc().stream().map(i -> new WeatherLogInfo(i.getLocation(), i.getActualWeather(),
				i.getTemperature())).collect(Collectors.toList());
	}
}
