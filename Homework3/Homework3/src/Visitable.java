import java.time.*;
import java.util.*;
public interface Visitable {
    // metodă pentru obtinerea orarului de vizitare, care returneaza o mapa de LocalDate si TimeInterval

    Map<LocalDate, TimeInterval> getTimetable();
    // metoda pentru obtinerea orei de deschidere intr-o anumita zi
    default LocalTime getOpeningHour(LocalDate date) {
        Map<LocalDate, TimeInterval> timetable = getTimetable();
        // obtinerea intervalului de timp pentru data specificata
        TimeInterval timeInterval = timetable.get(date);
        // verificarea daca exista un interval de timp pentru data specificata
        if (timeInterval != null) {
            return timeInterval.getFirst();
        } else {
            return null;
        }
    }
    String getName();
}
