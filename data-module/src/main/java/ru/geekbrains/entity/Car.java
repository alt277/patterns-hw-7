package ru.geekbrains.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "car")
public class Car {
@Id
@Column
private Long id;

@Column (name= "model")
private String model;

@Column (name= "brand")
private String brand;

@Column (name= "engine")
private double engine;

@Column (name= "horsePower")
private Long horsePower;

@Column (name = "exteriorId")
private Long exteriorId;

@Column (name = "interiorId")
private Long interiorId;


    public Car() {
    }

    public Car(Long id, String model, String brand, double engine,Long horsePower, Long exteriorId, Long interiorId) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.engine = engine;
        this.horsePower=horsePower;
        this.exteriorId = exteriorId;
        this.interiorId = interiorId;
    }
    public CarMemento saveConfiguration() {
        CarMemento carMemento = new CarMemento();
        carMemento.setModel(model);
        carMemento.setBrand(brand);
        carMemento.setEngine(engine);
        carMemento.setHorsePower(horsePower);
        carMemento.setInteriorId(interiorId);
        carMemento.setExteriorId(exteriorId);
        return carMemento;
    }
    public void restoreConfiguration(CarMemento snapshot) {
        model=snapshot.getModel();
        brand=snapshot.getBrand();
        engine=snapshot.getEngine();
        horsePower=snapshot.getHorsePower();
        interiorId = snapshot.getInteriorId();
        exteriorId = snapshot.getExteriorId();
    }


}
