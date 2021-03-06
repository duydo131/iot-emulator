package com.example.iot.message;

public class Humidity {
    private Long houseSensorId;
    private String sensorType;
    private Integer hum;

    public Humidity(Long houseSensorId, String sensorType, Integer hum) {
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

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Integer getHum() {
        return hum;
    }

    public void setHum(Integer hum) {
        this.hum = hum;
    }
}
