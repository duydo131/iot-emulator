package com.example.iot.model;

public class House {
    private Integer id;
    private Long idServer;
    private String name;

    public House(Integer id, Long idServer, String name) {
        this.id = id;
        this.idServer = idServer;
        this.name = name;
    }

    public House(Long idServer, String name) {
        this.idServer = idServer;
        this.name = name;
    }

    public House() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
