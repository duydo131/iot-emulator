package com.example.iot.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorAction {
    private Long houseSensorId;
    private String sensorType;
    private Boolean status;

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
