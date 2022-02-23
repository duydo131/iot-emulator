package com.example.iot.message;

public class AddHouseMessage {
    private Long houseSensorId;
    private SensorType sensorType;
    private Boolean status;
    private Double gasConcentration;
    private Integer hum;
    private Integer temp;

    public AddHouseMessage(Long houseSensorId, SensorType sensorType, Boolean status, Double gasConcentration, Integer hum, Integer temp) {
        this.houseSensorId = houseSensorId;
        this.sensorType = sensorType;
        this.status = status;
        this.gasConcentration = gasConcentration;
        this.hum = hum;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getGasConcentration() {
        return gasConcentration;
    }

    public void setGasConcentration(Double gasConcentration) {
        this.gasConcentration = gasConcentration;
    }

    public Integer getHum() {
        return hum;
    }

    public void setHum(Integer hum) {
        this.hum = hum;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }
}
