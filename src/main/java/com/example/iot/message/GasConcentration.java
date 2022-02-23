package com.example.iot.message;

public class GasConcentration {
    private Long houseSensorId;
    private SensorType sensorType;
    private Double gasConcentration;

    public GasConcentration(Long houseSensorId, SensorType sensorType, Double gasConcentration) {
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

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }

    public Double getGasConcentration() {
        return gasConcentration;
    }

    public void setGasConcentration(Double gasConcentration) {
        this.gasConcentration = gasConcentration;
    }
}
