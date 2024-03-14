import java.time.LocalTime;
import java.util.Objects;

public class Client {
    private String name;
    private ClientType type;
    private LocalTime minTime;
    private LocalTime maxTime;

    //constructors
    public Client() {
    }
    public Client(String name, ClientType type, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.type = type;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public Client(String name) {
        this.name = name;
    }

    public Client(ClientType type) {
        this.type = type;
    }

    public Client(LocalTime minTime, LocalTime maxTime) {
        this.minTime = minTime;
        this.maxTime = maxTime;
    }

    public Client(String name, LocalTime minTime, LocalTime maxTime) {
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
    }
    public Client(String name, ClientType type) {
        this.name = name;
        this.type = type;
    }

    public Client(String s, int i) {

    }


    //getters
    public String getName() {
        return name;
    }
    public ClientType getType() {
        return type;
    }
    public LocalTime getMinTime() {
        return minTime;
    }
    public LocalTime getMaxTime() {
        return maxTime;
    }

    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(getName(), client.getName()) && getType() == client.getType() && Objects.equals(getMinTime(), client.getMinTime()) && Objects.equals(getMaxTime(), client.getMaxTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getMinTime(), getMaxTime());
    }
}
