import java.util.ArrayList;
import java.util.List;


public class Problem {
    /**
     * array for depots
     */
    protected ArrayList<Depot> depots = new ArrayList<>();
    /**
     * array for vehicles
     */
    protected ArrayList<Vehicle> vehicles = new ArrayList<>();
    /**
     * array for clients
     */
    protected ArrayList<Client> clients = new ArrayList<>();

    /**
     * default constructor
     */
    public Problem() {
    }

    /**
     * constructor with all the parametres
     * @param depots
     * @param vehicles
     * @param clients
     */
    public Problem(ArrayList<Depot> depots, ArrayList<Vehicle> vehicles, ArrayList<Client> clients) {
        this.depots = depots;
        this.vehicles = vehicles;
        this.clients = clients;
    }

    /**
     *
     * @return return an array of depots
     */
    public ArrayList<Depot> getDepots() {
        return depots;
    }

    /**
     *
     * @param depots Accepts an array of depots and set it
     */
    public void setDepots(ArrayList<Depot> depots) {
        this.depots = depots;
    }
    /**
     *
     * @param vehicles Accepts an array of vehicles and set it
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    /**
     *
     * @return return an array of clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }
    /**
     *
     * @param clients Accepts an array of clients and set it
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    /**
     *
     * @return return a string with all the arrays from the Problem class
     */
    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + depots +
                ", vehicles=" + vehicles +
                ", clients=" + clients +
                '}';
    }

    /**
     *
     * @param depot add a depot in the depots array
     */
    public void addDepot(Depot depot) {
        depots.add(depot);
    }
    /**
     *
     * @param client add a client in the clients array
     */
    public void addClient(Client client) {
        clients.add(client);
    }
    /**
     *
     * @param vehicle add a vehicle in the vehicles array
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     *
     * @return return an array of all the vehicles, form all depots.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

}