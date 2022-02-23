package com.example.iot.message;

public class Thermometer {
    private Long houseSensorId;
    private SensorType sensorType;
    private Integer temp;;

    public Thermometer(Long houseSensorId, SensorType sensorType, Integer temp) {
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

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer hum) {
        this.temp = hum;
    }
}
