package ru.geekbrains.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Interior;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InteriorRepository {
    private Connection connection;

    @Value("url")
    private String url;
    @Value("root")
    private String username;
    @Value("password")
    private String password;

    public InteriorRepository() throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(url, username, password);

    }

    public Interior findById(Long id) throws SQLException {

        Interior interior = new Interior();
        String str = "SELECT * FROM car_configurator.interior where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            interior.setId(resultSet.getLong(1));
            interior.setPanel(resultSet.getString(2));
            interior.setSeatMaterial(resultSet.getString(3));
            interior.setSeatMaterial(resultSet.getString(4));

        }
        return interior;
    }

    public List<Interior> findAll() throws SQLException {
        List<Interior> interiorList = new ArrayList<>();

        String str = "SELECT * FROM car_configurator.interior";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Interior interior = new Interior();

            interior.setId(resultSet.getLong(1));
            interior.setPanel(resultSet.getString(2));
            interior.setSeatMaterial(resultSet.getString(3));
            interior.setSeatMaterial(resultSet.getString(4));
            interiorList.add(interior);
        }
        return interiorList;
    }

    public void save(Interior interior) throws SQLException {

        String str = "insert into  car_configurator.interior values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        preparedStatement.setLong(1, interior.getId());
        preparedStatement.setString(2, interior.getPanel());
        preparedStatement.setString(3, interior.getSeatMaterial());
        preparedStatement.setString(4, interior.getSeatColor());
        preparedStatement.executeUpdate();

    }

    public void update(Interior interior) throws SQLException {

        String str = "UPDATE  car_configurator.interior set panel= ?,seatMaterial=?," +
                "seatColor=?  where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        preparedStatement.setString(1, interior.getPanel());
        preparedStatement.setString(2, interior.getSeatMaterial());
        preparedStatement.setString(3, interior.getSeatColor());
        preparedStatement.setLong(4, interior.getId());
        preparedStatement.executeUpdate();
    }

    public void deleteById(Long id) throws SQLException {

        String str = "delete from  car_configurator.interior where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();

    }

}

