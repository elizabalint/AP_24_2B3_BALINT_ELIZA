import java.util.Arrays;
import java.util.Objects;

public class Depot {
    private String name;
    protected Vehicle[] vehicles;
    //constructors
    private Depot depot;
    // default constructor
    public Depot() {
    }
    // constructor cu parametrul name
    public Depot(String name) {
        this.name = name;
    }
    // constuctor cu numele si lista de vehicule
    public Depot(String name, Vehicle[] vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    //getters
    public String getName() {
        return name;
    }
    public Vehicle[] getVehicles() {
        return vehicles;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDepot(Depot depot) {
        this.depot = depot;
    }
    public void setVehicles(Vehicle... vehicles) {
        this.vehicles = vehicles;
        for(Vehicle v : vehicles) {
            v.setDepot(this.depot);
        }
    }
    // metoda toString
    @Override
    public String toString() {
        return "Depot{" +
                "name='" + name + '\'' +
                ", vehicles=" + Arrays.toString(vehicles) +
                '}';
    }
    // metoda equals care compara daca un depot este egal cu alt obiect
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Depot depot)) return false;
        return Objects.equals(getName(), depot.getName()) && Arrays.equals(getVehicles(), depot.getVehicles());
    }
    // genereaza hash code pentru depot
    @Override
    public int hashCode() {
        int result = Objects.hash(getName());
        result = 31 * result + Arrays.hashCode(getVehicles());
        return result;
    }

}
