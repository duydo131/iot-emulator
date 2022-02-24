package com.example.iot.message;

public class Led {
    private Long houseSensorId;
    private String sensorType;
    private Boolean status;

    public Led(Long houseSensorId, String sensorType, Boolean status) {
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

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
