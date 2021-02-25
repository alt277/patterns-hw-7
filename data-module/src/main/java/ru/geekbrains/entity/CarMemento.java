package ru.geekbrains.entity;

import lombok.Data;

@Data
public class CarMemento {
    private String model;
    private String brand;
    private double engine;
    private Long horsePower;
    private Long interiorId;
    private Long exteriorId;


    public CarMemento() {
    }

    public CarMemento(String model, String brand, double engine,Long horsePower, Long interiorId, Long exteriorId) {
        this.model = model;
        this.brand = brand;
        this.engine = engine;
        this.horsePower=horsePower;
        this.interiorId = interiorId;
        this.exteriorId = exteriorId;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }
    public Long getHorsePower() {
        return horsePower;
    }
    public void setHorsePower(Long horsePower) {
        this.horsePower = horsePower;
    }
    public Long getInteriorId() {
        return interiorId;
    }

    public void setInteriorId(Long interiorId) {
        this.interiorId = interiorId;
    }

    public Long getExteriorId() {
        return exteriorId;
    }

    public void setExteriorId(Long exteriorId) {
        this.exteriorId = exteriorId;
    }
}
