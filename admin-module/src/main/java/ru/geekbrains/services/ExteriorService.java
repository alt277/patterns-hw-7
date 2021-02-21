package ru.geekbrains.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Exterior;
import ru.geekbrains.repository.ExteriorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExteriorService {

    private ExteriorRepository exteriorRepository;

    public ExteriorService(ExteriorRepository exteriorRepository) {

        this.exteriorRepository = exteriorRepository;
    }
    public Optional<Exterior> findById(Long id) {
        return exteriorRepository.findById (id);
    }
    public Exterior findById2(Long id) {
        return exteriorRepository.findById2 (id);
    }

    public void deleteById(Long id) {
            exteriorRepository.deleteById(id);
    }
    public List<Exterior> findAll() {
        return exteriorRepository.findAll();
    }

    public void remove(Long id) {
        exteriorRepository.deleteById(id);
    }

    public Exterior save(Exterior exterior) {
        return exteriorRepository.save(exterior);
    }


}
