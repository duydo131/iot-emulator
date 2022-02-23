package com.example.iot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;


public abstract class PublishService extends Thread{

    private static final String QUEUE_NAME = "duy";
    private static final Random random = new Random();

    public abstract Object[] factoryObject();

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
            while(true){
                for(Object o : factoryObject()){
                    String message = convertToJson(o);
                    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                }
                Thread.sleep(5000);
            }
        } catch (IOException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Close connection and free resources");
        }
    }

    public String convertToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    // return integer [min,max]
    public Integer genInteger(Integer min, Integer max){
        return random.nextInt(max - min) + min;
    }

    // return float [min,max]
    public Double genDouble(Double min, Double max){
        return random.nextDouble() * (max - min) + min;
    }
}
