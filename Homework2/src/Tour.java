import java.util.*;

public class Tour {
    private Vehicle vehicle;
    private List<Client> clients = new ArrayList<>();
    // constructor pentru o variabila de tip Vehicle
    public Tour(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    // getter pentru o lista de clienti
    public List<Client> getClients() {
        return clients;
    }
    // getter pentru o variabila de tip vehicle
    public Vehicle getVehicle() {
        return vehicle;
    }
}
