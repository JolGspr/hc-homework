package com.hc.homework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hc.homework.model.WeatherLog;

public interface WeatherLogRepository extends JpaRepository<WeatherLog, Integer> {

	List<WeatherLog> findTop5ByOrderByIdDesc();
}
