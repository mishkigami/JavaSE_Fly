package fly;

import java.time.LocalDateTime;
import java.util.List;

public class Program {
    public static void main (String [] args) throws Exception {
        Storage storage = new CSVStorage();

        storage.addPlane(new Plane(1,"TY134",13));
        storage.addAirport(new Airports(2,"Pulkovo"));
        storage.addFly(new Fly(3, 4, 23, 1,
                LocalDateTime.of(2020, 12, 31,12,43),
                LocalDateTime.of(2021,1,1,8,10)));

        List<Plane> planes = storage.getAllPlanes();
        List<Airports> airports = storage.getAllAirports();
        List<Fly> fly = storage.getAllFly();

        System.out.println(planes.size());
        System.out.println(airports.size());
        System.out.println(fly);
    }
}
