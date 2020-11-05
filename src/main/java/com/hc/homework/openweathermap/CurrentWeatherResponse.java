package com.hc.homework.openweathermap;

import java.util.List;

public class CurrentWeatherResponse {
	
	private String name;
	
	private List<WeatherInfo> weather;
	
	private MainInfo main;

	public CurrentWeatherResponse() {}

	public CurrentWeatherResponse(String name, List<WeatherInfo> weather, MainInfo main) {
		super();
		this.name = name;
		this.weather = weather;
		this.main = main;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WeatherInfo> getWeather() {
		return weather;
	}

	public void setWeather(List<WeatherInfo> weather) {
		this.weather = weather;
	}

	public MainInfo getMain() {
		return main;
	}

	public void setMain(MainInfo main) {
		this.main = main;
	}

	
}
