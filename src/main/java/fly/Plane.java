package fly;

public class Plane {

    private int IDPlane;
    private String namePlane;
    private int seats;

    public Plane(int IDPlane, String namePlane, int seats) {
        this.IDPlane = IDPlane;
        this.namePlane = namePlane;
        this.seats = seats;
    }

    public int getIDPlane() {
        return IDPlane;
    }

    public void setIDPlane(int IDPlane) {
        this.IDPlane = IDPlane;
    }

    public String getNamePlane() {
        return namePlane;
    }

    public void setNamePlane(String namePlane) {
        this.namePlane = namePlane;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
