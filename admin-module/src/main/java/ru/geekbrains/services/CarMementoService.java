package ru.geekbrains.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.entity.CarMemento;
import ru.geekbrains.repository.CarMementoRepo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarMementoService {
    CarMementoRepo carMementoRepo;

    public List<CarMemento> findAll() {
        return carMementoRepo.findAll();
    }

    public Optional<CarMemento> findById(Long id) {
        return carMementoRepo.findById(id);
    }
    public CarMemento findById2(Long id) { return  carMementoRepo.findCarById(id); }

    public void deleteById(Long id) {
        carMementoRepo.deleteById(id);
    }

    public void save(CarMemento carMemento) throws IOException {
        carMementoRepo.save(carMemento);
    }
}
