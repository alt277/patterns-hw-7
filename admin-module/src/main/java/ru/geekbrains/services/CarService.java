package ru.geekbrains.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Car;
import ru.geekbrains.repository.CarRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService {
    CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    };

    public Optional<Car> findById(Long id){
        return carRepository.findById(id);
    }

    public Car findCarById(long id) {
        return carRepository.findCarById(id);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    public void save(Car car) throws IOException {
        carRepository.save(car);
    }

}
