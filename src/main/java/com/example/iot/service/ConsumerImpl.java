package com.example.iot.service;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import java.io.IOException;

public class ConsumerImpl implements Consumer {
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

    }
}
