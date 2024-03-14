public class Drone extends Vehicle {
    public int duration;
    //defaul constructor
    public Drone() {
    }
    //constructor pentru name and duration
    public Drone(String name, int duration) {
        super(name);
        this.duration = duration;
    }
    //constructor pentru duration
    public Drone(int duration) {
        this.duration = duration;
    }
    //constructor pentru name, depot, duration
    public Drone(String name, Depot depot, int duration) {
        super(name, depot);
        this.duration = duration;
    }
    //getter pentru duration
    public int getDuration() {
        return duration;
    }
    //setter pentru duration
    public void setDuration(int duration) {
        this.duration = duration;
    }
    //adaugarea clientilor pentru drone
    @Override
    public void addClient(Client closestClient) {
        super.addClient(closestClient);
    }
    //metoda care afiseaza informatii despre o drona
    @Override
    public String toString() {
        return "Drone{" +
                "duration=" + duration +
                ", name='" + name + '\'' +
                '}';
    }
}
