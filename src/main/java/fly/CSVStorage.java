package fly;

import java.time.LocalDateTime;
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

    private Plane csvToPlane (String line) {
        Plane plane = new Plane();

        String[] fields = line.split(";");
        plane.setIDPlane(Integer.parseInt(fields[0]));
        plane.setNamePlane(fields[1]);
        plane.setSeats(Integer.parseInt(fields[2]));
        return plane;
    }

    private String airportsToCSV (Airports airports) {
        StringBuilder sb =new StringBuilder();
        sb.append(airports.getIDairports()).append(';')
                .append(airports.getNameAirports()).append(';');
        return sb.toString();
    }

    private Airports csvToAirports (String line) {
        Airports airports = new Airports();

        String[] fields = line.split(";");
        airports.setIDairports(Integer.parseInt(fields[0]));
        airports.setNameAirports(fields[1]);
        return airports;
    }

    private String flyToCSV (Fly fly) {
        StringBuilder sb =new StringBuilder();
        sb.append(fly.getIDfly()).append(';')
                .append(fly.getIDPlane()).append(';')
                .append(fly.getIDAirport_Departure()).append(';')
                .append(fly.getIDAirport_Arrival()).append(';')
                .append(fly.getTime_Departure()).append(';')
                .append(fly.getTime_Arrival()).append(';');
        return sb.toString();
    }

    private Fly csvToFly (String line) {
        Fly fly = new Fly();

        String[] fields = line.split(";");
        fly.setIDfly(Integer.parseInt(fields[0]));
        fly.setIDPlane(Integer.parseInt(fields[1]));
        fly.setIDAirport_Departure(Integer.parseInt(fields[2]));
        fly.setIDAirport_Arrival(Integer.parseInt(fields[3]));
        fly.setTime_Departure(LocalDateTime.parse(fields[4]));
        fly.setTime_Arrival(LocalDateTime.parse(fields[5]));
        return fly;
    }
}
