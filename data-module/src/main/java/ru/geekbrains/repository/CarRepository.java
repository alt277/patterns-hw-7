package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Car;

@Repository
public interface CarRepository extends JpaRepository <Car, Long> {
    Car findCarById(Long id);
}

