package com.hc.homework.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="weather_log")
public class WeatherLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String responseId;
	
	@NotNull
	private String location;
	
	@NotNull
	private String actualWeather;
	
	@NotNull
	private String temperature;
	
	@NotNull
	private LocalDateTime dtimeInserted; // in UTC
	
	public WeatherLog() {}

	public WeatherLog(String location, String actualWeather, String temperature,
			LocalDateTime dtimeInserted) {
		super();
		this.location = location;
		this.actualWeather = actualWeather;
		this.temperature = temperature;
		this.dtimeInserted = dtimeInserted;
	}

	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
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

	public LocalDateTime getDtimeInserted() {
		return dtimeInserted;
	}

	public void setDtimeInserted(LocalDateTime dtimeInserted) {
		this.dtimeInserted = dtimeInserted;
	}
	
	@PrePersist
	public void autofill() {
		this.setResponseId(UUID.randomUUID().toString());
	}

}
