package com.example.iot.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class SubscribeHouseSensorService extends Thread {
    private static final String QUEUE_NAME = "queue.hust.iot.house-sensor";

    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        try{
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.basicConsume(QUEUE_NAME, true, new ConsumerHouseSensorImpl());

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Close connection and free resources");
        }
    }
}
