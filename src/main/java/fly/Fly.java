package fly;

import java.time.LocalDateTime;

public class Fly {

    private int IDfly;
    private int IDAirport_Departure;
    private int IDAirport_Arrival;
    private int IDPlane;
    private LocalDateTime Time_Departure;
    private LocalDateTime Time_Arrival;

    public Fly(int IDfly, int IDAirport_Departure, int IDAirport_Arrival, int IDPlane, LocalDateTime time_Departure, LocalDateTime time_Arrival) {
        this.IDfly = IDfly;
        this.IDAirport_Departure = IDAirport_Departure;
        this.IDAirport_Arrival = IDAirport_Arrival;
        this.IDPlane = IDPlane;
        Time_Departure = time_Departure;
        Time_Arrival = time_Arrival;
    }

    public int getIDfly() {
        return IDfly;
    }

    public void setIDfly(int IDfly) {
        this.IDfly = IDfly;
    }

    public int getIDAirport_Departure() {
        return IDAirport_Departure;
    }

    public void setIDAirport_Departure(int IDAirport_Departure) {
        this.IDAirport_Departure = IDAirport_Departure;
    }

    public int getIDAirport_Arrival() {
        return IDAirport_Arrival;
    }

    public void setIDAirport_Arrival(int IDAirport_Arrival) {
        this.IDAirport_Arrival = IDAirport_Arrival;
    }

    public int getIDPlane() {
        return IDPlane;
    }

    public void setIDPlane(int IDPlane) {
        this.IDPlane = IDPlane;
    }

    public LocalDateTime getTime_Departure() {
        return Time_Departure;
    }

    public void setTime_Departure(LocalDateTime time_Departure) {
        Time_Departure = time_Departure;
    }

    public LocalDateTime getTime_Arrival() {
        return Time_Arrival;
    }

    public void setTime_Arrival(LocalDateTime time_Arrival) {
        Time_Arrival = time_Arrival;
    }
}
