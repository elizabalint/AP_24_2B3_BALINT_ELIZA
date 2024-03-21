import java.time.LocalDate;
import java.util.*;

public class TravelPlan {
    // mapa care stocheaza planul de calatorie pentru fiecare zi, cu o lista de atractii asociate
    private Map<LocalDate, List<Attraction>> plan;
    //constructor
    public TravelPlan() {
        this.plan = new HashMap<>();
    }
    // metoda pentru adaugarea unei vizite la planul de calatorie
    public void addVisit(List<Attraction> attractions, LocalDate tripStart, LocalDate tripEnd) {
        if (plan == null) {
            plan = new HashMap<>();
        }
        // iterarea prin fiecare zi a calatoriei
        for (LocalDate date = tripStart; !date.isAfter(tripEnd); date = date.plusDays(1)) {
            for (Attraction attraction : attractions) {
                // verif if atractiile pot fi vizitate in ziua respectiva
                if (attraction.getTimetable().containsKey(date)) {
                    // obtinerea listei de atractii pentru data respectiva sau initializarea unei noi liste daca nu exista inca
                    List<Attraction> attractionsForDate = plan.getOrDefault(date, new LinkedList<Attraction>());
                    attractionsForDate.add(attraction);
                    plan.put(date, attractionsForDate);
                }
            }
        }
        // sortarea planului
        Map<LocalDate, List<Attraction>> sortedPlan = new TreeMap<>(plan);

        // afisarea planului calatorie
        System.out.println("Travel Plan: ");
        for (Map.Entry<LocalDate, List<Attraction>> entry : sortedPlan.entrySet()) {
            LocalDate key = entry.getKey();
            List<Attraction> attractions1 = entry.getValue();
            System.out.println(key + ":");
            for (Attraction attraction : attractions1) {
                System.out.println(" - " + attraction.getName() + attraction.getTimetable());
            }
        }}
    }
