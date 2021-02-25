package ru.geekbrains.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Exterior;
import ru.geekbrains.entity.Interior;
import ru.geekbrains.repository.ExteriorRepository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class ExteriorService {

    private ExteriorRepository exteriorRepository;
    private final Map<Long, Exterior> identityMap = new ConcurrentHashMap<>();


    public Exterior findById(Long myId) throws SQLException {

        Exterior exterior = identityMap.get(myId);
        if (exterior == null) {

            exterior = exteriorRepository.findById(myId);
        }
        if (exterior != null) {
            identityMap.put(myId, exterior);
        }
        return exterior;
    }

    public List<Exterior> findAll() throws SQLException {
        return exteriorRepository.findAll();
    }

    public void save(Exterior exterior) throws SQLException {

        identityMap.remove(exterior.getId());
        //save to DB
        exteriorRepository.save(exterior);
    }

    public void remove(Long id) throws SQLException {
        exteriorRepository.deleteById(id);
    }
}
