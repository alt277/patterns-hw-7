package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Car;
import ru.geekbrains.entity.CarMemento;


@Repository
public interface CarMementoRepo extends JpaRepository<CarMemento, Long> {

    CarMemento findCarById(Long id);
}
