package com.example.iot.dao;

import java.util.List;

import com.example.iot.model.House;

public interface IHouseDAO extends IGenericDAO<House> {
	List<House> findAll();

    Integer insert(House newHouse);

    House findById(Integer id);
}
