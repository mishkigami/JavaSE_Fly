package fly;

import fly.exceptions.DatabaseException;
import fly.utils.ConfiqUtils;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBStorage implements Storage {


    private final String tableNamePlane = "plane";
    private final String idFieldplane = "idPlane";
    private final String nameFieldplane = "namePlane";
    private final String countSeatsplane = "number_of_seats";
    private final String tableNameAirports = "airports";
    private final String idFieldairports = "idAirports";
    private final String nameFieldAirports = "nameAirports";
    private final String tableNameFly = "fly";
    private final String fieldIdAirport_departure = "IdAirport_Departure";
    private final String idFieldAirports_arrival = "IdAirport_Arrival";
    private final String FieldTime_Departure = "Time_Departure";
    private final String FieldTime_Arrival = "Time_Arrival";



    private Connection connection;

    public DBStorage() throws DatabaseException {
        connect();
    }

    @Override
    public void addPlane(Plane plane) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "insert into plane (namePlane,number_of_seats) values('" + plane.getNamePlane()
                + "'," + plane.getSeats() + ")";
        statement.executeUpdate(sql);
    }

    @Override
    public List<Plane> getAllPlanes() throws Exception {
        Statement statement = connection.createStatement();
        List<Plane> planes = new ArrayList<>();
        String sql = "select * from " +tableNamePlane;
        statement.executeQuery(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            Plane plane = new Plane();
            plane.setIDPlane(resultSet.getInt(this.idFieldplane));
            plane.setNamePlane(resultSet.getString(this.nameFieldplane));
            plane.setSeats(resultSet.getInt(this.countSeatsplane));
            planes.add(plane);
        }
        return planes;
    }

    @Override
    public void addAirport(Airports airport) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "insert into airports (nameAirports) values('" + airport.getNameAirports() + "')";
        statement.executeUpdate(sql);
    }

    @Override
    public List<Airports> getAllAirports() throws Exception {
        Statement statement = connection.createStatement();
        List<Airports> airports = new ArrayList<>();
        String sql = "select * from " +tableNameAirports;
        statement.executeQuery(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            Airports airport = new Airports();
            airport.setIDairports(resultSet.getInt(this.idFieldairports));
            airport.setNameAirports(resultSet.getString(this.nameFieldAirports));
            airports.add(airport);
        }
        return airports;
    }

    @Override
    public void addFly(Fly fly) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "insert into fly (IdAirport_Departure, IdAirport_Arrival, IdPlane, Time_Departure, Time_Arrival)" +
                " values('" + fly.getIDAirport_Departure() + "'," + "'" + fly.getIDAirport_Arrival() + "',"
                + "'" + fly.getIDPlane() + "'," + "'" + fly.getTime_Departure() + "',"
                + "'" + fly.getTime_Arrival() + "')";
        statement.executeUpdate(sql);
    }

    @Override
    public List<Fly> getAllFly() throws Exception {
        Statement statement = connection.createStatement();
        List<Fly> flys = new ArrayList<>();
        String sql = "select * from " +tableNameFly;
        statement.executeQuery(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            Fly fly = new Fly();
            fly.setIDAirport_Departure(resultSet.getInt(this.fieldIdAirport_departure));
            fly.setIDAirport_Arrival(resultSet.getInt(this.idFieldAirports_arrival));
            fly.setIDPlane(resultSet.getInt(this.idFieldplane));
            fly.setTime_Departure(resultSet.getTimestamp(FieldTime_Departure).toLocalDateTime());
            fly.setTime_Arrival(resultSet.getTimestamp(FieldTime_Arrival).toLocalDateTime());
            flys.add(fly);
        }
        return flys;
    }

    private void connect() throws DatabaseException {
        try {
            Class.forName(ConfiqUtils.getProporties("className"));
            this.connection = DriverManager.getConnection(ConfiqUtils.getProporties("url")
                    ,ConfiqUtils.getProporties("login"),ConfiqUtils.getProporties("password"));
        } catch (ClassNotFoundException sqle) {
            throw new DatabaseException("No driver for MySQL found");
        } catch (SQLException sqle) {
            throw new DatabaseException("Unable to connect to MySQL with the given login and password");
        }
    }
}
