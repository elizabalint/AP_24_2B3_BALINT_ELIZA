public class Truck extends Vehicle {
    public int capacity;
    //default constructor
    public Truck() {
    }
    // constructor cu parametrul capacity
    public Truck(int capacity) {
        this.capacity = capacity;
    }

    public Truck(String name, Depot depot, int capacity) {
        super(name, depot);
        this.capacity = capacity;
    }

    public Truck(String name, int capacity) {
        super(name);
        this.capacity = capacity;
    }
    //getter
    public int getCapacity() {
        return capacity;
    }
    //setter
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    //adaugare client
    @Override
    public void addClient(Client closestClient) {
        super.addClient(closestClient);
    }
    // toString method
    @Override
    public String toString() {
        return "Truck{" +
                "capacity=" + capacity +
                ", name='" + name + '\'' +
                '}';
    }
}
