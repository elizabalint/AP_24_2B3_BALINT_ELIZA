import java.util.Objects;

public abstract class Vehicle {
    protected String name;
    protected Depot depot;
    //default constructor
    public Vehicle() {
    }
    //constructor cu nume si variabila de tip depot
    public Vehicle(String name, Depot depot) {
        this.name = name;
        this.depot = depot;
    }
    //constructor cu nume
    public Vehicle(String name) {
        this.name = name;
    }
    //getter pentru name
    public String getName() {
        return name;
    }
    //getter pentru depot
    public Depot getDepot() {
        return depot;
    }
    //setter pentru name
    public void setName(String name) {
        this.name = name;
    }
    //setter pentru depot
    public void setDepot(Depot depot) {
        this.depot = depot;
    }
    //toString method ce afiseaza informatii despre un anumit vehicul
    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + (depot != null ? depot.getName() : "null") +
                '}';
    }
    // metoda equals care compara daca un vehicul este egal cu alt obiect
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(getName(), vehicle.getName()) && Objects.equals(getDepot(), vehicle.getDepot());
    }
    // creeaza un hash code pentru vehicul
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDepot());
    }
    //metoda pentru a adauga clienti care este implementata in toate clasele care extind Vehicle
    public void addClient(Client closestClient) {
    }
}
