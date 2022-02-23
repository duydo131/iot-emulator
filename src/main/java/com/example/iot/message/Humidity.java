package com.example.iot.message;

public class Humidity {
    private Long houseSensorId;
    private SensorType sensorType;
    private Integer hum;

    public Humidity(Long houseSensorId, SensorType sensorType, Integer hum) {
        this.houseSensorId = houseSensorId;
        this.sensorType = sensorType;
        this.hum = hum;
    }

    public Long getHouseSensorId() {
        return houseSensorId;
    }

    public void setHouseSensorId(Long houseSensorId) {
        this.houseSensorId = houseSensorId;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public Integer getHum() {
        return hum;
    }

    public void setHum(Integer hum) {
        this.hum = hum;
    }
}
