package com.example.iot.mapper;

import com.example.iot.model.House;
import com.example.iot.model.Sensor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorMapper implements RowMapper<Sensor> {
	@Override
    public Sensor mapRow(ResultSet rs) {
        Sensor sensor = new Sensor();
        try {
            sensor.setId(rs.getInt("id"));
            sensor.setIdServer(rs.getLong("id_server"));
            return sensor;
        } catch (SQLException ex) {
            return null;
        }
    }
}
