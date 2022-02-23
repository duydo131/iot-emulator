package com.example.iot.message;

public class Thermometer {
    private Long houseSensorId;
    private String sensorType;
    private Integer temp;

    public Thermometer(Long houseSensorId, String sensorType, Integer temp) {
        this.houseSensorId = houseSensorId;
        this.sensorType = sensorType;
        this.temp = temp;
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

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer hum) {
        this.temp = hum;
    }
}
