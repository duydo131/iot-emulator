package com.example.iot.service;

import com.example.iot.dao.IHouseDAO;
import com.example.iot.dao.ISensorDAO;
import com.example.iot.dao.impl.HouseDAO;
import com.example.iot.dao.impl.SensorDAO;
import com.example.iot.model.Sensor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

public class ConsumerAddHouseImpl implements Consumer {

    private ISensorDAO sensorDAO = new SensorDAO();
    private IHouseDAO houseDAO = new HouseDAO();

    @Override
    public void handleConsumeOk(String s) {
    }

    @Override
    public void handleCancelOk(String s) {
        System.out.println("Cancel OK");
    }

    @Override
    public void handleCancel(String s) throws IOException {
        System.out.println("Cancel");
    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {
        System.out.println("Shutdown");
    }

    @Override
    public void handleRecoverOk(String s) {
        System.out.println("Recover OK");
    }

    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Sensor message = mapper.readValue(s, Sensor.class);
        sensorDAO.insert(message);
    }
}
