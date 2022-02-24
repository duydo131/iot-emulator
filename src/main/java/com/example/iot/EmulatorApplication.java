package com.example.iot;

import com.example.iot.dao.IHouseDAO;
import com.example.iot.dao.ISensorDAO;
import com.example.iot.dao.impl.HouseDAO;
import com.example.iot.dao.impl.SensorDAO;
import com.example.iot.message.HouseSensorData;
import com.example.iot.message.SensorAction;
import com.example.iot.model.House;
import com.example.iot.model.Sensor;
import com.example.iot.service.PublishDevice;
import com.example.iot.service.PublishService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

public class EmulatorApplication {

    private static final String QUEUE_HOUSE_SENSOR_NAME = "queue.hust.iot.house-sensor";

    private static final String QUEUE_ACTION = "queue.hust.iot.action";

    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println("*****************************************");
        subscribeHouseSensor();
        subscribeLedAndDoor();
    }

    public static void subscribeHouseSensor() {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            try {
                HouseSensorData houseSensorData = new ObjectMapper().readValue(message, HouseSensorData.class);
                processHouseSensor(houseSensorData);
            } catch (Exception e) {
                try {
                    String test = message.replace("\\", "");
                    HouseSensorData houseSensorData = new ObjectMapper().readValue(test.substring(1, test.length() - 1), HouseSensorData.class);
                    processHouseSensor(houseSensorData);
                } catch (Exception exception) {
                    return;
                }
            }
        };

        processQueue(QUEUE_HOUSE_SENSOR_NAME, deliverCallback);
    }

    public static void processHouseSensor(HouseSensorData houseSensorData) throws IOException {
//        IHouseDAO houseDAO = new HouseDAO();
//        ISensorDAO sensorDAO = new SensorDAO();

        System.out.println("Ban vua dang ky thiet bi "
                + houseSensorData.getSensorType() + " vao nha: "
                + houseSensorData.getHouseName());
//
//        // save data to db
//        houseDAO.insert(new House(houseSensorData.getHouseId(), houseSensorData.getHouseName()));
//        sensorDAO.insert(new Sensor(houseSensorData.getSensorId(), houseSensorData.getSensorType()));

        PublishService publishService = new PublishDevice(houseSensorData.getHouseId());
        publishService.start();
    }

    public static void processQueue(String queueName, DeliverCallback deliverCallback) {
        // init connection to broker
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);

        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(queueName, true, false, false, null);
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void subscribeLedAndDoor() {
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            try {
                SensorAction sensorAction = new ObjectMapper().readValue(message, SensorAction.class);
                if (Objects.equals(sensorAction.getSensorType(), "LED")) {
                    if (sensorAction.getStatus()) {
                        System.out.println("Bật đèn LED phòng " + sensorAction.getHouseSensorId());
                    } else {
                        System.out.println("Tắt đèn LED phòng " + sensorAction.getHouseSensorId());
                    }
                } else {
                    if (sensorAction.getStatus()) {
                        System.out.println("Mở cửa phòng " + sensorAction.getHouseSensorId());
                    } else {
                        System.out.println("Đóng cửa phòng " + sensorAction.getHouseSensorId());
                    }
                }
            } catch (Exception e) {
                return;
            }
        };

        processQueue(QUEUE_ACTION, deliverCallback);
    }

}
