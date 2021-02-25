package ru.geekbrains.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.data.CarData;
import ru.geekbrains.entity.Car;

import java.util.List;

@Repository
public interface CarDataRepository extends JpaRepository<Car, Long> {

    @Query("select new ru.geekbrains.patterns-hw-7.data-module.data.CarData(c.model,c.brand,c.engine,c.horsePower ) from Car c")
    List<CarData> findAllCarData();
}

