package com.hc.homework.openweathermap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenWeatherMapProperties {

	private String openWeatherMapUrl;
	private String openWeatherMapApiKey;
	
	@Autowired
	public OpenWeatherMapProperties(@Value("${openweathermap.current.weather.url:}") String openWeatherMapUrl,
			@Value("${openweathermap.api.key:}") String openWeatherMapApiKey) {
		this.openWeatherMapUrl = openWeatherMapUrl;
		this.openWeatherMapApiKey = openWeatherMapApiKey;
	}

	public String getOpenWeatherMapUrl() {
		return openWeatherMapUrl;
	}

	public void setOpenWeatherMapUrl(String openWeatherMapUrl) {
		this.openWeatherMapUrl = openWeatherMapUrl;
	}

	public String getOpenWeatherMapApiKey() {
		return openWeatherMapApiKey;
	}

	public void setOpenWeatherMapApiKey(String openWeatherMapApiKey) {
		this.openWeatherMapApiKey = openWeatherMapApiKey;
	}
}
