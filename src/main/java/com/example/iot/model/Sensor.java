package com.example.iot.model;

public class Sensor {
    private Integer id;
    private Long idServer;
    private String sensorType;
    private Integer houseId;

    public Sensor() {
    }

    public Sensor(Integer id, Long idServer, String sensorType, Integer houseId) {
        this.id = id;
        this.idServer = idServer;
        this.sensorType = sensorType;
    }

    public Sensor(Long idServer, String sensorType) {
        this.idServer = idServer;
        this.sensorType = sensorType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getIdServer() {
        return idServer;
    }

    public void setIdServer(Long idServer) {
        this.idServer = idServer;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }
}
