package fly;

import fly.utils.ConfiqUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CSVStorage implements Storage {

    private File planeFile;
    private File airportsFile;
    private File flyFile;

    public CSVStorage() {
        planeFile = new File(ConfiqUtils.getProporties("planeFileName"));
        airportsFile = new File(ConfiqUtils.getProporties("airportsFilename"));
        flyFile = new File(ConfiqUtils.getProporties("flyFileName"));
    }


    @Override
    public void addPlane(Plane plane) throws Exception {
        FileWriter fileWriter = new FileWriter(planeFile,true);
        fileWriter.write(planeToCSV(plane));
        fileWriter.close();
    }

    @Override
    public List<Plane> getAllPlanes() throws Exception {
        List<Plane> planes = new ArrayList<>();
        FileReader fileReader = new FileReader(planeFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        do {
            line = reader.readLine();
            if (line != null) {
                Plane plane = csvToPlane(line);
                planes.add(plane);
            }
        } while (line != null);
        return planes;
    }

    @Override
    public void addAirport(Airports airport) throws Exception {
    FileWriter fileWriter = new FileWriter(airportsFile);
    fileWriter.write(airportsToCSV(airport));
    fileWriter.close();
    }

    @Override
    public List<Airports> getAllAirports() throws Exception {
        List<Airports> airport = new ArrayList<>();
        FileReader fileReader = new FileReader(airportsFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        do {
            line = reader.readLine();
            if (line != null) {
                Airports airports = csvToAirports(line);
                airport.add(airports);
            }
        }while (line != null);
        return airport;
    }

    @Override
    public void addFly(Fly fly) throws Exception {
    FileWriter fileWriter = new FileWriter(flyFile);
    fileWriter.write(flyToCSV(fly));
    fileWriter.close();
    }

    @Override
    public List<Fly> getAllFly() throws Exception {
        List<Fly> fly = new ArrayList<>();
        FileReader fileReader = new FileReader(flyFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        do {
            line = reader.readLine();
            if (line != null) {
                Fly flys = csvToFly(line);
                fly.add(flys);
            }
        }while (line != null);
        return fly;
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
