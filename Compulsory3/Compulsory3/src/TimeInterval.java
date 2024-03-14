import java.time.*;
class TimeInterval extends Pair<LocalTime, LocalTime> {
        protected LocalTime startTime;
        protected LocalTime endTime;
    //constructor
    public TimeInterval(LocalTime first, LocalTime second, LocalTime startTime, LocalTime endTime) {
        super(first, second);
        this.startTime = startTime;
        this.endTime = endTime;
    }
    //getter pentru startTime
    public LocalTime getStartTime() {
        return startTime;
    }
    //setter pentru startTime
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    //getter pentru endTime
    public LocalTime getEndTime() {
        return endTime;
    }
    //setter pentru endTime
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    //toString pentru a afisa intervalul de timp
    @Override
    public String toString() {
        return "TimeInterval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
