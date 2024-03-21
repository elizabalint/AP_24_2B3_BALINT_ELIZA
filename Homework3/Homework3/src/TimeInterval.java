import java.time.*;
class TimeInterval extends Pair<LocalTime, LocalTime> {
    // constructor care primeste doua LocalTime-uri pentru inceput și sfarsitul intervalului
    public TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
    }
    //constructor default
    public TimeInterval() {
    }
    //toString pentru afisarea intervalului de timp
    @Override
    public String toString() {
        return "TimeInterval{" +
                "startTime=" + getFirst() +
                ", endTime=" + getSecond() +
                '}';
    }
}
