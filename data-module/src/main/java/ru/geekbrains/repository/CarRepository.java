package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.entity.Car;
import ru.geekbrains.entity.CarMemento;

public interface CarRepository extends JpaRepository <Car, Long> {
    Car findById2(Long id);
}
