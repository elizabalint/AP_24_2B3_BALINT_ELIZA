import java.time.LocalDate;
import java.util.Map;

public class Church extends Attraction implements Visitable{
    private String name;
    private Map<LocalDate, TimeInterval> timetable;
    //setter pentru timetable
    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
    //getter pentru timetable
    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    //constructor pentru name
    public Church(String name) {
        this.name=name;
    }
    //getter pentru name
    public String getName() {
        return name;
    }
    //setter pentru name
    public void setName(String name) {
        this.name = name;
    }
    //toString pentu a afisa ingormatii despre Church

    @Override
    public String toString() {
        return "Church{" +
                "name='" + name + '\'' +
                ", timetable=" + timetable +
                '}';
    }
}
