package com.example.iot;

import com.rabbitmq.client.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
    private final String QUEUE_NAME = "duy";

    public void test() throws Exception {
        System.out.println("Create a ConnectionFactory");
        ConnectionFactory factory = new ConnectionFactory();
//        factory.setVirtualHost("iot_dev");
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");

        System.out.println("Create a Connection");
        System.out.println("Create a Channel");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        try {
            System.out.println("Create a queue " + QUEUE_NAME);
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            System.out.println("Start sending messages ... ");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
                String message;
                do {
                    System.out.print("Enter message: ");
                    message = br.readLine().trim();
                    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                    System.out.println(" [x] Sent: '" + message + "'");
                } while (!message.equalsIgnoreCase("close"));
            }
        } finally {
            System.out.println("Close connection and free resources");
        }
    }

    public class X{
        private String x;
        public X(String x){
            this.x = x;
        }
        public String getX(){
            return x;
        }
    }

    public void convertToJson() throws JsonProcessingException {
        X x = new X("xxxxxxxxxxxxx");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(x);

        System.out.println(jsonString);
    }
}
