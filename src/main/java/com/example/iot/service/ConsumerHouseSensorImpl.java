package com.example.iot.service;

import com.example.iot.message.HouseSensorData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

public class ConsumerHouseSensorImpl implements Consumer {

    public ConsumerHouseSensorImpl() {
    }

    @Override
    public void handleConsumeOk(String s) {

    }

    @Override
    public void handleCancelOk(String s) {

    }

    @Override
    public void handleCancel(String s) throws IOException {

    }


    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    @Override
    public void handleRecoverOk(String s) {

    }

    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        HouseSensorData houseSensorData = objectMapper.readValue(s, HouseSensorData.class);
        System.out.println("data is: ");
    }
}
