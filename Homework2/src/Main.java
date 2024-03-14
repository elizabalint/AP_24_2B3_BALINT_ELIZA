import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // crearea unei instante a clasei Problema
        Problem problem = new Problem();
        // creare clienti
        Client client1 = new Client();
        client1.setName("Client 1");
        client1.setMinTime(LocalTime.of(8, 0));
        client1.setMaxTime(LocalTime.of(12, 30));
        System.out.println(client1.getName());
        Client client2 = new Client("Client 2");
        client2.setMinTime(LocalTime.of(2, 6));
        client2.setMaxTime(LocalTime.of(9, 2));
        System.out.println(client2);

        Client client3 = new Client("Client 3",
                LocalTime.NOON, LocalTime.MIDNIGHT);

        Client client4 = new Client("Client 4", ClientType.PREMIUM);
        client4.setMinTime(LocalTime.of(3, 6));
        client4.setMaxTime(LocalTime.of(3, 20));
        //creare depot
        Depot depot1 = new Depot("Depot1");
        Depot depot2 = new Depot("Depot2");
        //creare truks
        Truck truck1 = new Truck("Truck1", depot1, 100);
        Truck truck2 = new Truck("Truck2", depot2, 120);
        //creare drone
        Drone drone1 = new Drone("Drone1", depot1, 60);
        depot1.setVehicles(truck1);
        depot2.setVehicles(drone1);
        depot2.setVehicles(truck2);


        System.out.println(depot1);
        System.out.println(depot2);
        System.out.println(truck1);
        System.out.println(truck2);
        System.out.println(drone1);
        // adaugare clienti/depots/trucks in Problem
        problem.addClient(client1);
        problem.addClient(client2);
        problem.addClient(client3);
        problem.addClient(client4);
        problem.addDepot(depot1);
        problem.addDepot(depot2);
        problem.addVehicle(truck1);
        problem.addVehicle(truck2);
        problem.addVehicle(drone1);

        //afisarea tuturor vehiculelor
        List<Vehicle> allVehicles = problem.getVehicles();
        System.out.println("All vehicles:" +allVehicles);


    }
}