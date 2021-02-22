package ru.geekbrains.services;

import ru.geekbrains.entity.Exterior;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExteriorDao {
    private final Map<Long, Exterior> identityMap = new HashMap<>();
    private ExteriorService exteriorService;

    public Exterior findById(Long myId) throws SQLException {

        Exterior exterior = identityMap.get(myId);
        if (exterior == null) {

            exterior = exteriorService.findById2(myId);

        }
        if (exterior != null) {
            identityMap.put(myId, exterior);
        }

        return exterior;
    }

    public void save(Exterior exterior) throws SQLException {

        identityMap.remove(exterior.getId());

        //save to DB
        exteriorService.save(exterior);

        identityMap.remove(exterior.getId());

    }
}
