package fly;

import fly.exceptions.DatabaseException;
import fly.utils.ConfiqUtils;

import java.sql.*;
import java.util.List;

public class DBStorage implements Storage {


    private Connection connection;

    public DBStorage() throws DatabaseException {
        connect();
    }

    @Override
    public void addPlane(Plane plane) throws Exception {
        Statement statement = connection.createStatement();
        String sql = "insert into plane (namePlane,number_of_seats) values('" + plane.getNamePlane()
                + "'," + plane.getSeats() + ")";
        System.out.println(statement.executeUpdate(sql));
    }

    @Override
    public List<Plane> getAllPlanes() throws Exception {
        return null;
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
        } catch (ClassNotFoundException cnfe) {
            throw new DatabaseException("No driver for MySQL found");
        } catch (SQLException sqle) {
            throw new DatabaseException("Unable to connect to MySQL with the given login and password");
        }
    }
}
