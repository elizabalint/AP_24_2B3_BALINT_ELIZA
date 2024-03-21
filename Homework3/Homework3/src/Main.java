import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        //crare obiecte de tip Concert
        //crearea unui concert cu numele "Concert1"
        Concert concert1 = new Concert("Concert1");
        // setarea datei pentru Concert1
        Map<LocalDate, TimeInterval> concert1Timetable = new HashMap<>();
        // stabilirea intervalului orar pentru Concert1
        LocalDate concert1Date = LocalDate.of(2024, 3, 13);
        TimeInterval concert1Interval = new TimeInterval(LocalTime.of(20, 00), LocalTime.of(22, 00));
        concert1Timetable.put(concert1Date, concert1Interval);
        concert1.setTimetable(concert1Timetable);
        // setarea pretului biletului pentru Concert1
        concert1.setTicketPrice(50);
        //similar cu Concert1
        Concert concert2 = new Concert("Concert2");
        Map<LocalDate, TimeInterval> concert2Timetable = new HashMap<>();
        LocalDate concert2Date = LocalDate.of(2024, 3, 14);
        TimeInterval concert2Interval = new TimeInterval(LocalTime.of(19, 30), LocalTime.of(21, 30));
        concert2Timetable.put(concert2Date, concert2Interval);
        concert2.setTimetable(concert2Timetable);
        concert2.setTicketPrice(60);

        //crare obiecte de tip Museum, similar cu Concert
        Museum museum1 = new Museum("Muzeu1");
        Map<LocalDate, TimeInterval> museum1Timetable = new HashMap<>();
        LocalDate museum1Date = LocalDate.of(2024, 3, 15); // Data diferită pentru museum1
        TimeInterval museum1Interval = new TimeInterval(LocalTime.of(10, 00), LocalTime.of(16, 00));
        museum1Timetable.put(museum1Date, museum1Interval);
        museum1.setTimetable(museum1Timetable);
        museum1.setTicketPrice(11);

        Museum museum2 = new Museum("Muzeu2");
        Map<LocalDate, TimeInterval> museum2Timetable = new HashMap<>();
        LocalDate museum2Date = LocalDate.of(2024, 3, 14);
        TimeInterval museum2Interval = new TimeInterval(LocalTime.of(10, 00), LocalTime.of(16, 00));
        museum2Timetable.put(museum2Date, museum2Interval);
        museum2.setTimetable(museum2Timetable);
        museum2.setTicketPrice(15);

        //creare obiecte de tip Church, similar cu Concert si Museum, doar ca fara TicketPrice
        Church church1 = new Church("Biserica1");
        Map<LocalDate, TimeInterval> church1Timetable = new HashMap<>();
        LocalDate church1Date = LocalDate.of(2024, 3, 14);
        TimeInterval church1Interval = new TimeInterval(LocalTime.of(9, 00), LocalTime.of(13, 00));
        church1Timetable.put(church1Date, church1Interval);
        church1.setTimetable(church1Timetable);

        Church church2 = new Church("Biserica2");
        Map<LocalDate, TimeInterval> church2Timetable = new HashMap<>();
        LocalDate church2Date = LocalDate.of(2024, 3, 15);
        TimeInterval church2Interval = new TimeInterval(LocalTime.of(8, 30), LocalTime.of(12, 30));
        church2Timetable.put(church2Date, church2Interval);
        church2.setTimetable(church2Timetable);

        // Lista de atracții
        List<Attraction> attractions = new ArrayList<>();
        attractions.add(concert1);
        attractions.add(concert2);
        attractions.add(museum1);
        attractions.add(museum2);
        attractions.add(church1);
        attractions.add(church2);

        // data de inceput si de sf a vizitarii
        LocalDate tripStart = LocalDate.of(2024, 3, 13);
        LocalDate tripEnd = LocalDate.of(2024, 3, 15);

        // obiect Trip
        Trip trip = new Trip("New York", tripStart, tripEnd, attractions);

        // atractii vizitabile fara plata
        trip.visitableNotPayable();

        //detalii calatorie
        System.out.println("Trip Details:");
        System.out.println(trip);

        //orele de deschidere a atractiilor dintr-o anumita zi
        LocalDate dateOpening = LocalDate.of(2024, 3, 13);
        for (Attraction attraction : attractions) {
            if (attraction.getOpeningHour(dateOpening) != null) {
                System.out.println("Attraction: " + attraction.getName() + " has opening hour:" + attraction.getOpeningHour(dateOpening));
            } else {
                System.out.println("Attraction: " + attraction.getName() + " is closed today.");
            }
        }

        // program de vizitare in zilele in care persoana viziteaza orasul
        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addVisit(trip.getAttractions(), tripStart, tripEnd);
    }
}
