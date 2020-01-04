package fly;

import fly.exceptions.DatabaseException;
import fly.utils.ConfiqUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBStorage implements Storage {


    private Connection connection;


    @Override
    public void addPlane(Plane plane) throws Exception {

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

    public DBStorage() throws DatabaseException {
        connect();
    }
}
