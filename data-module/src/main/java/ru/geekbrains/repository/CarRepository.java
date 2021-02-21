package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.entity.Car;

public interface CarRepository extends JpaRepository <Car, Long> {
}
