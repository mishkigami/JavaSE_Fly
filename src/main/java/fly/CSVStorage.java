package fly;

import java.util.List;

public class CSVStorage implements Storage {
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

    private String planeToCSV (Plane plane) {
    StringBuilder sb =new StringBuilder();
    sb.append(plane.getIDPlane()).append(';')
            .append(plane.getNamePlane()).append(';')
            .append(plane.getSeats()).append(';');
    return sb.toString();
    }
}
