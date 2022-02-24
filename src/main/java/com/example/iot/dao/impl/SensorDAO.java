package com.example.iot.dao.impl;

import com.example.iot.dao.ISensorDAO;
import com.example.iot.mapper.SensorMapper;
import com.example.iot.model.Sensor;

import java.util.List;

public class SensorDAO extends AbstractDAO<Sensor> implements ISensorDAO {

	private String sql;

	@Override
	public List<Sensor> findAll() {
		sql = "SELECT * FROM sensor";
		return query(sql, new SensorMapper());
	}

	@Override
	public Sensor findById(Integer id) {
		sql = "SELECT * FROM house WHERE id = ?";
		return query(sql, new SensorMapper(), id).get(0);
	}

	@Override
	public List<Sensor> findByType(String sensorType, Integer houseId) {
		sql = "SELECT * FROM house WHERE sensor_type = ? AND house_id = ?";
		return query(sql, new SensorMapper(), sensorType, houseId);
	}

	@Override
	public Integer insert(Sensor newHouse) {
		sql = "INSERT INTO house(id_server, sensor_type) VALUES (?,?)";
		return insert(sql, newHouse.getIdServer(), newHouse.getSensorType());
	}
}
