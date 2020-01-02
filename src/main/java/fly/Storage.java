package fly;

import java.util.List;

public interface Storage {
    void addPlane(Plane plane) throws Exception;
    List<Plane> getAllPlanes() throws Exception;
    void addAirport(Airports airport) throws Exception;
    List<Airports> getAllAirports() throws Exception;
    void addFly(Fly fly) throws Exception;
    List<Fly> getAllFly() throws Exception;
}
