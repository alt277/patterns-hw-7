package ru.geekbrains.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Exterior;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExteriorRepository {


    private Connection connection;
    @Value("url")
    private String url;
    @Value("root")
    private String username;
    @Value("password")
    private String password;

    public ExteriorRepository() throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(url, username, password);

    }

    public Exterior findById(Long id) throws SQLException {

        Exterior exterior = new Exterior();
        String str = "SELECT * FROM car_configurator.exterior where id= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            exterior.setId(resultSet.getLong(1));
            exterior.setColor(resultSet.getString(2));
            exterior.setTintedWindows(resultSet.getBoolean(3));
            exterior.setChromMoldings(resultSet.getBoolean(4));
            exterior.setWheelSize(resultSet.getDouble(5));
            exterior.setGrillDesign(resultSet.getString(6));
            exterior.setWheelDesign(resultSet.getString(7));
        }
        return exterior;
    }

    public List<Exterior> findAll() throws SQLException {
        List<Exterior> exteriorList = new ArrayList<>();
        String str = "SELECT * FROM car_configurator.exterior";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Exterior exterior = new Exterior();

            exterior.setId(resultSet.getLong(1));
            exterior.setColor(resultSet.getString(2));
            exterior.setTintedWindows(resultSet.getBoolean(3));
            exterior.setChromMoldings(resultSet.getBoolean(4));
            exterior.setWheelSize(resultSet.getDouble(5));
            exterior.setGrillDesign(resultSet.getString(6));
            exterior.setWheelDesign(resultSet.getString(7));

            exteriorList.add(exterior);

        }
        return exteriorList;
    }

    public void save(Exterior exterior) throws SQLException {

        String str = "insert into  car_configurator.exterior" +
                " (id,color,chromMoldings,tintedWindows,wheelSize,grillDesign,wheelDesign)" +
                " values (?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(str);
        preparedStatement.setLong(1, exterior.getId());
        preparedStatement.setString(2, exterior.getColor());
        preparedStatement.setBoolean(3, exterior.isTintedWindows());
        preparedStatement.setBoolean(4, exterior.isChromMoldings());
        preparedStatement.setDouble(5, exterior.getWheelSize());
        preparedStatement.setString(6, exterior.getGrillDesign());
        preparedStatement.setString(7, exterior.getWheelDesign());

        preparedStatement.addBatch();
        preparedStatement.executeBatch();
//        preparedStatement.executeUpdate();

    }

    public void update(Exterior exterior) throws SQLException {

        String str = "UPDATE  car_configurator.exterior set color= ?,tintedWindows=?," +
                "chromMoldings=?,wheelSize=?,grillDesign=?,wheelDesign=?  where id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        preparedStatement.setString(1, exterior.getColor());
        preparedStatement.setBoolean(2, exterior.isTintedWindows());
        preparedStatement.setBoolean(3, exterior.isChromMoldings());
        preparedStatement.setDouble(4, exterior.getWheelSize());
        preparedStatement.setString(5, exterior.getGrillDesign());
        preparedStatement.setString(6, exterior.getWheelDesign());
        preparedStatement.setLong(7, exterior.getId());
        preparedStatement.addBatch();
        preparedStatement.executeBatch();
        ;

    }

    public void deleteById(Long id) throws SQLException {

        String str = "delete from  car_configurator.exterior where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(str);

        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();

    }
}