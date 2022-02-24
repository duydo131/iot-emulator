package com.example.iot.dao;

import com.example.iot.model.House;

import java.util.List;

public interface IHouseDAO extends IGenericDAO<House> {
	List<House> findAll();

    Integer insert(House newHouse);

    House findById(Integer id);
}
