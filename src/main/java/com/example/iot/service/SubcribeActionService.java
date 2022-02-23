package com.example.iot.service;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public abstract class SubcribeActionService extends Thread{
    private static final String QUEUE_NAME = "duy";

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

            channel.basicConsume(QUEUE_NAME, true, new ConsumerActionImpl());
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Close connection and free resources");
        }
    }
}
