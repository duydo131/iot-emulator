package com.example.iot.dao.impl;

import java.util.List;

import com.example.iot.dao.IHouseDAO;
import com.example.iot.mapper.HouseMapper;
import com.example.iot.model.House;

public class HouseDAO extends AbstractDAO<House> implements IHouseDAO {

	private String sql;

	@Override
	public List<House> findAll() {
		sql = "SELECT * FROM house";
		return query(sql, new HouseMapper());
	}

	@Override
	public House findById(Integer id) {
		sql = "SELECT * FROM house WHERE id = ?";
		return query(sql, new HouseMapper(), id).get(0);
	}

	@Override
	public Integer insert(House newHouse) {
		sql = "INSERT INTO house(id_server, name) VALUES (?,?)";
		return insert(sql, newHouse.getIdServer(), newHouse.getName());
	}
}
