package fly;

import java.time.LocalDateTime;
import java.util.List;

public class Program {
    public static void main (String [] args) throws Exception {
        Storage storage = new DBStorage();

//        storage.addPlane(new Plane("TY400",1200));
//       storage.addAirport(new Airports("Pulkovo"));
//       storage.addFly(new Fly( 4, 3, 1,
//                LocalDateTime.of(2020, 12, 31,12,43),
//                LocalDateTime.of(2021,1,1,8,10)));

        List<Plane> planes = storage.getAllPlanes();
        List<Airports> airports = storage.getAllAirports();
        List<Fly> fly = storage.getAllFly();
        for (int i = 0; i < fly.size(); i++)
        System.out.println(fly.get(i));
//        System.out.println(airports.size());
//        System.out.println(fly);
    }
}
