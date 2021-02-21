package ru.geekbrains.services;


import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Interior;
import ru.geekbrains.repository.InteriorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InteriorService {

    private InteriorRepository interiorRepository;

    public InteriorService(InteriorRepository interiorRepository) {

        this.interiorRepository = interiorRepository;
    }
    public Optional<Interior> findById (Long id) {
        return interiorRepository.findById (id);
    }
    public Interior findById2(Long id) {
        return interiorRepository.findById2 (id);
    }

    public void deleteById(Long id) {
            interiorRepository.deleteById(id);
    }
    public List<Interior> findAll() {
        return interiorRepository.findAll();
    }

    public void remove(Long id) {
        interiorRepository.deleteById(id);
    }

    public Interior save(Interior interior) {
        return interiorRepository.save(interior);
    }


}
