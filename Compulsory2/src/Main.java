import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        Client client1 = new Client();
        client1.setName("Client 1");
        client1.setMinTime(LocalTime.of(8, 0));
        client1.setMaxTime(LocalTime.of(12, 30));
        System.out.println(client1.getName());
        Client client2 = new Client("Client 2");
        System.out.println(client2);

        Client client3 = new Client("Client 3",
                LocalTime.NOON, LocalTime.MIDNIGHT);

        Client client4 = new Client("Client 4", ClientType.PREMIUM);

        Vehicle vehicul1 = new Vehicle("Vehicul 1");
        Vehicle vehicul2 = new Vehicle("Vehicul 2");
        Vehicle vehicul3 = new Vehicle("Vehicul 3");
        Depot d1 = new Depot("Depot 1");
        d1.setVehicles(vehicul1, vehicul2);
        Depot d2 = new Depot("Depot 2");
        d2.setVehicles(vehicul3);

        Vehicle car = new Vehicle("Car");
        Vehicle bus = new Vehicle("Bus");
        Vehicle[] vehicles = {car, bus};
        Depot depot = new Depot("Depot 1", vehicles);
        bus.setDepot(depot);
        System.out.println(bus.toString());

        System.out.println(car.toString());
        System.out.println(depot.toString());

        Vehicle vehicle = new Vehicle("Car");
        vehicle.setDepot(depot);
        System.out.println(vehicle.toString());


    }
}