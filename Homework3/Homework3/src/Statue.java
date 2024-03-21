import java.time.LocalDate;
import java.util.Map;

public class Statue extends Attraction implements Visitable,Payable{
    private String name;
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;


    //constructor ce contine numele
    public Statue(String name) {
        this.name = name;
    }
    //default constructor
    public Statue() {
    }
    //getter pentru name
    @Override
    public String getName() {
        return name;
    }

    //setter pentru name
    public void setName(String name) {
        this.name = name;
    }
    //setter pentru timetable
    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
    //setter pentru ticketPrice
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    // toString pentru a afisa informatii pentru statue
    @Override
    public String toString() {
        return "Statue{" +
                "name='" + name + '\'' +
                ", timetable=" + timetable +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    //getter pentru price
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    //getter pentru timetable
    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }
}
