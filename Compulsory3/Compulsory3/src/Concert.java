import java.time.*;
import java.util.Map;

public class Concert extends Attraction implements Visitable,Payable{
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;
    //cconstructor pentru timetable si ticketPrice
    public Concert(Map<LocalDate, TimeInterval> timetable, double ticketPrice) {
        this.timetable = timetable;
        this.ticketPrice = ticketPrice;
    }
    //default constructor
    public Concert() {
    }
    //condtructor pentru ticketPrice
    public Concert(double d) {
        this.ticketPrice=d;
    }
    //construcotr pentru timetable
    public Concert(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
    //setter pentru timetable
    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    //setter pentru ticketPrice
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    //toString pentru afisarea informatiilor pentru Concert
    @Override
    public String toString() {
        return "Concert{" +
                "timetable=" + timetable +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
    //getter pentru ticketPrice
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
