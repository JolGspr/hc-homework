package com.hc.homework.dto;

public class WeatherLogInfo extends BaseResponseDto {
	
	private String location;
	
	private String actualWeather;
	
	private String temperature;
	
	public WeatherLogInfo(String location, String actualWeather, String temperature) {
		super();
		this.location = location;
		this.actualWeather = actualWeather;
		this.temperature = temperature;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getActualWeather() {
		return actualWeather;
	}

	public void setActualWeather(String actualWeather) {
		this.actualWeather = actualWeather;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
}
