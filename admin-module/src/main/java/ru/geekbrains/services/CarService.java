package ru.geekbrains.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Car;
import ru.geekbrains.repository.CarRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    };

    public Optional<Car> findById(Long id){
        return carRepository.findById(id);
    };

    public Car findById2(long id) {
        return carRepository.findById2(id);
    };

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    };

    public void save(Car car) throws IOException {
        carRepository.save(car);
    };

}
