package com.example.iot.mapper;

import com.example.iot.model.House;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseMapper implements RowMapper<House> {
	@Override
    public House mapRow(ResultSet rs) {
		House house = new House();
        try {
        	house.setId(rs.getInt("id"));
            house.setIdServer(rs.getLong("id_server"));
        	house.setName(rs.getString("name"));
            return house;
        } catch (SQLException ex) {
            return null;
        }
    }
}
