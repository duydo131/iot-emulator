package com.example.iot.service;

import com.example.iot.message.GasConcentration;
import com.example.iot.message.Humidity;
import com.example.iot.message.SensorType;
import com.example.iot.message.Thermometer;

public class PublishDevice extends PublishService {
    private final Long house_id;

    public PublishDevice(Long house_id) {
        this.house_id = house_id;
    }

    @Override
    public Object[] factoryObject() {
        return new Object[]{
                new Humidity(
                        house_id,
                        SensorType.HUMIDITY,
                        genInteger(50, 100)
                ),
                new Thermometer(
                        house_id,
                        SensorType.HUMIDITY,
                        genInteger(10, 40)
                ),
                new GasConcentration(
                        house_id,
                        SensorType.HUMIDITY,
                        genDouble(0d, 1d)
                )
        };
    }
}
