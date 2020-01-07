package fly;

public class Airports {

    private int IDairports;
    private String nameAirports;

    public Airports(int IDairports, String nameAirports) {
        this.IDairports = IDairports;
        this.nameAirports = nameAirports;
    }
    public Airports(String nameAirports){
        this.nameAirports = nameAirports;
    }

    public Airports() {

    }

    public int getIDairports() {
        return IDairports;
    }

    public void setIDairports(int IDairports) {
        this.IDairports = IDairports;
    }

    public String getNameAirports() {
        return nameAirports;
    }

    public void setNameAirports(String nameAirports) {
        this.nameAirports = nameAirports;
    }

    @Override
    public String toString() {
        return "Airports{" +
                "IDairports=" + IDairports +
                ", nameAirports='" + nameAirports + '\'' +
                '}';
    }
}
