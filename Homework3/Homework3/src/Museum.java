import java.time.LocalDate;
import java.util.Map;

public class Museum extends Attraction implements Visitable,Payable{
    //variabila pentru numele muzeului
    private String name;
    //variabila pentru intervalul orar
    private Map<LocalDate, TimeInterval> timetable;
    //variabila pentru pretul biletului
    private double ticketPrice;


    //constructor ce contine numele
    public Museum(String name) {
        this.name = name;
    }
    //default constructor
    public Museum() {
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

    // toString pentru a afisa informatii pentru museum
    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", timetable=" + timetable +
                ", ticketPrice=" + ticketPrice +
                '}';
    }

    //getter pentru pretul biletului
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
