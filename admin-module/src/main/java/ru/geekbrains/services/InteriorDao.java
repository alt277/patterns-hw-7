package ru.geekbrains.services;

import ru.geekbrains.entity.Interior;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class InteriorDao {
    private final Map<Long, Interior> identityMap = new HashMap<>();
     private InteriorService interiorService;
    public Interior findById(Long myId) throws SQLException {

        Interior interior = identityMap.get(myId);
        if (interior == null) {

            interior = interiorService.findById2(myId);

            }
            if (interior != null) {
                identityMap.put(myId, interior);
            }

        return interior;
    }

    public void save(Interior interior) throws SQLException {

        identityMap.remove(interior.getId());

        //save to DB
      interiorService.save(interior);

        identityMap.remove(interior.getId());

    }
}
