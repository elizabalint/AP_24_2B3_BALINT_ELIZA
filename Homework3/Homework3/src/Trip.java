import java.time.LocalDate;
import java.util.*;
public class Trip {
    //variabila pentru numele orasului
    private String cityName;
    //variabila pentru perioada de timp
    protected LocalDate start, end;
    //lista dxe atractii
    protected List<Attraction> attractions= new ArrayList<>();
    //constructor ce contine ca parametri toate variabilele maentionate anterior
    public Trip(String cityName, LocalDate start, LocalDate end, List<Attraction> attractions) {
        this.cityName = cityName;
        this.start = start;
        this.end = end;
        this.attractions = attractions;
    }
    //constructor default
    public Trip() {

    }
    //construcotr pentru lista de atractii
    public Trip(List<Attraction> attractions) {
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
    //getters pentru periodOfTime
    public LocalDate getStart() {
        return start;
    }
    public LocalDate getEnd() {
        return end;
    }

    //setters pentru periodOfTime
    public void setStart(LocalDate start) {
        this.start = start;
    }
    public void setEnd(LocalDate end) {
        this.end = end;
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
                ", start=" + start +
                ", end=" + end +
                ", attractions=" + attractions +
                '}';
    }

    //metoda care verifica daca 2 obiecte sunt egale
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trip trip)) return false;
        return Objects.equals(getCityName(), trip.getCityName()) && Objects.equals(getStart(), trip.getStart()) && Objects.equals(getEnd(), trip.getEnd()) && Objects.equals(getAttractions(), trip.getAttractions());
    }

    //genereaza codul hash pentru Trip
    @Override
    public int hashCode() {
        return Objects.hash(getCityName(), getStart(), getEnd(), getAttractions());
    }

    //metoda pentru atractiile vizitabile pentru care nu exista pret de intrare
    public void visitableNotPayable() {
        // filtram atractiile care sunt vizitabile si nu necesita plata
        List<Attraction> visitableNotPayable = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && ! (attraction instanceof Payable)) {
                visitableNotPayable.add(attraction);
            }
        }
        // sortam dupa ora de deschidere
        Collections.sort(visitableNotPayable, new Comparator<Attraction>() {
            @Override
            public int compare(Attraction a1, Attraction a2) {
                return a1.compareTo(a2);
            }
        });
        //afisare
        System.out.println("Locatii vizitabile, not payable, sortate dupa ora de deschidere:");
        for (Attraction attraction : visitableNotPayable) {
            System.out.println(attraction);
        }
    }

}
