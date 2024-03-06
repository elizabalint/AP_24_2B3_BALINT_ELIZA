import java.util.Objects;

public class Vehicle {
    private String name;
    private Depot depot;
    public Vehicle(String name) {
        this.name = name;
    }
    //getters
    public String getName() {
        return name;
    }

    public Depot getdepot() {
        return depot;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + (depot != null ? depot.getName() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(getName(), vehicle.getName()) && Objects.equals(getdepot(), vehicle.getdepot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getdepot());
    }
}
