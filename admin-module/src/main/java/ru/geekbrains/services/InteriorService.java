package ru.geekbrains.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Exterior;
import ru.geekbrains.entity.Interior;
import ru.geekbrains.repository.InteriorRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@RequiredArgsConstructor
@Service
public class InteriorService {

    private InteriorRepository interiorRepository;
    private final Map<Long, Interior> identityMap = new ConcurrentHashMap<>();

    public Interior findById(Long myId) throws SQLException {

        Interior interior = identityMap.get(myId);
        if (interior == null) {

            interior = interiorRepository.findById(myId);
        }
        if (interior != null) {
            identityMap.put(myId, interior);
        }
        return interior;
    }



    public List<Interior> findAll() throws SQLException {
        return interiorRepository.findAll();
    }

    public void save(Interior interior) throws SQLException {

        identityMap.remove(interior.getId());
        //save to DB
        interiorRepository.save(interior);

    }

    public void remove(Long id) throws SQLException {
        interiorRepository.deleteById(id);
    }

}
