package com.example.iot.dao;

import com.example.iot.model.Sensor;

import java.util.List;

public interface ISensorDAO extends IGenericDAO<Sensor> {
	List<Sensor> findAll();

    Integer insert(Sensor newSensor);

    Sensor findById(Integer id);

    List<Sensor> findByType(String sensorType, Integer houseId);
}
