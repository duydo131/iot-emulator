package com.example.iot.message;

public class GasConcentration {
    private Long houseSensorId;
    private String sensorType;
    private Double gasConcentration;

    public GasConcentration(Long houseSensorId, String sensorType, Double gasConcentration) {
        this.houseSensorId = houseSensorId;
        this.sensorType = sensorType;
        this.gasConcentration = gasConcentration;
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

    public Double getGasConcentration() {
        return gasConcentration;
    }

    public void setGasConcentration(Double gasConcentration) {
        this.gasConcentration = gasConcentration;
    }
}
