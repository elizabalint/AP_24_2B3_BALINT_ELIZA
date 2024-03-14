import java.util.*;
public class Trip {
    //variabila pentru numele orasului
    private String cityName;
    //variabila pentru perioada de timp
    private String periodOfTime;
    //lista dxe atractii
    private List<Attraction> attractions= new ArrayList<>();
    //constructor ce contine ca parametri toate variabilele maentionate anterior
    public Trip(String cityName, String periodOfTime, List<Attraction> attractions) {
        this.cityName = cityName;
        this.periodOfTime = periodOfTime;
        this.attractions = attractions;
    }
    //getter pentru cityName
    public String getCityName() {
        return cityName;
    }
    //setter pentru cityName
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    //getter pentru periodOfTime
    public String getPeriodOfTime() {
        return periodOfTime;
    }
    //setter pentru periodOfTime
    public void setPeriodOfTime(String periodOfTime) {
        this.periodOfTime = periodOfTime;
    }
    //getter pentru attractions
    public List<Attraction> getAttractions() {
        return attractions;
    }
    //setter pentru attractions
    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
    //metoda toString ce afiseaza informatii despre Trip
    @Override
    public String toString() {
        return "Trip{" +
                "cityName='" + cityName + '\'' +
                ", periodOfTime='" + periodOfTime + '\'' +
                ", attractions=" + attractions +
                '}';
    }
    //metoda care verifica daca 2 obiecte sunt egale
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip trip)) return false;
        return Objects.equals(getCityName(), trip.getCityName()) && Objects.equals(getPeriodOfTime(), trip.getPeriodOfTime()) && Objects.equals(getAttractions(), trip.getAttractions());
    }
    //genereaza codul hash pentru Trip
    @Override
    public int hashCode() {
        return Objects.hash(getCityName(), getPeriodOfTime(), getAttractions());
    }
}
