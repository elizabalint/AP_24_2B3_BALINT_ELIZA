import java.awt.*;
import java.util.*;
import java.util.List;
import java.time.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //creez o variabila de tip Concert
        Concert concert = new Concert();
        Map<LocalDate, TimeInterval> newTimetable = new HashMap<>();
        LocalDate date = LocalDate.of(2024, 3, 13);
        TimeInterval interval = new TimeInterval(LocalTime.MIDNIGHT, LocalTime.NOON, LocalTime.now(), LocalTime.NOON);
        newTimetable.put(date, interval);
        concert.setTimetable(newTimetable);
        newTimetable.put(date, interval);
        concert.setTicketPrice(50);
        //creez o variabila de tip statue
        Statue statue = new Statue("da");
        statue.setTicketPrice(11);
        Church church = new Church("VIV");

        // lista de atractii
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(concert);
        attractions.add(statue);
        attractions.add(church);

        Trip trip = new Trip("New York", "Weekend", attractions);

        System.out.println("Trip Details:");
        System.out.println(trip);

    }
}
