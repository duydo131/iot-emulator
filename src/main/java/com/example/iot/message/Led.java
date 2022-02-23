package com.example.iot.message;

public class Led {
    private Long houseSensorId;
    private SensorType sensorType;
    private Boolean status;

    public Led(Long houseSensorId, SensorType sensorType, Boolean status) {
        this.houseSensorId = houseSensorId;
        this.sensorType = sensorType;
        this.status = status;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
