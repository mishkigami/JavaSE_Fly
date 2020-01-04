package fly;

import fly.exceptions.DatabaseException;
import fly.utils.ConfiqUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBStorage implements Storage {


   // private final String tableName = "plane";
    private final String idField = "idPlane";
    private final String nameField = "namePlane";
    private final String countSeats = "number_of_seats";

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
        String sql = "select * from javase_fly.plane; ";
        statement.executeQuery(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
            Plane plane = new Plane();
            plane.setIDPlane(resultSet.getInt(this.idField));
            plane.setNamePlane(resultSet.getString(this.nameField));
            plane.setSeats(resultSet.getInt(this.countSeats));
            planes.add(plane);

        }


        return planes;

    }

    @Override
    public void addAirport(Airports airport) throws Exception {

    }

    @Override
    public List<Airports> getAllAirports() throws Exception {
        return null;
    }

    @Override
    public void addFly(Fly fly) throws Exception {

    }

    @Override
    public List<Fly> getAllFly() throws Exception {
        return null;
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
