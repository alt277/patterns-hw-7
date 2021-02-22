package ru.geekbrains.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.entity.Car;
import ru.geekbrains.entity.CarMemento;

public interface CarMementoRepo extends JpaRepository<CarMemento, Long> {

    CarMemento findById2(Long id);
}
